package edu.java.spring.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJdbcDAO {

  private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class.getName());

  private DriverManagerDataSource dataSource;

  @Autowired
  private PlatformTransactionManager transactionManager;

  private String insertQuery;

  private String updateAgeByNameSQL;

  private String deleteByNameSQL;

  private JdbcTemplate jdbcTemplate;

  public void setDataSource(DriverManagerDataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void setInsertQuery(String insertQuery) {
    this.insertQuery = insertQuery;
  }

  public void setUpdateAgeByNameSQL(String updateAgeByNameSQL) {
    this.updateAgeByNameSQL = updateAgeByNameSQL;
  }

  public void setDeleteByName(String deleteByName) {
    this.deleteByNameSQL = deleteByName;
  }

  public PlatformTransactionManager getTransactionManager() {
    return transactionManager;
  }

  private void createTableIfNotExist() {
    try {
      DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
      ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
      if (rs.next()) {
        LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists!");
        return;
      }

      jdbcTemplate.execute("CREATE TABLE STUDENT ("
          + " id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
          + " name VARCHAR(1000),"
          + " age INTEGER)"
      );
    } catch (SQLException e) {
    }

  }

  public void insert(String name, Integer age) {
    jdbcTemplate.update(insertQuery, name, age);
    LOGGER.info("Created Record Name = " + name + " Age = " + age);
  }

  public void updateAgeByName(String name, Integer age) {
    jdbcTemplate.update(updateAgeByNameSQL, age, name);
  }

  public void deleteByName(String name) {
    jdbcTemplate.update(deleteByNameSQL, name);
  }

  public int totalRecord() {
    return jdbcTemplate.execute((Statement statement) -> {
      ResultSet rs = statement.executeQuery("select count(*) from student");
      return rs.next() ? rs.getInt(1) : 0;
    });
  }

  private final static class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
      try {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setAge(rs.getInt("age"));
        student.setName(rs.getString("name"));
        return student;
      } catch (Exception exp) {
        LOGGER.error(exp, exp);
        return null;
      }
    }
  }

  public List loadStudent(String name) {
    return jdbcTemplate
        .query("SELECT * FROM STUDENT WHERE NAME LIKE '%" + name + "%'", new StudentRowMapper());
  }

  public int[] add(List<Student> students) {
    List<Object[]> batch = new ArrayList();
    students.forEach(student -> {
      System.out.println(student.getName() + " " + student.getAge());
      batch.add(new Object[]{student.getName(), student.getAge()});
    });
    return jdbcTemplate.batchUpdate(insertQuery, batch);
  }

  public void save(Object name, Object age) {
    TransactionDefinition def = new DefaultTransactionDefinition();
    TransactionStatus status = transactionManager.getTransaction(def);

    String countQuery = "SELECT COUNT(*) FROM STUDENT";

    try {
      Integer total = jdbcTemplate.queryForObject(countQuery, Integer.class);
      LOGGER.info("before save data, total record is " + total);

      String sql = "insert into Student (name, age) values (?, ?)";
      jdbcTemplate.update(sql, name, age);

      total = jdbcTemplate.queryForObject(countQuery, Integer.class);
      LOGGER.info("after save data, total record is " + total);

      String countQuery2 = "SELECT COUNT(* FROM STUDENT";
      total = jdbcTemplate.queryForObject(countQuery2, Integer.class);

      System.out.println("Da chay duoc den dong lenh nay ma khong xay ra Exception");

      transactionManager.commit(status);
    } catch (Exception e) {
      transactionManager.rollback(status);

      Integer total = jdbcTemplate.queryForObject(countQuery, Integer.class);
      LOGGER.info("after rollback, total record is " + total);

    }
  }
}

package edu.java.spring.dao.impl;

import edu.java.spring.dao.StudentDAO;
import edu.java.spring.model.Student;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class StudentDAOImpl implements StudentDAO, DisposableBean {

  private static Logger LOGGER = Logger.getLogger(StudentDAOImpl.class.getName());

  private DriverManagerDataSource dataSource;

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DriverManagerDataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @PostConstruct
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

  @Override
  public void insert(Student student) {
    jdbcTemplate.update("INSERT INTO STUDENT (name, age) VALUES (?, ?)", student.getName(),
        student.getAge());
    LOGGER.info("Created Record Name = " + student.getName());
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

  @Override
  public List list() {
    return jdbcTemplate
        .query("SELECT * FROM STUDENT", new StudentRowMapper());
  }

  @Override
  public List listByQuery(String query) {
    return jdbcTemplate.query(query, new StudentRowMapper());
  }

  @Override
  public void destroy() throws Exception {
    DriverManager.getConnection("jdbc:derby:C:/Java/sampledb;shutdown=true");
  }

  @Override
  public void delete(int id) {
    jdbcTemplate.execute("DELETE FROM STUDENT WHERE ID = " + id);
  }

  @Override
  public Student get(int id) {
    return jdbcTemplate
        .queryForObject("SELECT * FROM STUDENT WHERE ID = " + id, new StudentRowMapper());
  }

  @Override
  public void update(Student student) {
    jdbcTemplate
        .update("UPDATE STUDENT SET NAME = ? WHERE ID = ?", student.getName(), student.getId());
  }
}

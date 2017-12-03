package edu.java.spring.controller;

import edu.java.spring.dao.StudentDAO;
import edu.java.spring.model.Student;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {

  @Autowired
  private StudentDAO studentDAO;

  @RequestMapping(value = "student/add", method = RequestMethod.GET)
  public ModelAndView add() {
    return new ModelAndView("student.form", "command", new Student());
  }

  @RequestMapping(value = "student/save", method = RequestMethod.POST)
  public ModelAndView save(@Valid @ModelAttribute("command") Student student,
      BindingResult result) {
    if (result.hasErrors()) {
      ModelAndView model = new ModelAndView("student.form", "command", student);
      model.addObject("errors", result);
      return model;
    }
    if (student.getId() > 0) {
      studentDAO.update(student);
    } else {
      studentDAO.insert(student);
    }
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("student.view");
//    mv.addObject("student", student);
//    return mv;
    return new ModelAndView("redirect:/student/list");
  }

  @RequestMapping(value = "/student/list", method = RequestMethod.GET)
  public ModelAndView listStudents(@RequestParam(value = "q", required = false) String query) {
    ModelAndView model = new ModelAndView();
    model.setViewName("student.list");
    if (query == null) {
      model.addObject("students", studentDAO.list());
    } else {
      model.addObject("students", studentDAO.listByQuery(query));
    }
    return model;
  }

  @RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
  public String delete(@PathVariable String id) {
    studentDAO.delete(Integer.parseInt(id));
    return "redirect:/student/list";
  }

  @RequestMapping(value = "/student/edit/{id}", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable int id) {
    Student student = studentDAO.get(id);
    return new ModelAndView("/student/student.form", "command", student);

  }

  @RequestMapping(value = "student/edit/save", method = RequestMethod.POST)
  public String saveEdit() {
    return "forward:/student/save";
  }

  @RequestMapping(value = "/student/json/{id}", method = RequestMethod.GET)
  public @ResponseBody
  Student viewJson(@PathVariable int id) {
    return studentDAO.get(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "redirect:/student/list";
  }

  @RequestMapping(value = "/student/avatar/save", method = RequestMethod.POST)
  public String handleFormUpload(@RequestParam("file") MultipartFile file,
      @RequestParam("id") int id, HttpServletRequest request)
      throws IOException {
    if (file.isEmpty()) {
      return "student.error";
    }

    System.out.println(id);
    Path avatarPath = getImageFile(request, id);

    Files.write(avatarPath, file.getBytes(), StandardOpenOption.CREATE);

    System.out.println(avatarPath);

    return "redirect:/student/list";

  }

  private Path getImageFile(HttpServletRequest request, int id) {
    ServletContext servletContext = request.getSession().getServletContext();
    String diskPath = servletContext.getRealPath("/");
    File folder = new File(diskPath + File.separator + "avatar" + File.separator);
    folder.mkdirs();
    return new File(folder, String.valueOf(id) + ".jpg").toPath();
  }

  @RequestMapping(value = "/student/avatar/{id}", method = RequestMethod.GET)
  public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id, HttpServletRequest request)
      throws IOException {
    ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
    if (id != null) {
      Path avatarPath = getImageFile(request, id);
      if (Files.exists(avatarPath)) {
        byteOutput.write(Files.readAllBytes(avatarPath));
      }
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);
    return new ResponseEntity<byte[]>(byteOutput.toByteArray(), headers, HttpStatus.CREATED);
  }

}

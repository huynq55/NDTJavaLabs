package edu.java.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value = "/upload", name = "upload-servlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class UploadServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String appPath = req.getServletContext().getRealPath("");
    System.out.println("----------" + appPath);
    File folder = new File(appPath, "temp");
    if (!folder.exists()) {
      folder.mkdir();
    }

    for (Part part : req.getParts()) {
      String name = extractFileName(part);
      byte[] buff = new byte[4 * 1024];
      int read = -1;
      OutputStream outputStream = new FileOutputStream(new File(folder, name));

      InputStream inputStream = part.getInputStream();
      while ((read = inputStream.read(buff)) != -1) {
        outputStream.write(buff);
      }

      outputStream.close();

    }

    resp.getWriter().print("Upload has been done successfully!");


  }

  private String extractFileName(Part part) {
    String content = part.getHeader("content-disposition");
    Pattern pattern = Pattern.compile(".*filename\\=\"(.*)\".*");
    Matcher matcher = pattern.matcher(content);
    return matcher.matches() ? matcher.group(1) : "unknown";
  }
}

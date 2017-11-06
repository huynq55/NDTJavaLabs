package edu.java.web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipServletResponseWrapper extends HttpServletResponseWrapper {

  private GZipServletOutputStream stream = null;
  private PrintWriter writer = null;

  public GZipServletResponseWrapper(HttpServletResponse response) {
    super(response);
  }

  public void close() throws IOException {
    if (writer != null) {
      writer.close();
    }
    if (stream != null) {
      stream.close();
    }
  }

  public void flushBuffer() throws IOException {
    if (writer != null) {
      writer.flush();
    }
    if (stream != null) {
      stream.flush();
    }
  }

  public GZipServletOutputStream getOutputStream() throws IOException {
    if (stream != null) {
      return stream;
    }
    stream = new GZipServletOutputStream(getResponse().getOutputStream());
    return stream;
  }

  public PrintWriter getWriter() throws IOException {
    if (writer == null) {
      stream = getOutputStream();
      String encoding = getResponse().getCharacterEncoding();
      writer = new PrintWriter(new OutputStreamWriter(stream, encoding));
    }
    return writer;
  }
}

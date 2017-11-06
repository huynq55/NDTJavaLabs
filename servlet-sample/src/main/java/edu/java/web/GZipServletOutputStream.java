package edu.java.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletOutputStream;

public class GZipServletOutputStream extends ServletOutputStream {

  private GZIPOutputStream stream = null;

  public GZipServletOutputStream(OutputStream output) throws IOException {
    stream = new GZIPOutputStream(output);
  }

  @Override
  public void close() throws IOException {
    stream.close();
  }

  @Override
  public void flush() throws IOException {
    stream.flush();
  }

  public void write(int b) throws IOException {
    stream.write(b);
  }

  @Override
  public void write(byte bytes[]) throws IOException {
    stream.write(bytes);
  }

  @Override
  public void write(byte bytes[], int off, int len) throws IOException {
    stream.write(bytes, off, len);
  }
}

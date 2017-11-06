package edu.java.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/html"})
public class GzipFilter implements Filter {

  public void destroy() {
    System.out.println("\n Destroy filter!\n");
  }

  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("\n Destroy filter!\n");
  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

    String encoding = httpRequest.getHeader("Accept-Encoding");
    if (encoding != null && encoding.indexOf("gzip") > -1) {
      httpResponse.addHeader("Content-Encoding", "gzip");
      GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(httpResponse);
      filterChain.doFilter(httpRequest, gzipResponse);
      gzipResponse.close();
    } else {
      filterChain.doFilter(httpRequest, httpResponse);
    }
  }
}

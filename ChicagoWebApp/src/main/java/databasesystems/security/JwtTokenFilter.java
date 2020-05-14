package databasesystems.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import databasesystems.exception.CustomException;
import javax.servlet.http.Cookie;


public class JwtTokenFilter extends GenericFilterBean {

  private JwtTokenProvider jwtTokenProvider;

  public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
      throws IOException, ServletException {
      HttpServletResponse responsee=(HttpServletResponse)res;
      HttpServletRequest request=(HttpServletRequest)req;
      System.out.println("DAAMDDAMDAMDAMDAADAMDA " +request.getHeader("Authorization"));
      Cookie[] cookies =request.getCookies();
      String token;

    try {
        if (cookies!=null)
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("jwtCookie")){
                    token = cookies[i].getValue();
                    if (token != null && jwtTokenProvider.validateToken(token)) {
                        Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
                        SecurityContextHolder.getContext().setAuthentication(auth);
                        System.out.println("WTF:"+request.getHeader("Authorization"));
                        responsee.addHeader("Authorization", request.getHeader("Authorization"));
                        responsee.addCookie(cookies[i]);
                    }else
                        System.out.println("gamisoy");
                    break;
                }
            }
    } catch (CustomException ex) {
      System.out.println("edw");
      HttpServletResponse response = (HttpServletResponse) res;
      
      response.sendError(ex.getHttpStatus().value(), ex.getMessage());
      return;
    }

    filterChain.doFilter(request, responsee);
  }

}
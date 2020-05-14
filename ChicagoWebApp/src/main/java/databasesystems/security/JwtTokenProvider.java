package databasesystems.security;

import databasesystems.domain.MyUser;
import databasesystems.exception.CustomException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static io.jsonwebtoken.security.Keys.secretKeyFor;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Component
public class JwtTokenProvider {

  /**
   * THIS IS NOT A SECURE PRACTICE! For simplicity, we are storing a static key here. Ideally, in a
   * microservices environment, this key would be kept on a config-server.
   */
  
  @Value("${security.jwt.token.secret-key:secret-key}")
  public String secretKey/*="12121212121212121212121212121211"*/;

  @Value("${security.jwt.token.expire-length:3600000}")
  private long validityInMilliseconds = 3600000; // 1h

  @Autowired
  private MyUserDetails myUserDetails;

  
  @PostConstruct
  protected void init() throws UnsupportedEncodingException {
    secretKey="ennafamekreppapoutorubiknapellanetepoushtoneoi";
    Base64.getEncoder().encodeToString(secretKey.getBytes("UTF-8"));
  }
  
  
  public String createToken(String username) {
    Claims claims = Jwts.claims().setSubject(username);
    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds);
    return Jwts.builder()//
        .setClaims(claims)//
        .setIssuedAt(now)//
        .setExpiration(validity)//
        .signWith(SignatureAlgorithm.HS256,  secretKey)//
        .compact();
  }

  public Authentication getAuthentication(String token) {
    System.out.println("token is:" + token);
    UserDetails userDetails = myUserDetails.loadUserByUsername(getUsername(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }
  /*public Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    System.out.println("get auth");
    if(token!=null){
        UserDetails userDetails = myUserDetails.loadUserByUsername(getUsername(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }*/

  public String getUsername(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }

  public String resolveToken(HttpServletRequest req) {
    String bearerToken = req.getHeader("Authorization");
    System.out.println("BT:"+bearerToken);
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7, bearerToken.length());
    }
    return null;
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      throw new CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

    public String createToken(String username, MyUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
}
package databasesystems.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;
  
  @Override
  @Bean 
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
  /*
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("/home.html");
  }*/
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // Disable CSRF (cross site request forgery)
    http.csrf().disable();

    // No session will be created or used by spring security
    //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // Entry points
    http.authorizeRequests()//
        .antMatchers("/","/signin","/signup").permitAll()//
        .antMatchers("/auth/**").permitAll()//
        // Disallow everything else..
        .anyRequest().authenticated()
        /*.and()
            .addFilterBefore(new JwtTokenFilter("/signin", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
        // And filter other requests to check the presence of JWT in header
        .addFilterBefore(new JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);*/
        .and()
    .formLogin()
        .loginPage("/")
        .permitAll()
        .and()
    .logout()
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .deleteCookies("jwtCookie")
        .logoutSuccessUrl("/")
        .permitAll();
    // If a user try to access a resource without having enough permissions
    http.exceptionHandling().accessDeniedPage("/");

    // Apply JWT
    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

    // Optional, if you want to test the API from a browser
     http.httpBasic();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // Allow swagger to be accessed without authentication
    System.out.println("ALALALALALA");
    web.ignoring().antMatchers("/v2/api-docs")//
        .antMatchers("/swagger-resources/**")//
        .antMatchers("/swagger-ui.html")//
        .antMatchers("/configuration/**")//
        .antMatchers("/webjars/**")//
        .antMatchers("/public")
        
        // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
        .and()
        .ignoring()
        .antMatchers("/h2-console/**/**");
  }
/*
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }*/

}
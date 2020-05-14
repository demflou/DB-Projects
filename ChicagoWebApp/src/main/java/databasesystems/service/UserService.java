package databasesystems.service;

import databasesystems.domain.MyUser;
import databasesystems.exception.CustomException;
import databasesystems.repository.UserRepository;
import databasesystems.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;
  
  @Autowired
  private AuthenticationManager authenticationManager;
  
  public String signin(String username, String password) {
    try {
      System.out.println("singin fun ---------------------" + username + password);
      UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(username, password);
      System.out.println("UPAT!!!!!!!!!!!!!!!!" + upat.getCredentials().toString());
      Authentication auth=authenticationManager.authenticate(upat);
      //authenticate
      
      System.out.println(auth.getPrincipal()+" !!!!!!!!!!!!! "+auth.getCredentials());
      return jwtTokenProvider.createToken(username/*, getUser(username)*/);
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }
    
    @Autowired
    UserRepository userRepository;

    public MyUser addUser(MyUser user) {
        userRepository.save(user);
        return user;
    }

    public Iterable<MyUser> getUsers(){
        return userRepository.findAll();
    }

    public MyUser getUser(String userId){
      return userRepository.findOne(userId);
  }
}

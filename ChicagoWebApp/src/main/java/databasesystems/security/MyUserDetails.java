package databasesystems.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import databasesystems.domain.MyUser;
import databasesystems.repository.UserRepository;
import databasesystems.service.UserService;

@Service
public class MyUserDetails implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  UserService userService;
    
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final MyUser user = userService.getUser(username);
    if (user == null) {
        System.out.println("EXE");
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
    else{
        System.out.println(user.getPassword());
    }
    System.out.println("GAGAGAGAGAGA ");
    //System.out.println("-----------" + temp.getUsername()+" "+temp.getPassword());
    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password(user.getPassword())//
        //.authorities(user.getRoles())//
        .roles("USER")
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
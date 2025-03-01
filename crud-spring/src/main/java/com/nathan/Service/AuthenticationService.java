package com.nathan.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nathan.Repository.UserRepository;

 /*
  * Notes:
  * 
  * After a user attempts to log in, the `AuthenticationManager` (called in the controller's login method) 
  * automatically invokes this class to retrieve user details from the database.
  * 
  * The `UserDetails` interface is a crucial component in Spring Security, representing authenticated users.
  * It provides necessary user information, such as username, password, and authorities (roles/permissions).
  * 
  * This class implements `UserDetailsService`, which is required by Spring Security to load user details 
  * based on their login (username). If the user does not exist, an exception is thrown.
  */


@Service
public class AuthenticationService implements UserDetailsService {
    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }
}

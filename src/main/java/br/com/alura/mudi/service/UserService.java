package br.com.alura.mudi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.alura.mudi.repository.UserRepository;
import br.com.alura.mudi.repository.model.User;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public User getCurrentUser() {
    String currentUsername = SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getName();

    return getUserByUsername(currentUsername);
  }
  
  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}

package br.com.alura.mudi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.mudi.repository.UserRepository;
import br.com.alura.mudi.repository.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UserService.class})
class UserServiceTest {

  @Autowired
  private UserService service;
  @MockBean
  private UserRepository repository;
  
  @Test
  void getUserByUsername_givenUsername_shouldReturnUser() {
    User userToReturn = new User();
    userToReturn.setUsername("user1");
    
    when(repository.findByUsername("user1")).thenReturn(userToReturn);
    
    User myUser = service.getUserByUsername("user1");
    
    assertThat(myUser).isNotNull();
    assertThat(myUser.getUsername()).isEqualTo("user1");
  }

}

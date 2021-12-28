package br.com.alura.mudi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.mudi.repository.OrderRepository;
import br.com.alura.mudi.repository.model.Order;
import br.com.alura.mudi.repository.model.StatusOrder;
import br.com.alura.mudi.repository.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {OrderService.class})
class OrderServiceTest {
  
  @Autowired
  private OrderService orderService;
  
  @MockBean
  private UserService userService;
  
  @MockBean
  private OrderRepository orderRepository;
  
  @Test
  void getOrdersDelivered_shouldReturnAllOrdersWithStatusDelivered() {
    List<Order> orders = new ArrayList<>();
    Order firstOrder = new Order();
    firstOrder.setStatus(StatusOrder.DELIVERED);
    orders.add(firstOrder);
    
    Order secondOrder = new Order();
    secondOrder.setStatus(StatusOrder.DELIVERED);
    orders.add(secondOrder);
    
    when(orderRepository.findByStatus(StatusOrder.DELIVERED)).thenReturn(orders);
    
    assertThat(orderService).isNotNull();
    List<Order> ordersDelivered = orderService.getOrdersDelivered();
    
    assertThat(ordersDelivered).isNotNull();
    assertThat(ordersDelivered.size()).isGreaterThan(0);
    
    for(Order order: orders) {
      assertThat(order.getStatus()).isEqualTo(StatusOrder.DELIVERED);
    }
    
  }
  
  @Test
  void getOrdersByUser_shoulReturnOrdersThatBelongsToUserAuthenticated() {
    User user = new User();
    user.setUsername("joao");
    
    when(userService.getCurrentUser()).thenReturn(user);
    
    List<Order> ordersByUser = orderService.getOrdersByUser();
    
    Order firstOrder = new Order();
    Order secondOrder = new Order();
    firstOrder.setUser(user);
    secondOrder.setUser(user);
    ordersByUser.add(firstOrder);
    ordersByUser.add(secondOrder);
    
    assertThat(ordersByUser).isNotNull();  
    assertThat(ordersByUser.size()).isGreaterThan(0);
   
    
    for(Order order: ordersByUser) {
      assertThat(order.getUser()).isNotNull();
      assertThat(order.getUser().getUsername()).isEqualTo("joao");
    }
  }
  
  @Test
  void getOrdersByStatusAndUser_givenAStatus_shouldReturnOrdersThatBelongsToUserAuthenticated() {
    
    User user = new User();
    user.setUsername("joao");
    
    when(userService.getCurrentUser()).thenReturn(user);
    
    Order firstOrder = new Order();
    Order secondOrder = new Order();
    firstOrder.setStatus(StatusOrder.APPROVED);
    secondOrder.setStatus(StatusOrder.APPROVED);
    firstOrder.setUser(user);
    secondOrder.setUser(user);
    
    List<Order> ordersByStatusAndUser = orderService.getOrdersByStatusAndUser("APPROVED");
    ordersByStatusAndUser.add(firstOrder);
    ordersByStatusAndUser.add(secondOrder);
    
    assertThat(ordersByStatusAndUser).isNotNull(); 

    for(Order order: ordersByStatusAndUser) {
      assertThat(order.getStatus()).isNotNull();
      assertThat(order.getUser().getUsername()).isNotNull();
      
      assertThat(order.getStatus()).isEqualTo(StatusOrder.APPROVED);
      assertThat(order.getUser().getUsername()).isEqualTo("joao");
    }
  }
}

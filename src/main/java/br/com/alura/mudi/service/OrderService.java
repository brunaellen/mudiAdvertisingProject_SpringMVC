package br.com.alura.mudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.mudi.repository.OrderRepository;
import br.com.alura.mudi.repository.model.Order;
import br.com.alura.mudi.repository.model.StatusOrder;
import br.com.alura.mudi.repository.model.User;

@Service
public class OrderService {
  
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private UserService userService;
  
  public List<Order> getOrdersDelivered() {
    return orderRepository.findByStatus(StatusOrder.DELIVERED);
  }
  
  public List<Order> getOrdersByUser() {
    return orderRepository.findAllByUser(userService.getCurrentUser().getUsername());
  }
  
  public List<Order> getOrdersByStatusAndUser(String status) {
    return orderRepository
        .findByStatusAndUser(StatusOrder.valueOf(status.toUpperCase()), userService.getCurrentUser().getUsername());
  }

  public void createOrder(Order order) {
    User user = userService.getCurrentUser();
    order.setUser(user);
    orderRepository.save(order);
  }

}

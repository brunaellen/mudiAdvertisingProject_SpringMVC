package br.com.alura.mudi.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.repository.OrderRepository;
import br.com.alura.mudi.repository.model.Order;
import br.com.alura.mudi.repository.model.StatusOrder;

@RestController
@RequestMapping("/api/orders")
public class OrderRest {
  
  @Autowired
  private OrderRepository orderRepository;
  
  @GetMapping("pending")
  public List<Order> getOrdersPending() {
    return orderRepository.findByStatus(StatusOrder.PENDING);
  }
}

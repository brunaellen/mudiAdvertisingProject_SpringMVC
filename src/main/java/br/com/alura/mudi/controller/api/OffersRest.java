package br.com.alura.mudi.controller.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.controller.api.exception.ItemNotFoundException;
import br.com.alura.mudi.controller.dto.NewOffer;
import br.com.alura.mudi.repository.OrderRepository;
import br.com.alura.mudi.repository.model.Offer;
import br.com.alura.mudi.repository.model.Order;

@RestController
@RequestMapping("api/offers")
public class OffersRest {
  
  @Autowired
  OrderRepository orderRepository;
  
  @PostMapping
  public Offer createAnOffer(@Valid @RequestBody NewOffer newOffer) {
    Optional<Order> orderRegistered = orderRepository
        .findById(newOffer.getOrderId());
    
    if(!orderRegistered.isPresent()) {
      throw new ItemNotFoundException();
    }
    
    Offer offer = newOffer.toOffer();
    Order order = orderRegistered.get();
    offer.setOrder(order);
    order.getOffersList().add(offer);
    orderRepository.save(order);
    return offer;
  }
}

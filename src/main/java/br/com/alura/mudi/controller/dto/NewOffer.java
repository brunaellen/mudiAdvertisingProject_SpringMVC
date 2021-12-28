package br.com.alura.mudi.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mudi.repository.model.Offer;

public class NewOffer {
  private Long orderId;
  
  @Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "must be numbers")
  @NotNull
  private  String value;
  
  @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Date must match (dd/mm/yyyy)")
  @NotNull
  private String dateOfDelivery;
  private String comment;
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDateOfDelivery() {
    return dateOfDelivery;
  }

  public void setDateOfDelivery(String dateOfDelivery) {
    this.dateOfDelivery = dateOfDelivery;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Offer toOffer() {
    Offer offer = new Offer();
    offer.setComment(comment);
    offer.setDateOfDelivery(LocalDate.parse(dateOfDelivery, formatter));
    offer.setValue(new BigDecimal(value));
    return offer;
  }

  public Long getOrderId() {
    return orderId;
  }
}

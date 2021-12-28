package br.com.alura.mudi.repository.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties(value = {"user"})
public class Order {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nameOfProduct;
  private BigDecimal value;
  private LocalDate dateOfDelivery;
  private String urlOfProduct;
  private String urlOfImage;
  private String description;
  
  @Enumerated(EnumType.STRING)
  private StatusOrder status;
  
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
  
  @OneToMany(cascade = CascadeType.ALL, 
      mappedBy = "order", fetch = FetchType.EAGER)
  private List<Offer> offers;

  public String getNameOfProduct() {
    return nameOfProduct;
  }

  public void setNameOfProduct(String nameOfProduct) {
    this.nameOfProduct = nameOfProduct;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public LocalDate getDateOfDelivery() {
    return dateOfDelivery;
  }

  public void setDateOfDelivery(LocalDate dateOfDelivery) {
    this.dateOfDelivery = dateOfDelivery;
  }

  public String getUrlOfProduct() {
    return urlOfProduct;
  }

  public void setUrlOfProduct(String urlOfProduct) {
    this.urlOfProduct = urlOfProduct;
  }

  public String getUrlOfImage() {
    return urlOfImage;
  }

  public void setUrlOfImage(String urlOfImage) {
    this.urlOfImage = urlOfImage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public StatusOrder getStatus() {
    return status;
  }

  public void setStatus(StatusOrder status) {
    this.status = status;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Offer> getOffersList() {
    return offers;
  }

  public void setOffers(List<Offer> offers) {
    this.offers = offers;
  }

  public Long getId() {
    return id;
  }
}

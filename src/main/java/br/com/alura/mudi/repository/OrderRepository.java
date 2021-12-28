package br.com.alura.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mudi.repository.model.Order;
import br.com.alura.mudi.repository.model.StatusOrder;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
  
  @Cacheable("orders")
  List<Order> findByStatus(StatusOrder status);
  
  @Query("SELECT o FROM Order o JOIN o.user u WHERE u.username = :username")
  List<Order> findAllByUser(@Param("username")String username);
  
  @Query("SELECT o FROM Order o JOIN o.user u WHERE u.username = :username AND o.status = :status")
  List<Order> findByStatusAndUser(@Param("status")StatusOrder status, @Param("username")String username);
}

package com.sl.ms.ordermanagement;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path="orders", rel="orders")
public interface OrderDAO extends CrudRepository<Order, Long> {

  @Cacheable(value="product", key="id")
  Iterable<Order> findAllById(long id);
}

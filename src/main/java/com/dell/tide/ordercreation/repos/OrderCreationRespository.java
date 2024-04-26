package com.dell.tide.ordercreation.repos;

import com.dell.tide.ordercreation.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCreationRespository extends JpaRepository<Order, Long> {

}

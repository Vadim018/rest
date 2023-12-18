package ua.com.shop.restaurant_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.shop.restaurant_project.entity.ProductHasOrder;

public interface ProductHasOrderRepository extends JpaRepository<ProductHasOrder, Long> {

}
package ua.com.shop.restaurant_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.shop.restaurant_project.entity.Order;
import ua.com.shop.restaurant_project.repository.OrderRepository;

import java.util.List;

@Service
public class OrderManagerService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderManagerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findListOrderByStatus(boolean status) {
        return orderRepository.findByStatusOrder(status);
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    public void updateOrderNewStatus(Order order) {
        order.setStatusOrder(!order.isStatusOrder());
        orderRepository.save(order);
    }
}
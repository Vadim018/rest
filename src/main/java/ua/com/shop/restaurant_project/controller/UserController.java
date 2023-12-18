package ua.com.shop.restaurant_project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.shop.restaurant_project.bl.Cart;
import ua.com.shop.restaurant_project.bl.ItemCart;
import ua.com.shop.restaurant_project.entity.*;
import ua.com.shop.restaurant_project.repository.OrderRepository;
import ua.com.shop.restaurant_project.repository.ProductHasOrderRepository;
import ua.com.shop.restaurant_project.service.CustomerManagerService;
import ua.com.shop.restaurant_project.service.UserManagerService;
import ua.com.shop.restaurant_project.service.UserService;
import java.util.Date;
import java.util.Objects;

@Controller
public class UserController {
    private final UserManagerService userManagerService;
    public UserService userService;
    private final CustomerManagerService customerManagerService;
    private final OrderRepository orderRepository;
    private final ProductHasOrderRepository productHasOrderRepository;

    @Autowired
    public UserController(UserManagerService userManagerService, UserService userService,
                          CustomerManagerService customerManagerService, OrderRepository orderRepository,
                          ProductHasOrderRepository productHasOrderRepository) {
        this.userManagerService = userManagerService;
        this.userService = userService;
        this.customerManagerService = customerManagerService;
        this.orderRepository = orderRepository;
        this.productHasOrderRepository = productHasOrderRepository;
    }

    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = null;
        try {
            user = (Users) userManagerService.loadUserByUsername(auth.getName());
        } catch (Exception e) {
            //
        }

        if (user == null) {
            return "redirect:/login";
        }

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            return "redirect:/";
        }
        model.addAttribute("itemCart", cart.getCart());
        Customer client = customerManagerService.getCustomerByUsername(user);
        model.addAttribute("client", client);
        return "order";
    }

    @PostMapping("/order")
    public String saveOrderToDB(@RequestParam(name = "delivery") String delivery,
                                @RequestParam(name = "payment") String payment, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = null;
        try {
            user = (Users) userManagerService.loadUserByUsername(auth.getName());
        } catch (Exception e) {
            //
        }

        Customer client = customerManagerService.getCustomerByUsername(Objects.requireNonNull(user));
        Order order = new Order();
        order.setDateCreated(new Date());
        order.setCustomer(client);
        order.setDelivery(delivery);
        order.setPayment(payment);
        order.setStatusOrder(false);
        Order order1 = orderRepository.save(order);

        for (ItemCart el : cart.getCart()) {
            productHasOrderRepository.save(new ProductHasOrder(el.getProduct(), el.getQuantity(), order1));
        }
        return "thank";
    }

    @GetMapping("/thank")
    public String getPageThank() {
        return "thank";
    }
}
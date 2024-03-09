package ua.com.shop.restaurant_project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.shop.restaurant_project.bl.Cart;
import ua.com.shop.restaurant_project.entity.Category;
import ua.com.shop.restaurant_project.entity.Product;
import ua.com.shop.restaurant_project.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category/{id}")
    public String getAllProductByCategory(@PathVariable(name = "id") Category category, Model model) {
        List<Product> productList = productService.getProductsByCategory(category);
        model.addAttribute("products_by_category", productList);
        model.addAttribute("category", productList.isEmpty() ? " " : category.getName());
        return "products_by_category";
    }

    @PostMapping("/cart")
    public String addNewItemToCart(@RequestParam(name = "id") Product product,
                                   @RequestParam(name = "quantity") int quantity,
                                   HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        model.addAttribute("item_cart", cart.getCart());
        model.addAttribute("total_element", cart.getSumItemCart());
        model.addAttribute("value", cart.getTotalVal());
        return "cart";
    }

    @PostMapping("/updateItemCart")
    public String updateItemCart(@RequestParam(name = "id") Product product,
                                 @RequestParam(name = "quantity") int quantity,
                                 HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.updateItemCart(product, quantity);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/deleteItemCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Product product, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.deleteItemFromCart(product);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/deleteItemsCart")
    public String deleteItemsFromCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.deleteAllItemFromCart();
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }
}

/*
    * Використовує сесію для зберігання інформації
    * про корзину між запитами користувача
*/
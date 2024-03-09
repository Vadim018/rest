package ua.com.shop.restaurant_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.shop.restaurant_project.service.CategoryManagerService;

@Controller
public class HomeController {
    public CategoryManagerService categoryService;

    @Autowired
    public HomeController(CategoryManagerService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/exit")
    public String getExit()
    {
        return "exit";
    }

    @GetMapping("/products")
    public String getProductAdmin()
    {
        return "product_admin_page";
    }

    @GetMapping("/categories")
    public String getCategoryAdmin()
    {
        return "category_admin_page";
    }

    @GetMapping("/orders")
    public String getOrdersAdmin()
    {
        return "order";
    }

    @GetMapping("/inform")
    public String getInfoByUsers()
    {
        return "inform";
    }
}

/*
    * Має різні методи для обробки HTTP-запитів
    * для відображення сторінок з різними шляхами.
    * Кожен метод просто повертає ім'я шаблону, яке
    * вказує на те, яку сторінку відображати при відповідному
    * HTTP-запиті
*/
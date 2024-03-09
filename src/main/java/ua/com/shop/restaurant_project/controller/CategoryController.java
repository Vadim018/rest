package ua.com.shop.restaurant_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.shop.restaurant_project.entity.Category;
import ua.com.shop.restaurant_project.service.CategoryService;
import java.util.List;

@Controller
public class CategoryController
{
    private final CategoryService categoryService;

    public Model model;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/category")
    public String getPageCategory(Model model)
    {
        // отримуємо список всіх категорій з сервісу categoryService
        List<Category> categoryList = categoryService.getAllCategory();
        // додаємо список категорій до моделі для передачі на сторінку
        model.addAttribute("categories", categoryList);
        // повертаємо ім'я шаблону
        return "category";
    }

    // пошук категорій за ім'ям, яке передається як параметр "q" в запиті
    @GetMapping("/search")
    public String searchCategories(@RequestParam String q, Model model) {
        List<Category> categoryList = categoryService.searchCategoriesByName(q);
        model.addAttribute("categories", categoryList);
        return "category";
    }
}

/*
    Відповідає за обробку HTTP-запитів і керування
    відображенням сторінок у веб-застосунку
*/
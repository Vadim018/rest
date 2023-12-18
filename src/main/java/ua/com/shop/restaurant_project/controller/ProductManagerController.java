package ua.com.shop.restaurant_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.shop.restaurant_project.entity.Category;
import ua.com.shop.restaurant_project.entity.Product;
import ua.com.shop.restaurant_project.service.CategoryManagerService;
import ua.com.shop.restaurant_project.service.ProductManagerService;
import java.math.BigDecimal;

@Controller
public class ProductManagerController
{
    private final ProductManagerService productService;
    private final CategoryManagerService categoryManagerService;

    @Autowired
    public ProductManagerController(ProductManagerService productService, CategoryManagerService categoryManagerService)
    {
        this.productService = productService;
        this.categoryManagerService = categoryManagerService;
    }

    @GetMapping("/product_manager")
    public String getAllProduct(Model model)
    {
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("categories", categoryManagerService.getCategoryList());
        return "product_admin_page";
    }

    @PostMapping("/saveNewProduct")
    public String saveNewProductToDB(@RequestParam(value = "name") String name, @RequestParam(value = "description") String description, @RequestParam(value = "image") String image, @RequestParam(value = "price") BigDecimal price, @RequestParam(value = "categoryId") Category category)
    {
        productService.saveNewProductToDB(name, description, image, price, category);
        return "redirect:/product_manager";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name, @RequestParam(value = "description") String description, @RequestParam(value = "image") String image, @RequestParam(value = "price") String price1, @RequestParam(value = "categoryId") Category category)
    {
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(price1.replaceAll("[^0-9]", "")));
        productService.updateProduct(id, name, description, image, price, category);
        return "redirect:/product_manager";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "id") Long id)
    {
        productService.deleteProductById(id);
        return "redirect:/product_manager";
    }

    @PostMapping("/deleteAllProduct")
    public String deleteAllProduct()
    {
        productService.deleteAllProduct();
        return "redirect:/product_manager";
    }

    @GetMapping("/product_manager/{id}")
    public String getCategoryPageById(@PathVariable("id") Long id, Model model)
    {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product_det";
    }
}

/*
    * Використовує сервіси ProductManagerService і CategoryManagerService
    * для виконання логіки, пов'язаної з продуктами та категоріями
*/
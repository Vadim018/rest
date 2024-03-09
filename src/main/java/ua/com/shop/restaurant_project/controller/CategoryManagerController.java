package ua.com.shop.restaurant_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.shop.restaurant_project.entity.Category;
import ua.com.shop.restaurant_project.service.CategoryManagerService;
import ua.com.shop.restaurant_project.service.ProductManagerService;

@Controller
public class CategoryManagerController
{
    private final CategoryManagerService categoryService;
    private final ProductManagerService productService;

    @Autowired
    public CategoryManagerController(CategoryManagerService categoryService, ProductManagerService productService)
    {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/category_manager")
    public String getCategoryManagerPage(Model model, @RequestParam(name = "Error", defaultValue = "") String name, @RequestParam(name = "Error", defaultValue = "") String name1)
    {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("Error", name);
        model.addAttribute("Error", name1);
        return "category_admin_page";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategoryToDB(@RequestParam(value = "name") String name, @RequestParam(value = "description") String description, @RequestParam(value = "image") String image)
    {
        categoryService.saveCategory(name, description, image);
        return "redirect:/category_manager";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name, @RequestParam(value = "description") String description, @RequestParam(value = "image") String image)
    {
        categoryService.updateCategory(id, name, description, image);
        return "redirect:/category_manager";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(value = "id") Long id, @RequestParam(value = "id") Category category, RedirectAttributes redirectAttributes)
    {
        if (!productService.sizeProductByCategory(category))
        {
            categoryService.deleteCategory(id);
        }
        else
        {
            redirectAttributes.addAttribute("Error", "Перед видаленням категорій видаліть продукцію з категорій");
        }
        return "redirect:/category_manager";
    }

    @PostMapping("/deleteAllCategory")
    public String deleteAllCategory(RedirectAttributes redirectAttributes)
    {
        if(productService.findAllProduct().size() == 0)
        {
            categoryService.deleteAllCategory();
        }
        else
        {
            redirectAttributes.addAttribute("Error", "Перед видаленням категорій видаліть всю продукцію з категорій");
        }
        return "redirect:/category_manager";
    }

    @GetMapping("/category_manager/{id}")
    public String getCategoryById(@PathVariable("id") Long id, Model model)
    {
        Category category = categoryService.getCategoryById(id);

        model.addAttribute("category", category);

        return "category_by_id";
    }
}

/*
 * Відповідає за обробку HTTP-запитів, пов'язаних з
 * керуванням категоріями та продуктами у веб-застосунку
*/
package ua.com.shop.restaurant_project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.shop.restaurant_project.entity.Customer;
import ua.com.shop.restaurant_project.entity.Users;
import ua.com.shop.restaurant_project.service.CustomerManagerService;
import ua.com.shop.restaurant_project.service.UserManagerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserManagerController {
    private final CustomerManagerService customerService;
    private final UserManagerService userService;

    @Autowired
    public UserManagerController(CustomerManagerService customerService, UserManagerService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("customer", new Customer());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewCustomer(@Valid Users users, BindingResult bindingResult,
                                  @Valid Customer customer, BindingResult bindingResult1, Model model) {
        if (bindingResult.hasErrors() || bindingResult1.hasErrors()) {
            return "/registration";
        }

        if (userService.getLogicByUser(users.getUsername())) {
            model.addAttribute("Error", "Користувач з таким іменем вже існує!");
            return "/registration";
        }

        Users user1 = userService.saveNewUserToDB(users);
        customer.setUser(user1);
        customerService.saveCustomerToDB(customer);
        return "redirect:/";
    }

    @GetMapping("/customer_manager")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", userService.getCustomerList());
        return "customer_admin_page";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long userId, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUserById(userId);
            redirectAttributes.addFlashAttribute("successMessage", "Користувача було успішно видалено.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Не вдалося видалити користувача: " + e.getMessage());
        }
        return "redirect:/customer_manager";
    }
}
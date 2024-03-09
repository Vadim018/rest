package ua.com.shop.restaurant_project.bl;

import lombok.*;
import ua.com.shop.restaurant_project.entity.Product;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemCart
{
    private Product product;
    private int quantity;
}
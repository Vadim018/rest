package ua.com.shop.restaurant_project.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.shop.restaurant_project.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {
    private List<ItemCart> cart;
    private double totalValue;
    private int sumItem;

    public Cart() {
        cart = new ArrayList<>();
        totalValue = 0;
        sumItem = 0;
    }

    public void addNewItemToCart(Product product, int quantity) {
        boolean logic = true;

        for (ItemCart el : cart) {
            if (product.getId().equals(el.getProduct().getId())) {
                logic = false;
                el.setQuantity(el.getQuantity() + quantity);
            }
        }
        if (logic) cart.add(new ItemCart(product, quantity));
    }

    public void updateItemCart(Product product, int quantity) {
        if (quantity <= 0) {
            for (ItemCart el : cart) {
                if (el.getProduct().getId().equals(product.getId())) {
                    cart.remove(el);
                    break;
                }
            }
        } else {
            for (ItemCart el : cart) {
                if (product.getId().equals(el.getProduct().getId())) {
                    el.setQuantity(quantity);
                }
            }
        }
    }

    public void deleteItemFromCart(Product product) {
        for (ItemCart el : cart) {
            if (product.getId().equals(el.getProduct().getId())) {
                cart.remove(el);
                break;
            }
        }
    }

    public void deleteAllItemFromCart() {
        cart.clear();
        totalValue = 0;
        sumItem = 0;
    }

    public double getTotalVal() {
        totalValue = 0;
        for (ItemCart el : cart) {
            totalValue += el.getQuantity() * el.getProduct().getPrice().doubleValue();
        }
        return totalValue;
    }

    public int getSumItemCart() {
        int a = 0;

        for (ItemCart ignored : cart) {
            a++;
        }
        return a;
    }
}

/*
    * Використовується для управління товарами у кошику
    * під час покупки товарів у веб-застосунку
*/
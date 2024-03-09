package ua.com.shop.restaurant_project.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Setter
@Getter
@ToString
@Data
@Entity
@Table(name = "category")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "categories")
    private List<Product> productList;

    public Category() {
    }

    public Category(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Category(Long id, String name, String description, String image, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.productList = productList;
    }
}
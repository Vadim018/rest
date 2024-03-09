package ua.com.shop.restaurant_project.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

    @OneToMany(mappedBy = "product")
    private List<ProductHasOrder> productHasOrders;

    public Product(Long id, String name, String description, BigDecimal price, String image, Category categories)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categories = categories;
    }

    public Product(String name, String description, BigDecimal price, String image, Category categories)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categories = categories;
    }
}
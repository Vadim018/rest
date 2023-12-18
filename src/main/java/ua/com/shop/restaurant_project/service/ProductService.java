package ua.com.shop.restaurant_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.shop.restaurant_project.entity.Category;
import ua.com.shop.restaurant_project.entity.Product;
import ua.com.shop.restaurant_project.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Cacheable(cacheNames = "product", key = "#category.getId()")
    public List<Product> getProductsByCategory(Category category)
    {
        return productRepository.findAllByCategories(category);
    }
    @Cacheable(cacheNames = "products_by_category", key = "#pageable.pageNumber")
    public Page<Product> getPageProductByCategory(Category category, Pageable pageable)
    {
        return productRepository.findAllByCategories(pageable, category);
    }
}
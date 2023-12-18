package ua.com.shop.restaurant_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.shop.restaurant_project.entity.Category;
import ua.com.shop.restaurant_project.repository.CategoryRepository;
import java.util.List;

@Service
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Cacheable(cacheNames = {"category"})
    public List<Category> getAllCategory()
    {
        return categoryRepository.findAll();
    }
    @Cacheable(cacheNames = "category", key = "#pageable.pageNumber")
    public Page<Category> getAllPageCategory(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }
    public List<Category> searchCategoriesByName(String name) {
        return categoryRepository.findByNameContaining(name);
    }
}
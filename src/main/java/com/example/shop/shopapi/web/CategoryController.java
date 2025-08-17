package com.example.shop.shopapi.web;
import com.example.shop.shopapi.domain.Category;
import com.example.shop.shopapi.repo.CategoryRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryRepository repo;
    public CategoryController(CategoryRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Category> all() { return repo.findAll(); }
}

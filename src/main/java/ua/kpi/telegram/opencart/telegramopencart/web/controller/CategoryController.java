package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CategoryService;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PutMapping("/category")
    public Category createCategory(@RequestParam("name") String name,
                                   @RequestParam("description") String description) {
        return categoryService.add(name, description);
    }

    @DeleteMapping("/category")
    public void deleteCategory(@RequestParam("name") String name) {
        categoryService.remove(name);
    }

    @PostMapping("/category/{categoryName}")
    public void updateCategory(@PathVariable("categoryName") String name,
                               @RequestBody Category category) {
        categoryService.update(name, category);
    }

    @DeleteMapping("/category/root")
    public Category getRoot() {
        return categoryService.getRootCategory();
    }

}

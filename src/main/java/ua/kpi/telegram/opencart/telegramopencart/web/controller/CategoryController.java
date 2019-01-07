package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.AuthorizationService;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CategoryService;

@RestController()
public class CategoryController {
    private final AuthorizationService authorizationService;

    private final CategoryService categoryService;

    public CategoryController(AuthorizationService authorizationService, CategoryService categoryService) {
        this.authorizationService = authorizationService;
        this.categoryService = categoryService;
    }

    @PutMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestParam("authentication") String authentication,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("description") String description) {
        if (authorizationService.hasTaxonomyUnitChangeAccess(authentication)) {
            return ResponseEntity.ok(categoryService.add(name, description));
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @DeleteMapping("/category")
    public ResponseEntity deleteCategory(@RequestParam("authentication") String authentication,
                                         @RequestParam("id") long categoryId) {
        if (authorizationService.hasTaxonomyUnitChangeAccess(authentication)) {
            categoryService.remove(categoryId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/category/{categoryId}")
    public ResponseEntity updateCategory(@RequestParam("authentication") String authentication,
                                         @PathVariable("categoryId") long categoryId,
                                         @RequestBody Category category) {
        if (authorizationService.hasTaxonomyUnitChangeAccess(authentication)) {
            categoryService.update(categoryId, category);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @GetMapping("/category/root")
    public Category getRoot() {
        return categoryService.getRootCategory();
    }

}

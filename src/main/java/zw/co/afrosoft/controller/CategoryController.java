package zw.co.afrosoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.CategoryResponse;
import zw.co.afrosoft.dto.EmployeeResponse;
import zw.co.afrosoft.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/v1/category")
    public List<CategoryResponse> getAll(){
      List<Category> categoryList = categoryService.listAll();
      List<CategoryResponse> categoryResponseList = new ArrayList<>();

      categoryList.stream().
              filter(category -> categoryResponseList.add(new CategoryResponse(category)));

      return categoryResponseList;
    }
}

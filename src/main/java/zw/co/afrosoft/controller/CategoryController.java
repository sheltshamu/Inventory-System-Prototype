package zw.co.afrosoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Abbreviation;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.CategoryRequest;
import zw.co.afrosoft.dto.CategoryResponse;
import zw.co.afrosoft.dto.EmployeeResponse;
import zw.co.afrosoft.service.CategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get-all")
    public List<CategoryResponse> getAll(){
      List<Category> categoryList = categoryService.listAll();
      List<CategoryResponse> categoryResponseList = new ArrayList<>();

      categoryList.stream().
              forEach(category -> categoryResponseList.add(new CategoryResponse(category)));

      return categoryResponseList;
    }

   @PostMapping("/create")
    public CategoryResponse create(@RequestBody CategoryRequest categoryRequest){
        Category category = categoryService.create(categoryRequest);
        return new CategoryResponse(category);
   }

   @DeleteMapping("/delete")
   public void delete(@RequestBody CategoryRequest categoryRequest){

   }
}

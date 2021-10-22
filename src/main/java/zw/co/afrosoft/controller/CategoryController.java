package zw.co.afrosoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.request.CategoryRequest;
import zw.co.afrosoft.dto.response.CategoryResponse;
import zw.co.afrosoft.service.CategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity create(@Valid @RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.create(categoryRequest));
   }

   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id){
        categoryService.delete(id);
   }

   @GetMapping("/get-by-id/{id}")
    public ResponseEntity getById(@RequestParam("id") Long id){
        return categoryService.findCategoryById(id);
   }

}

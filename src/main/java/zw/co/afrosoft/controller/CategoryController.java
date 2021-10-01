package zw.co.afrosoft.controller;

import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.request.CategoryRequest;
import zw.co.afrosoft.dto.response.CategoryResponse;
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

   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id){
        categoryService.delete(id);
   }

   /*
   @PutMapping("/update")
    public CategoryResponse update(@RequestBody CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return new CategoryResponse(category);
   }

    */
}

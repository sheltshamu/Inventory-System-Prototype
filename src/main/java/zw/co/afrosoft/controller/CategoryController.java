package zw.co.afrosoft.controller;

import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.ApiResponse;
import zw.co.afrosoft.dto.ResponseCode;
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
    public ApiResponse<List<CategoryResponse>> getAll(){
      List<Category> categoryList = categoryService.listAll();
      List<CategoryResponse> categoryResponseList = new ArrayList<>();

      categoryList.stream().
              forEach(category -> categoryResponseList.add(new CategoryResponse(category)));

      return new ApiResponse<>(categoryResponseList,"OK",ResponseCode.SUCCESS);
    }


   @PostMapping("/create")
    public ApiResponse<CategoryResponse> create(@Valid @RequestBody CategoryRequest categoryRequest){
       CategoryResponse categoryResponse = categoryService.create(categoryRequest);
       return new ApiResponse<>(categoryResponse,"OK",ResponseCode.SUCCESS);
   }

   @DeleteMapping("/{id}")
   public ApiResponse delete(@PathVariable Long id){
        CategoryResponse categoryResponse= categoryService.delete(id);
        return new ApiResponse(categoryResponse,"OK",ResponseCode.SUCCESS);
   }

   @GetMapping("/get-by-id/{id}")
    public ApiResponse<CategoryResponse> getCategoryById(@PathVariable("id") Long id){
        CategoryResponse category=categoryService.findCategoryById(id);
        return new ApiResponse<>(category,"OK",ResponseCode.SUCCESS);
   }

}

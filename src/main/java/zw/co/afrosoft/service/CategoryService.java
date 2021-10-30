package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.UpdateCategoryRequest;
import zw.co.afrosoft.dto.request.CategoryRequest;
import zw.co.afrosoft.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse create(CategoryRequest categoryRequest);

    List<Category> listAll();

    CategoryResponse delete(Long id);

    CategoryResponse update(UpdateCategoryRequest updateCategoryRequest);

    CategoryResponse findCategoryById(Long id);
}

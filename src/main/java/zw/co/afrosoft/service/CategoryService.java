package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.UpdateCategoryRequest;
import zw.co.afrosoft.dto.request.CategoryRequest;
import java.util.List;

public interface CategoryService {

    ResponseEntity create(CategoryRequest categoryRequest);

    List<Category> listAll();

    void delete(Long id);

    ResponseEntity update(UpdateCategoryRequest updateCategoryRequest);

    ResponseEntity findCategoryById(Long id);
}

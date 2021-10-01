package zw.co.afrosoft.service;

import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.request.CategoryRequest;
import java.util.List;

public interface CategoryService {

    Category create(CategoryRequest categoryRequest);

    List<Category> listAll();

    void delete(Long id);

    Category update(CategoryRequest categoryRequest);

    Category findCategoryById(Long id);
}

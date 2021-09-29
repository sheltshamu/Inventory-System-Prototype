package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.CategoryRequest;
import java.util.List;

@Service
public interface CategoryService {
    Category create(CategoryRequest categoryRequest);
    List<Category> listAll();
    void delete(Long id);
}

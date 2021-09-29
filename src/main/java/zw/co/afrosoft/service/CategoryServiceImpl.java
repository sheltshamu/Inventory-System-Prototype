package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.CategoryRequest;
import zw.co.afrosoft.persistence.CategoryRepository;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category(categoryRequest);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }


}

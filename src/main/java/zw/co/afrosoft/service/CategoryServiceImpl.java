package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.UpdateCategoryRequest;
import zw.co.afrosoft.dto.request.CategoryRequest;
import zw.co.afrosoft.persistence.CategoryRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category();
        LocalDateTime currentDateTime = LocalDateTime.now();
        category.setDateCreated(currentDateTime);
        category.setDateModified(currentDateTime);
        category.setName(categoryRequest.getName());
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

    @Override
    public Category update(UpdateCategoryRequest updateCategoryRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Category category = categoryRepository.findById(updateCategoryRequest.getId()).get();
        category.setDateModified(currentDateTime);
        category.setName(updateCategoryRequest.getName());
        return category;
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}

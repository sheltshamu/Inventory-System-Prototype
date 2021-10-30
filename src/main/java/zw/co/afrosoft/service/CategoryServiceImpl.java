package zw.co.afrosoft.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.UpdateCategoryRequest;
import zw.co.afrosoft.dto.request.CategoryRequest;
import zw.co.afrosoft.dto.response.CategoryResponse;
import zw.co.afrosoft.exception.NoRecordExistException;
import zw.co.afrosoft.persistence.CategoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = new Category();
        LocalDateTime currentDateTime = LocalDateTime.now();
        category.setDateCreated(currentDateTime);
        category.setDateModified(currentDateTime);
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return new CategoryResponse(category);
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryResponse delete(Long id) {
        Optional<Category> existingCategory= categoryRepository.findById(id);
        if (!existingCategory.isPresent())
            throw new RuntimeException("Not found");
        Category category = existingCategory.get();
        categoryRepository.delete(category);
        return new CategoryResponse(category);
    }

    @Override
    public CategoryResponse update(UpdateCategoryRequest updateCategoryRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Optional<Category> existingCategory = categoryRepository.findById(updateCategoryRequest.getId());
        if (!existingCategory.isPresent())
            throw new NoSuchElementException("Category not found");
        Category category=existingCategory.get();
        category.setDateModified(currentDateTime);
        category.setName(updateCategoryRequest.getName());
        return new CategoryResponse(category);
    }

    @Override
    public CategoryResponse findCategoryById(Long id) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (!existingCategory.isPresent())
            throw new NoSuchElementException("Category not found");
        Category category=existingCategory.get();
        return new CategoryResponse(category);
    }

}

package zw.co.afrosoft.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.dto.UpdateCategoryRequest;
import zw.co.afrosoft.dto.request.CategoryRequest;
import zw.co.afrosoft.persistence.CategoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity create(CategoryRequest categoryRequest) {
        Category category = new Category();
        LocalDateTime currentDateTime = LocalDateTime.now();
        category.setDateCreated(currentDateTime);
        category.setDateModified(currentDateTime);
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.OK).body(category);
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
    public ResponseEntity update(UpdateCategoryRequest updateCategoryRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Optional<Category> existingCategory = categoryRepository.findById(updateCategoryRequest.getId());
        if (!existingCategory.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        Category category=existingCategory.get();
        category.setDateModified(currentDateTime);
        category.setName(updateCategoryRequest.getName());
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @Override
    public ResponseEntity findCategoryById(Long id) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (!existingCategory.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category with id {0} Not found");
        Category category=existingCategory.get();
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

}

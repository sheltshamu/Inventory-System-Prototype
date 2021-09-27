package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.CategoryRequest;
import zw.co.afrosoft.dto.CategoryResponse;
import zw.co.afrosoft.persistence.CategoryRepository;
import zw.co.afrosoft.persistence.ProductRepository;

@Service
public class ProductService {

    private  final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product create(CategoryRequest categoryRequest){
        Category category = ca
    }
}

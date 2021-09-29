package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.CategoryRequest;
import zw.co.afrosoft.dto.CategoryResponse;
import zw.co.afrosoft.dto.ProductRequest;
import zw.co.afrosoft.persistence.CategoryRepository;
import zw.co.afrosoft.persistence.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private  final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product create(ProductRequest productRequest){
        Optional<Category> category = categoryRepository.findById(productRequest.getCategory().getId());
        if (productRequest==null){
           productRequest = new ProductRequest();
           productRequest.setCategory(category.get());
        }
        Product product = new Product(productRequest);
        return productRepository.save(product);

    }

    public List<Product> listAll(){
       return productRepository.findAll();
    }
}

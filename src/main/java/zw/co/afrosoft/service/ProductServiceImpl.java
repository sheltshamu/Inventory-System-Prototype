package zw.co.afrosoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.request.ProductRequest;
import zw.co.afrosoft.persistence.CategoryRepository;
import zw.co.afrosoft.persistence.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product create(ProductRequest productRequest) {
       // logger.info("Category ={}", categoryRepository.getById(productRequest.getCategoryId()));
        Category category = categoryRepository.findById(productRequest.getCategoryId()).get();
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPurchasePrice(productRequest.getPurchasePrice());
        product.setSellingPrice(productRequest.getSellingPrice());
        product.setQuantityOnHand(productRequest.getQuantityOnHand());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }
}

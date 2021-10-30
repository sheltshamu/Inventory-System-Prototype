package zw.co.afrosoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.domain.ProductStockTake;
import zw.co.afrosoft.dto.UpdateProductRequest;
import zw.co.afrosoft.dto.request.ProductRequest;
import zw.co.afrosoft.dto.response.ProductResponse;
import zw.co.afrosoft.exception.NoRecordExistException;
import zw.co.afrosoft.persistence.CategoryRepository;
import zw.co.afrosoft.persistence.ProductRepository;
import zw.co.afrosoft.persistence.ProductStockTakeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductStockTakeRepository productStockTakeRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductStockTakeRepository productStockTakeRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productStockTakeRepository = productStockTakeRepository;
    }

    public ProductResponse create(ProductRequest productRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Optional<Category> category = categoryRepository.findById(productRequest.getCategoryId());
        if(!category.isPresent())
            throw new   RuntimeException("Category Not Found");

            Product product = new Product();
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPurchasePrice(productRequest.getPurchasePrice());
            product.setSellingPrice(productRequest.getSellingPrice());
            product.setQuantityOnHand(productRequest.getQuantityOnHand());
            product.setCategory(category.get());
            product.setDateCreated(currentDateTime);
            product.setDateModified(currentDateTime);
            productRepository.save(product);
            return new ProductResponse(product);

    }

    public List<Product> listAll() {
        List<Product> product=productRepository.findAll();
        return product;
    }

    @Override
    public ProductResponse update(UpdateProductRequest updateProductRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Optional<Product> existingProduct = productRepository.findById(updateProductRequest.getId());
        if (!existingProduct.isPresent())
             throw new   RuntimeException("Product Not Found");
        Product product = existingProduct.get();
        product.setDescription(updateProductRequest.getDescription());
        product.setPurchasePrice(updateProductRequest.getPurchasePrice());
        product.setSellingPrice(updateProductRequest.getSellingPrice());
        product.setName(updateProductRequest.getName());
        return new ProductResponse(product);
    }

    private void validateRequest(ProductRequest productRequest){

    }
}

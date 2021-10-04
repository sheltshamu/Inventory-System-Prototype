package zw.co.afrosoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.request.ProductRequest;
import zw.co.afrosoft.dto.response.ProductResponse;
import zw.co.afrosoft.persistence.CategoryRepository;
import zw.co.afrosoft.service.ProductServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
 @RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductServiceImpl productService;
    private final CategoryRepository categoryService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductServiceImpl productService, CategoryRepository categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse create(@Valid @RequestBody ProductRequest productRequest){
        logger.info("Create Product: productRequest={}", productRequest);
      Product product = productService.create(productRequest);
      return new ProductResponse(product);
    }

    @GetMapping("/get-all")
    public List<ProductResponse> getAll(){
        List<Product> productList = productService.listAll();
        List<ProductResponse> productResponseList=new ArrayList<>();
        productList.stream().forEach(product -> productResponseList.add(new ProductResponse(product)));
        return productResponseList;
    }
}

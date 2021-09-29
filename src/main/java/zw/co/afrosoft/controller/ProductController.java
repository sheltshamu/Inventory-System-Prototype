package zw.co.afrosoft.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.ProductRequest;
import zw.co.afrosoft.dto.ProductResponse;
import zw.co.afrosoft.service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
 @RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductServiceImpl productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ProductResponse create(@RequestBody ProductRequest productRequest){
        logger.info("Create Product: productRequest={}" +productRequest);
      Product product = productService.create(productRequest);
      return new ProductResponse(product);
    }

    @GetMapping("/get-all")
    public List<ProductResponse> getAll(){
        List<Product> productList = productService.listAll();
        List<ProductResponse> productResponseList=new ArrayList<>();
        productList.stream().filter(product -> productResponseList.add(new ProductResponse(product)));
        return productResponseList;
    }
}

package com.market.web.controller;

import com.market.domain.Product;
import com.market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    /*@Autowired*/
    private final ProductService productService;

    // Inyección por constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Get all supermarket products",
            description = "Returns a list of all available products"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful operation",
            content = @Content(schema = @Schema(implementation = Product.class))
    )
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int productId) {

        return productService.getById(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("id") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        return productService.delete(productId) ?  new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

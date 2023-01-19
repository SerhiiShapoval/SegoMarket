package com.example.segomarket.controller;

import com.example.segomarket.model.Product;
import com.example.segomarket.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    @GetMapping("/")
    public ResponseEntity<List<Product>> findProductByTitle (@RequestParam(name = "title",required = false) String title){
        return new ResponseEntity<>(productService.findByTitle(title), HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @PostMapping("/product/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @RequestParam MultipartFile file1,
                                                 @RequestParam MultipartFile file2,@RequestParam MultipartFile file3 ) throws IOException {
        productService.saveProduct(product,file1,file2,file3);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/product/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){

        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

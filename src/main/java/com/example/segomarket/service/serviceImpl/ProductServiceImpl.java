package com.example.segomarket.service.serviceImpl;

import com.example.segomarket.model.Image;
import com.example.segomarket.model.Product;
import com.example.segomarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements com.example.segomarket.service.ProductService {
   private final ProductRepository productRepository;
   private final ImageServiceImpl imageService;

   public   List<Product> findByTitle(String title){
      log.info("Start find pruduct by title {}",title);
      if (title!= null) return productRepository.findByTitle(title);
      return productRepository.findAll();
   }

   public void saveProduct(Product product, MultipartFile file1,MultipartFile file2,MultipartFile file3) throws IOException {
      log.info("Start saving product ");
     if (file1.getSize() != 0){
        Image image1 = imageService.toImageEntity(file1);
        image1.setPreviewImage(true);
        product.addImageToProduct(image1);
     }
      if (file2.getSize() != 0){
         Image image2 = imageService.toImageEntity(file1);
         product.addImageToProduct(image2);
      }
      if (file3.getSize() != 0){
         Image image3 = imageService.toImageEntity(file1);
         product.addImageToProduct(image3);
      }
      log.info("Saving product with Title : {}; Author: {}",product.getTitle(),product.getAuthor());
      Product product1 = productRepository.save(product);
      product1.setPreviewImageId(product1.getImages().get(0).getId());
      productRepository.save(product);
   }
   public void deleteProductById(Long id){
      log.info("Start delete product by {}", id);
      productRepository.deleteById(id);
   }
   public Product getProductById (Long id){
      log.info("Get product bty id {}", id);
     return productRepository.findById(id).orElse(null);
   }
}

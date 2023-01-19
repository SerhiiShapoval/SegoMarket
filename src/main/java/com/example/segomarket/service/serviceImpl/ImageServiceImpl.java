package com.example.segomarket.service.serviceImpl;

import com.example.segomarket.model.Image;
import com.example.segomarket.service.ImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ImageServiceImpl implements ImageService {
    @Override
    public Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}

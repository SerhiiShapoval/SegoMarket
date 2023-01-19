package com.example.segomarket.service;

import com.example.segomarket.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Image toImageEntity(MultipartFile file) throws IOException;
}

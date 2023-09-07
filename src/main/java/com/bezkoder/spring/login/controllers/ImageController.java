package com.bezkoder.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.bezkoder.spring.login.repository.ImageRepository;
import com.bezkoder.spring.login.security.services.ImageService;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ImageController{

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/images")
    public Map<String, String> uploadImage(@RequestPart("image") MultipartFile file) {
        Map<String, String> response = new HashMap<>();
        try {
            String imageUrl = imageService.saveImage(file); // 이미지를 저장하고 저장된 이미지 URL을 얻음
            response.put("imageUrl", imageUrl);
            response.put("message", "Image uploaded successfully");
        } catch (IOException e) {
            response.put("message", "Image upload failed");
        }
        return response;
    }
}

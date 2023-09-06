package com.bezkoder.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.bezkoder.spring.login.repository.ImageRepository;
import com.bezkoder.spring.login.security.services.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImageController{

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/images")
    public ResponseEntity<String> uploadImage(@RequestPart("image") MultipartFile image) {
        try {
            System.out.println("ss");
            // 이미지를 서버에 저장하고 저장된 파일 경로를 반환하는 서비스 메서드 호출
            String imagePath = imageService.uploadImage(image);
            return ResponseEntity.ok(imagePath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        }
    }
}

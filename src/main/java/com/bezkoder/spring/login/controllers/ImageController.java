package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Image;
import com.bezkoder.spring.login.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class ImageController {

    private static final String UPLOAD_DIR = "C:/images";

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/api/images")
    public ResponseEntity<String> uploadImage(@RequestBody byte[] imageBytes, @RequestHeader String latitude, @RequestHeader String longitude) {
        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormat.format(new Date());
            String uniqueFilename = timestamp + "_" + UUID.randomUUID().toString() + ".jpg";

            File imageFile = new File(uploadDir, uniqueFilename);
            try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                fos.write(imageBytes);
            }

            // Image 엔티티를 생성하여 데이터베이스에 저장
            Image image = new Image(uniqueFilename, latitude, longitude);
            imageRepository.save(image);

            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Image upload failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

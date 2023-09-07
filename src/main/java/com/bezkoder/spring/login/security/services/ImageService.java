package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.ImageEntity;
import com.bezkoder.spring.login.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageService {

    private final String uploadDir = "uploads"; // 이미지를 저장할 디렉토리 경로

    @Autowired
    private ImageRepository imageRepository;

    public String saveImage(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        Path uploadPath = Path.of(uploadDir);
        Files.createDirectories(uploadPath);
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        String imageUrl = "/api/images/" + fileName;

        // 이미지 URL을 데이터베이스에 저장
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageUrl(imageUrl);
        imageRepository.save(imageEntity);

        return imageUrl;
    }
}
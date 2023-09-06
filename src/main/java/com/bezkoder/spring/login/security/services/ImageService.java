package com.bezkoder.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.bezkoder.spring.login.models.Image;
import com.bezkoder.spring.login.controllers.ImageController;
import com.bezkoder.spring.login.repository.ImageRepository;
import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public String uploadImage(MultipartFile image) throws IOException {
        // MultipartFile을 바이트 배열로 변환
        byte[] imageData = image.getBytes();

        // 이미지 데이터를 저장할 Image 엔티티 생성
        Image imageEntity = new Image();
        imageEntity.setData(imageData);

        // Image 엔티티를 저장하고 이미지 ID를 반환
        Image savedImage = imageRepository.save(imageEntity);
        System.out.println(savedImage);
        return String.valueOf(savedImage.getId());
    }
}
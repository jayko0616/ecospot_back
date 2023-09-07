package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    ImageEntity save(ImageEntity image);

}
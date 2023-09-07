package com.bezkoder.spring.login.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String latitude;
    private String longitude;

    // Getter와 Setter 메서드 생략

    public Image(String fileName, String latitude, String longitude) {
        this.fileName = fileName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

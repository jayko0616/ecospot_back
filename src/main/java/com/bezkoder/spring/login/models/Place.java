package com.bezkoder.spring.login.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "places")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Place {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    private String category;

    // 생성자, Getter, Setter, toString 등 필요한 메서드 추가

    public Place(String name, double latitude, double longitude, String category) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
    }
}


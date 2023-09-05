package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAll();
    Place save(Place place); // 장소 저장
}

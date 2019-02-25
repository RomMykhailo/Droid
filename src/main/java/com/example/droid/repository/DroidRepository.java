package com.example.droid.repository;

import com.example.droid.entity.DroidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroidRepository extends JpaRepository<DroidEntity,Long> {

   List<DroidEntity> getAllByManufacturerAndModelId(String manufacturer, String modelId);
}

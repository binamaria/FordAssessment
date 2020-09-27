package com.ford.project.service;

import com.ford.project.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleService extends JpaRepository<Vehicle, Integer> {

    @Query(
            value = "SELECT * FROM VEHICLE v WHERE v.model = ?1",
            nativeQuery = true)
    List<Vehicle> findVehicleByModel(String model);

    @Query(
            value = "SELECT * FROM VEHICLE v WHERE v.FINAL_PRICE BETWEEN ?1 AND ?2",
            nativeQuery = true)
    List<Vehicle> findVehiclesByPrice(BigDecimal from, BigDecimal to);
}

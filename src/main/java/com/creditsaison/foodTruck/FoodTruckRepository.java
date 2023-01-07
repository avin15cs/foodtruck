package com.creditsaison.foodTruck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
    List<FoodTruck> findByApplicant(String applicant);
    @Query("SELECT f FROM FoodTruck f WHERE f.expirationDate <= :expirationDate")
    List<FoodTruck> findByExpirationDateBefore(@Param("expirationDate") String expirationDate);

    @Query("SELECT f FROM FoodTruck f WHERE f.address LIKE %:street%")
    List<FoodTruck> findByStreet(@Param("street") String street);
}

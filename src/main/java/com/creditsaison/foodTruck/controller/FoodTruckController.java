package com.creditsaison.foodTruck.controller;

import com.creditsaison.foodTruck.FoodTruck;
import com.creditsaison.foodTruck.FoodTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import com.creditsaison.foodTruck.service.DistanceCalculatorService;

@RestController
public class FoodTruckController {

    @Autowired
    private FoodTruckRepository foodTruckRepository;



    public FoodTruckController(FoodTruckRepository foodTruckRepository) {
        this.foodTruckRepository = foodTruckRepository;
    }

    @GetMapping("/food-trucks/search")
    public List<FoodTruck> search(@RequestParam(required = false) String applicant,@RequestParam(required = false) String expirationDate, @RequestParam(required = false) String street ) {
        if (applicant != null) {
            return foodTruckRepository.findByApplicant(applicant);
        } else if (expirationDate != null) {
            return foodTruckRepository.findByExpirationDateBefore(expirationDate);
        } else if(street != null) {
            return foodTruckRepository.findByStreet(street);
        } else {
            return Collections.emptyList();
        }
    }
    @PostMapping("/food-trucks")
    public FoodTruck addFoodTruck(@RequestBody FoodTruck foodTruck) {
        return foodTruckRepository.save(foodTruck);
    }

    @GetMapping("/food-trucks/closest")
    public FoodTruck findClosestFoodTruck(@RequestParam Double latitude, @RequestParam Double longitude) {
        List<FoodTruck> foodTrucks = foodTruckRepository.findAll();
        FoodTruck closest = null;
        Double minDistance = Double.MAX_VALUE;
        DistanceCalculatorService foodTruckService=new DistanceCalculatorService();
        for (FoodTruck foodTruck : foodTrucks) {
            Double distance = foodTruckService.calculateDistance(latitude, longitude, foodTruck.getLatitude(), foodTruck.getLongitude());
            if (distance < minDistance) {
                closest = foodTruck;
                minDistance = distance;
            }
        }
        return closest;
    }
}

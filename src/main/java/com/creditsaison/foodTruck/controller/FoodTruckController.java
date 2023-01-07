package com.creditsaison.foodTruck.controller;

import com.creditsaison.foodTruck.FoodTruck;
import com.creditsaison.foodTruck.FoodTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import com.creditsaison.foodTruck.service.FoodTruckService;

@RestController
public class FoodTruckController {

    @Autowired
    private FoodTruckRepository foodTruckRepository;



    public FoodTruckController(FoodTruckRepository foodTruckRepository) {
        this.foodTruckRepository = foodTruckRepository;
    }

    @GetMapping("/food-trucks/search/applicant")
    public List<FoodTruck> searchByApplicant(@RequestParam(value = "name") String applicant) {
        return foodTruckRepository.findByApplicant(applicant);
    }

    @GetMapping("/food-trucks/search/expiration")
    public List<FoodTruck> searchByExpirationDate(@RequestParam(value = "expirationDate") String expirationDate) {
        return foodTruckRepository.findByExpirationDateBefore(expirationDate);
    }

    @GetMapping("/food-trucks/search/address")
    public List<FoodTruck> searchByStreet(@RequestParam(value = "street") String street) {
        return foodTruckRepository.findByStreet(street);
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
        FoodTruckService foodTruckService=new FoodTruckService();
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

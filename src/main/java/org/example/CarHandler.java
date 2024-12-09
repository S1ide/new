package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CarHandler {

//    public static void writeFile(ArrayList<Car> cars, String path){
//        //TODO Реализовать сохранение списка cars в файл, находящийся по пути path
//    }
//
//    public static ArrayList<Car> readFile(String path) throws IllegalArgumentException{
//        //TODO реализовать чтение файла, а также всех данных в виде экземпляров класса
//    }





    public static ArrayList<Car> generateCars(int count){
        ArrayList<Car> cars = new ArrayList<>();
        String[] brands = {"Lada", "Mercedes", "Audi", "Hyundai", "BMW"};
        for (int i = 0; i < count; i++){
            Random random = new Random();
            double speed = 50 + 100 * random.nextDouble();
            double weight = 1000 + 2000 * random.nextDouble();
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            String brand = brands[random.nextInt(brands.length)];
            cars.add(new Car(brand, speed, weight, color));
        }
        return cars;
    }

    public static ArrayList<Truck> generateTrucks(int count){
        ArrayList<Truck> trucks = new ArrayList<>();
        String[] brands = {"Mercedes", "Scania", "MAN"};
        for (int i = 0; i < count; i++){
            Random random = new Random();
            double speed = 50 + 100 * random.nextDouble();
            double weight = 10000 + 5000 * random.nextDouble();
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            String brand = brands[random.nextInt(2)];
            double cargoWeight = 5000 + 7500 * random.nextDouble();
            Truck.CargoType type = Truck.CargoType.values()[random.nextInt(3)];
            try{
                trucks.add(new Truck(speed, weight, color, brand, cargoWeight, type));
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                i--;
            }
        }
        return trucks;
    }

    public static Car getMaxWeightCar(ArrayList<Car> cars){
        double maxWeight = Double.MIN_VALUE;
        Car maxWeightCar = null;
        for(Car car : cars){
            if (car.getWeight() > maxWeight){
                maxWeight = car.getWeight();
                maxWeightCar = car;
            }
        }
        return maxWeightCar;
    }

    public static Car getMaxSpeedCar(ArrayList<Car> cars){
        double maxSpeed = Double.MIN_VALUE;
        Car maxSpeedCar = null;
        for(Car car : cars){
            if (car.getSpeed() > maxSpeed){
                maxSpeed = car.getSpeed();
                maxSpeedCar = car;
            }
        }
        return maxSpeedCar;
    }

    public static ArrayList<Car> getFilteredByBrandCars(ArrayList<Car> cars, String brand){
        ArrayList<Car> filteredCars = new ArrayList<>();
        for(Car car : cars){
            if (car.getBrand().equals(brand)){
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public static Map<String, Integer> getBrandsCount(ArrayList<Car> cars){
        Map<String, Integer> map = new HashMap<>();
        for(Car car : cars){
            if (map.containsKey(car.getBrand())){
                map.put(car.getBrand(), map.get(car.getBrand()) + 1);
            }
            else{
                map.put(car.getBrand(), 1);
            }
        }
        return map;
    }


}

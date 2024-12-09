package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.util.Objects;


@Data
@AllArgsConstructor
public class Car {
    private final String brand;
    private final double speed;
    private final double weight;
    private final Color color;

//    public Car(){
//    }

//    public Car(double speed, double weight, Color color, String brand) {
//        this.speed = speed;
//        this.weight = weight;
//        this.color = color;
//        this.brand = brand;
//    }
//
//    public double getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(double speed) {
//        this.speed = speed;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "speed=" + speed +
//                ", weight=" + weight +
//                ", color=" + color +
//                ", brand='" + brand + '\'' +
//                '}';
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car =  (Car) o;
//        return Double.compare(speed, car.speed) == 0 && Double.compare(weight, car.weight) == 0 && Objects.equals(color, car.color) && Objects.equals(brand, car.brand);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(speed, weight, color, brand);
//    }
}


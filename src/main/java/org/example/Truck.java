package org.example;

import lombok.*;

import java.awt.*;


@Getter
@ToString
public class Truck extends Car {
    private final double cargoWeight;
    private final CargoType type;
    public enum CargoType {Products, Technique, Animal, Accessories}

    public Truck(double speed, double weight, Color color, String brand, double cargoWeight, CargoType type) {
        super(brand, speed, weight, color);
        this.cargoWeight = cargoWeight;
        this.type = type;
    }
//    public Truck(double speed, double weight, Color color, String brand, ) throws IllegalArgumentException {
//        super(speed, weight, color, brand);
//        if (cargoWeight > weight) {
//            throw new IllegalArgumentException("Вес груза больше чем вес грузового автомобиля");
//        } else {
//            this.cargoWeight = cargoWeight;
//            this.type = type;
//        }
//    }


//    public double getCargoWeight() {
//        return cargoWeight;
//    }
//
//    public void setCargoWeight(double cargoWeight) {
//        this.cargoWeight = cargoWeight;
//    }
//
//    public CargoType getType() {
//        return type;
//    }

//    @Override
//    public void setWeight(double weight) {
//        if (cargoWeight > weight) {
//            System.out.println("Вес груза больше, чем вес грузового автомобиля");
//        } else {
//            super.setWeight(weight);
//        }
//    }

//    @Override
//    public String toString() {
//        return "Truck{" + "speed=" + getSpeed() + ", weight=" + getWeight() + ", color=" + getColor() + ", brand='" + getBrand() + '\'' + ", cargoWeight=" + cargoWeight + ", type=" + type + '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Truck truck = (Truck) o;
//        return Double.compare(cargoWeight, truck.cargoWeight) == 0 && type == truck.type && super.equals(o);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), cargoWeight, type);
//    }
}

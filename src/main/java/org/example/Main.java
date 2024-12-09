package org.example;


import org.jsoup.Jsoup;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = CarHandler.generateCars(100);
        Map<String, Integer> map = CarHandler.getBrandsCount(cars);
        Graph graph = new Graph(map);
        graph.setVisible(true);
    }
}
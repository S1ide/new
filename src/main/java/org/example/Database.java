package org.example;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static Connection connection;
    private static Statement statement;


    public static void connectDB() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db");
        statement = connection.createStatement();
    }

    public static void createTableTruck() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS Trucks (" +
                "brand TEXT," +
                "speed FLOAT," +
                "weight FLOAT," +
                "color TEXT," +
                "weightCargo FLOAT," +
                "cargoType TEXT)");
    }

    public static void createTableCar() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS Cars (" +
                "brand TEXT," +
                "speed DOUBLE," +
                "weight DOUBLE," +
                "color TEXT)");
    }

    public static void inputDataCar(ArrayList<? extends Car> cars) throws SQLException {
        for(Car car : cars){
            if (car instanceof Truck){
                Truck truck = (Truck) car;
                statement.execute(String.format("INSERT INTO Trucks " +
                                "VALUES ('%s', '%.2f', '%.2f', '%s', '%.2f', '%s')", truck.getBrand(), truck.getSpeed(), truck.getWeight(),
                        truck.getColor().toString(),
                        truck.getCargoWeight(),
                        truck.getType().toString()));
            }
            else {
                statement.execute(String.format("INSERT INTO Cars " +
                        "VALUES ('%s', '%.2f', '%.2f', '%s')", car.getBrand(), car.getSpeed(), car.getWeight(), car.getColor().toString()));
            }
        }
    }

    public static void deleteData() throws SQLException {
        statement.execute("DROP TABLE IF EXISTS Cars");
        statement.execute("DROP TABLE IF EXISTS Trucks");
    }

    public static ArrayList<Car> readData() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Cars");
        ArrayList<Car> cars = getDataFromResultSet(resultSet);
        return cars;
    }

    public static ArrayList<Car> getCarsFilteredByBrand(String brand) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Cars WHERE brand = '%s'", brand));
        ArrayList<Car> cars = getDataFromResultSet(resultSet);
        return cars;
    }

    private static ArrayList<Car> getDataFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Car> cars = new ArrayList<>();
        while(resultSet.next()){
            String brand = resultSet.getString("brand");
            double speed = resultSet.getDouble("speed");
            double weight = resultSet.getDouble("weight");
            String[] strColor = resultSet.getString("color").split(",");
            String[] r = strColor[0].split("=");
            String[] g = strColor[1].split("=");
            String[] b = strColor[2].split("=");
            Color color = new Color(Integer.parseInt(r[r.length - 1]),
                    Integer.parseInt(g[g.length - 1]),
                    Integer.parseInt(b[b.length - 1].replace("]", "")));
            Car car = new Car(brand, speed, weight, color);
            cars.add(car);
        }
        return cars;
    }

    public static void closeDb() throws SQLException {

        statement.close();
        connection.close();
    }



}

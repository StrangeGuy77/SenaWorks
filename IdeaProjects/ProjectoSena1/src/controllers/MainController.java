package controllers;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import helpers.Conexion;
import models.Student;
import models.Product;
import org.jetbrains.annotations.Contract;

public class MainController {

    private int currentSession = 0;
    private String currentCrud = "";
    private String username = "";

    public MainController(boolean firstCrudStatus, boolean secondCrudStatus){
        if(firstCrudStatus){
            this.currentSession = 1;
            this.currentCrud = "products";
        } else if(secondCrudStatus){
            this.currentSession = 1;
            this.currentCrud = "students";
        }
    }

    // Database reading for login process
    public boolean login(String username, String password){

        this.username = username;

        try {
            Connection cn = Conexion.conectar();
            assert cn != null;
            PreparedStatement pst =  cn.prepareStatement("SELECT code FROM users WHERE username = '" + getUsername() + "' AND password = '" + password + "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e){
            System.out.println("There was an error gathering information from database: " + e.getMessage());
        }
        return false;
    }

    // Crud general functions
    public boolean createData(String sql){
        if(getCurrentSession() != 0) {
            try {
                Connection cn = Conexion.conectar();
                assert cn != null;
                PreparedStatement pst =  cn.prepareStatement(sql);
                int check = pst.executeUpdate();
                if(check > 0){
                    return true;
                }
            } catch (SQLException e){
                System.out.println("There was an error inserting data into student database: " + e.getMessage());
            }
        }
        return true;
    }

    // Controller for reading student data
    public List<Student> readStudentData(){

        ArrayList<Student> dataArray = new ArrayList<>();

        try {
            Connection cn = Conexion.conectar();
            assert cn != null;
            PreparedStatement pst =  cn.prepareStatement("SELECT * FROM students");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                while (rs.next()){
                    String name = rs.getString("name");
                    String direction = rs.getString("direction");
                    String course = rs.getString("course");
                    int phone = rs.getInt("phone");
                    int code = rs.getInt("code");
                    Student std = new Student(name, direction, course, phone, code);
                    dataArray.add(std);
                }
            }
        } catch (SQLException e){
            System.out.println("There was an error reading data from student database: " + e.getMessage());
        }

        return dataArray;
    }


    // Controller for reading product data
    public List<Product> readProductData(){

        ArrayList<Product> dataArray = new ArrayList<>();

        try {
            Connection cn = Conexion.conectar();
            assert cn != null;
            PreparedStatement pst =  cn.prepareStatement("SELECT * FROM products");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                while (rs.next()){
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    int code = rs.getInt("code");
                    Product pdt = new Product(name, price, quantity, code);
                    dataArray.add(pdt);
                }
            }
        } catch (SQLException e){
            System.out.println("There was an error reading data from product database: " + e.getMessage());
        }
        return dataArray;
    }

    public boolean updateData(String sql){
        try {
            Connection cn = Conexion.conectar();
            assert cn != null;
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e){
            System.out.println("There was an error updating data to " + getCurrentCrud() + " database: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteData(String sql){
        try {
            Connection cn = Conexion.conectar();
            assert cn != null;
            PreparedStatement pst = cn.prepareStatement(sql);
            int check = pst.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e){
            System.out.println("There was an error deleting data from " + getCurrentCrud() + " database: " + e.getMessage());
        }
        return false;
    }

    // Getters only, setters ain't useful here.
    @Contract(pure = true)
    private String getCurrentCrud(){
        return this.currentCrud;
    }
    @Contract(pure = true)
    private String getUsername(){
        return this.username;
    }
    @Contract(pure = true)
    private int getCurrentSession(){
        return this.currentSession;
    }


}
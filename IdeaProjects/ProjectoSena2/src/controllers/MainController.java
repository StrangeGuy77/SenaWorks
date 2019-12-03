package controllers;

import java.sql.*;

public class MainController {

    private String username;

    public boolean login(String username, String password){

        this.username = username;

        try {
            Connection cn = helpers.Conexion.conectar();
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

    private String getUsername(){
        return this.username;
    }


}

package controllers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    /* fulFillTable, as its name indicate, fills the whole table with the rows needed from database
    * with three params: the model itself, the number of rows of the table, and the sql
    * the SQL must be provided due to incompatibilities with database tables.
    * This method return the provided model filled with data rows.
    */

    /* Tal como su nombre indica, fulFillTable, llena el modelo de la tabla con las filas necesarias
    * traídas desde la base de datos. Esta función recibe tres parámetros: El modelo en sí mismo,
    * el número de filas de la tabla, y la instrucción SQL.
    * La instrucción SQL debe ser provista debido a incompatibilidades con las tablas y para mayor
    * dinamismo al poder llenar cualquier tipo de tabla con un sólo método.
    * Este método retorna el modelo lleno con las filas.
     */
    public DefaultTableModel fulfillTable(DefaultTableModel model, int tableRows, String sql){
        try {
            Connection cn = helpers.Conexion.conectar();
            assert cn != null;
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Object[] row = new Object[tableRows];
                for (int i = 0; i < tableRows; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
            cn.close();
            return model;
        } catch (SQLException e){
            System.out.println("There was an error retrieving information from database: \n " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, "Hubo un error al llenar la tabla, contacte al administrador.");
        }
        return (null);
    }

    private String getUsername(){
        return this.username;
    }
}

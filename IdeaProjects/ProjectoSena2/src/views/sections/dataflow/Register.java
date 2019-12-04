package views.sections.dataflow;

import controllers.MainController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Register extends JFrame {

    protected String sql = "SELECT * FROM empleado";

    public Register(){

        this.setSize(600,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Registros de flujo");

        DefaultTableModel model = new DefaultTableModel();
        JScrollPane panel = new JScrollPane();
        panel.setBounds(1,1,600,400);

        model.addColumn("Código");
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("Departamento");
        model.addColumn("Puesto");
        model.addColumn("Salario");
        model.addColumn("Área resp.");
        // watch MainController documentation for fulfill method explanation.
        // ver la documentación de la clase MainController para la explicación del método fulfillTable.
        model = new MainController().fulfillTable(model, 7, sql);

        // Sout works as a debugger for table model, ICONIFIED is a constant variable whose value is 1.
        // Sout funciona como debugger para el modelo de la tabla. ICONIFIED es una constante cuyo valor es 1.
        System.out.println(model.getColumnName(ICONIFIED));
        JTable tablaRegistros = new JTable(model);
        panel.setViewportView(tablaRegistros);
    }


    public static void main(String[] args) {
        new Register().setVisible(true);
    }

}

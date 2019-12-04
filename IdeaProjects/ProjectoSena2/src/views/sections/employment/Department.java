package views.sections.employment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Department extends JFrame {

    public Department(){
        this.setSize(600,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Departamentos y empleados");

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



    }
}

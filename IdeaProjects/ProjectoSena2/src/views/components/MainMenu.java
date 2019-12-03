package views.components;

import views.sections.dataflow.Register;
import views.sections.employment.Department;

import javax.swing.*;

public class MainMenu extends JFrame {

    MainMenu(){
        // Window settings
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);

        // Components
        JLabel firstCrudLabel = new JLabel("Revisar productos");
        firstCrudLabel.setBounds(0,0,0,0);
        this.add(firstCrudLabel);

        JLabel secondCrudLabel = new JLabel("Revisar estudiantes");
        secondCrudLabel.setBounds(0,0,0,0);
        this.add(secondCrudLabel);

        JButton firstCrudButton = new JButton("Abrir interfaz de productos");
        firstCrudButton.setBounds(0,0,0,0);
        this.add(firstCrudButton);

        JButton secondCrudButton = new JButton("Abrir interfaz de estudiantes");
        secondCrudButton.setBounds(0,0,0,0);
        this.add(secondCrudButton);

        // Event listeners
        firstCrudButton.addActionListener(actionEvent -> {
            new Register().setVisible(true);
        });

        secondCrudButton.addActionListener(actionEvent -> {
            new Department().setVisible(true);
        });

    }

}

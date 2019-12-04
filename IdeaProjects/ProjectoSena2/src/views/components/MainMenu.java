package views.components;

import views.sections.dataflow.Register;
import views.sections.employment.Department;

import javax.swing.*;

public class MainMenu extends JFrame {

    MainMenu(String username){
        // Window settings
        this.setSize(600,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Menú principal");

        // Components
        JLabel welcomeLabel= new JLabel("Bienvenido " + username + "!");
        welcomeLabel.setBounds(20,30,220,20);
        this.add(welcomeLabel);

        JButton firstCrudButton = new JButton("Abrir interfaz de registros");
        firstCrudButton.setBounds(20,110,250,150);
        this.add(firstCrudButton);

        JButton secondCrudButton = new JButton("Abrir interfaz de empleados");
        secondCrudButton.setBounds(330,110,250,150);
        this.add(secondCrudButton);

        // Event listeners
        firstCrudButton.addActionListener(actionEvent -> {
            new Register().setVisible(true);
        });

        secondCrudButton.addActionListener(actionEvent -> {
            new Department().setVisible(true);
        });

    }

    public static void main(String[] args) {
        new MainMenu("XD").setVisible(true);
    }

}

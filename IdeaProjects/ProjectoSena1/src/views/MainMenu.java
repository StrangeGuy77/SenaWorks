package views;

import org.jetbrains.annotations.Contract;

import javax.swing.*;
import views.product.mainProduct;
import views.student.mainStudent;

public class MainMenu extends JFrame {

    @Contract(pure = true)
    MainMenu(){
        // Window settings
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            mainProduct nextView = new mainProduct();
            nextView.setVisible(true);
        });

        secondCrudButton.addActionListener(actionEvent -> {
            mainStudent nextView = new mainStudent();
            nextView.setVisible(true);
        });

    }

}

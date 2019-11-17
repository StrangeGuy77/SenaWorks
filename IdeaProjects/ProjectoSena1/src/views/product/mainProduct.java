package views.product;

import javax.swing.*;

public class mainProduct extends JFrame {
    public mainProduct(){

        // Window settings
        this.setSize(800,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Components
        JButton insertProduct = new JButton("Insertar un producto");
        insertProduct.setBounds(0,0,0,0);
        this.add(insertProduct);

        // Event listeners
        insertProduct.addActionListener(actionEvent -> {

        });


    }
}

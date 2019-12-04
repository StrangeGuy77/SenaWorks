package views.components;

import javax.swing.*;
import controllers.MainController;

import java.util.Arrays;

class Login extends JFrame {

    Login(){
        // Window settings
        this.setSize(280, 300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Iniciar sesión");

        // Components
        JLabel lbl_username = new JLabel("Nombre de usuario");
        lbl_username.setBounds(20,30,120,20);
        this.add(lbl_username);

        JLabel lbl_password = new JLabel("Contraseña");
        lbl_password.setBounds(20,60,80,20);
        this.add(lbl_password);

        JTextField txt_username = new JTextField();
        txt_username.setBounds(150,30,100,30);
        this.add(txt_username);

        JPasswordField txt_password = new JPasswordField();
        txt_password.setBounds(150,60,100,30);
        this.add(txt_password);

        JButton loginButton = new JButton("Ingresar");
        loginButton.setBounds(150,200,100,30);
        this.add(loginButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(30,200,100,30);
        this.add(cancelButton);

        // Event listeners
        loginButton.addActionListener(actionEvent -> {
            String username = txt_username.getText();
            String password = txt_password.getText();
            if (!username.isEmpty() && !password.isEmpty()) {
                boolean confirmation = new MainController().login(username, password);
                if (confirmation) {
                    this.setVisible(false);
                    new MainMenu(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes llenar ambos campos");
            }
        });

        cancelButton.addActionListener(actionEvent -> {
            System.exit(0);
        });

    }

}

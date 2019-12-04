package views.components;

import javax.swing.*;

public class Presentation extends JFrame {

    public Presentation() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        JLabel presentationLabel = new JLabel("Bienvenido a CONSTRUCCIÓN S.A.S");
        presentationLabel.setBounds(20,20,300,60);
        this.add(presentationLabel);

        // timeOut method stops the running of the CURRENT THREAD for X seconds, then, hides THIS and shows Login.
        // el método timeOut detiene la ejecución de ESTE HILO por X segundos, después, oculta ESTA ventana y muestra Login.
        timeOut(5000);
    }

    private void timeOut(int time){
        new Thread(() -> {
            try {
                Thread.sleep(time);
                new Login().setVisible(true);
                this.setVisible(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

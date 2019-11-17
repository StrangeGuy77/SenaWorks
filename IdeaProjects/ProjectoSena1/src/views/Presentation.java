package views;

import javax.swing.*;

public class Presentation extends JFrame {

    private Presentation() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(400, 200);

        JLabel presentationLabel = new JLabel("test");
        presentationLabel.setBounds(20,20,60,60);
        this.add(presentationLabel);
    }

    private static boolean timeOut(){

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return true;
    }



    public static void main(String[] args){
        Presentation form = new Presentation();
        form.setLocationRelativeTo(null);
        form.setResizable(false);

            form.setVisible(false);

            Login login = new Login();
            login.setVisible(true);

    }

}

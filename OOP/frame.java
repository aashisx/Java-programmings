import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frame {
    public static void main(String[] args) {
        JFrame f = new JFrame("Color Buttons");
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        JButton redButton = new JButton("Red");
        JButton greenButton = new JButton("Green");
        JButton blueButton = new JButton("Blue");


        redButton.addActionListener(e -> f.getContentPane().setBackground(Color.RED));
        greenButton.addActionListener(e -> f.getContentPane().setBackground(Color.GREEN));
        blueButton.addActionListener(e -> f.getContentPane().setBackground(Color.BLUE));

        f.add(redButton);
        f.add(greenButton);
        f.add(blueButton);

        f.setVisible(true);
    }
}

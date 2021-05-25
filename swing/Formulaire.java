package swing;

import java.awt.*;
import javax.swing.*;
 

public class Formulaire {

	
	public static void main(String s[]) {  
        JFrame frame = new JFrame("formulaire");  
        JPanel panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        // JLabel label = new JLabel("valider");  
        JButton b1 = new JButton();  
        b1.setText("action1");
		JButton b2 = new JButton();  
        b2.setText("action2"); 
		JButton b3 = new JButton();  
        b3.setText("action3");  
        // panel.add(label);  
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        frame.add(panel);  
        frame.setSize(400, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}

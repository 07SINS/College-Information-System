package college.information.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
    	
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Shrishaan.jpg"));
        Image i2 = i1.getImage().getScaledInstance(185, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>College<br/>Information System</html>");
        heading.setBounds(70, 20, 300, 155);
        heading.setFont(new Font("Tahoma", Font.BOLD, 40));
        add(heading);
        
        JLabel name = new JLabel("Contact:");
        name.setBounds(70, 220, 550, 50);
        name.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(name);
        
        JLabel name01 = new JLabel("ShrishaanBajracharya@gmail.com");
        name01.setBounds(181, 220, 550, 50);
        name01.setFont(new Font("Tahoma", Font.PLAIN, 28));
        add(name01);
        
        
        JLabel rollno = new JLabel("Roll number: 23");
        rollno.setBounds(70, 260, 550, 40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(rollno);
        
        JLabel contact = new JLabel("<html>Batch: 2079<br/></br>Third Semester</html>");
        contact.setBounds(70, 305, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);
        
        setLayout(null);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new About();
    }
}

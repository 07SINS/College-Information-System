package college.information.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener{
	Choice cempId,time;
	JDateChooser dcdate;
	JButton submit,cancel;
	
	TeacherLeave(){
		
		setSize(500,550);
		setLocation(550,100);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		JLabel heading = new JLabel("Apply for leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblempId = new JLabel("Search by Employee Id");
        lblempId.setBounds(60, 100, 200, 20);
        lblempId.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblempId);
        
        cempId = new Choice();
        cempId.setBounds(60, 130, 200, 20);
        add(cempId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
            	cempId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
		add(dcdate);
        
		JLabel lbltime = new JLabel("Time Duration:");
		lbltime.setBounds(60, 260, 200, 20);
		lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);
        
        time = new Choice();
        time.setBounds(60, 290, 200, 20);
        time.add("Full Day");
        time.add("Half Day");
        add(time);
        
        submit = new JButton("Submit");
		submit.setBounds(60, 350, 100, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setFont(new Font("Tahoma", Font.BOLD, 18));
	    add(submit);
		
	    cancel = new JButton("Cancel");
	    cancel.setBounds(200, 350, 100, 25);
	    cancel.setBackground(Color.BLACK);
	    cancel.setForeground(Color.WHITE);
	    cancel.addActionListener(this);
	    cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
	    add(cancel);
		
		setVisible(true);
		
	}
	public void actionPerformed (ActionEvent ae) {
		if (ae.getSource()==submit) {
			String empId= cempId.getSelectedItem();
			String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
			String duration=time.getSelectedItem();
			String query = "insert into teacherleave values ('"+empId+"','"+date+"','"+duration+"')";
			
			try {
				Conn c = new Conn ();
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Leave granted!");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
				} 
			}else {
			setVisible(false);
		}
		
		
	}
	public static void main(String[] args) {
		new TeacherLeave(); 
		
	}

}

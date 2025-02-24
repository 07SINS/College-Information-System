package college.information.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener {

    Choice rollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        rollno = new Choice();
        rollno.setBounds(180, 20, 150, 20);
        add(rollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
            	rollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(320, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
        	String query = "select * from students where rollno = '"+rollno.getSelectedItem()+"'";
        	try {
        		Conn c = new Conn();
        		ResultSet rs = c.s.executeQuery(query);
        		table.setModel(DbUtils.resultSetToTableModel(rs));
        		
        	}catch (Exception e) {
        		e.printStackTrace();
        	}
        }else if(ae.getSource()==print){
        	try {
        		table.print();
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if (ae.getSource()==add) {
        	setVisible(false);
        	new AddStudent();
        }else {
        	setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}

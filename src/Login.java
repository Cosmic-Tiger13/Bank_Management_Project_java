package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{

    JButton clear ,login , signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        

        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);

        JLabel text =new JLabel("Welcome to ATM");
         text.setBounds(200, 40, 400, 40);
         text.setFont(new Font("Osward",Font.BOLD,38));
         add(text);

         JLabel card_no =new JLabel("Card No.:");
         card_no.setBounds(120, 150, 250, 40);
         card_no.setFont(new Font("Raleway",Font.BOLD,28));
         add(card_no);
         cardTextField=new JTextField();
         cardTextField.setBounds(300, 150, 250, 30);
         cardTextField.setFont(new Font("Ariel",Font.BOLD,14));
         add(cardTextField);

         JLabel pin =new JLabel("PIN:");
         pin.setBounds(120, 215, 250, 40);
         pin.setFont(new Font("Raleway",Font.BOLD,28));
         add(pin);
         pinTextField=new JPasswordField();
         pinTextField.setBounds(300, 220, 250, 30);
         pinTextField.setFont(new Font("Ariel",Font.BOLD,14));
         add(pinTextField);

         login =new JButton("Sign In");
         login.setBounds(300,300,100,30);
         login.setBackground(Color.BLACK);
         login.setForeground(Color.WHITE);
         login.addActionListener(this);
         add(login);

         clear =new JButton("Clear");
         clear.setBounds(450,300,100,30);
         clear.setBackground(Color.BLACK);
         clear.setForeground(Color.WHITE);
         clear.addActionListener(this);
         add(clear);

         signup =new JButton("Sign Up");
         signup.setBounds(375,370,100,30);
         signup.setBackground(Color.BLACK);
         signup.setForeground(Color.WHITE);
         signup.addActionListener(this);
         add(signup);
         

    
        getContentPane().setBackground(Color.white);
        label.setBounds(50,10, 100, 100);
        setTitle("Automatic Teller Machine");
        setSize(800,500);
        setVisible(true);
        setLocation(350,200);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        { conn conn=new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber =pinTextField.getText();

            String query ="select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";

            try{
             ResultSet rs=conn.s.executeQuery(query);

             if(rs.next())
             {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
             }
             else
             {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
             }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }

    public static void main(String[] args) throws Exception {
        new Login();
        }
    }

   


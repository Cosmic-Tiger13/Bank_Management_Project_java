package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    FastCash(String pinnumber)
    {  this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
       Image i2 =i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       JLabel image =new JLabel(i3);
       image.setBounds(0,0,900,850);
       add(image);

       JLabel text =new JLabel("Please select your Transaction");
       text.setBounds(220,300,400,50);
       text.setForeground(Color.white);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(text);

       deposit =new JButton("100");
       deposit.setBackground(Color.white);
       deposit.setForeground(Color.black);
       deposit.setFont(new Font("Raleway",Font.BOLD,14));
       deposit.setBounds(170,393,150,30);
       deposit.addActionListener(this);        
       image.add(deposit);

       withdraw =new JButton("200");
       withdraw.setBackground(Color.white);
       withdraw.setForeground(Color.black);
       withdraw.setFont(new Font("Raleway",Font.BOLD,14));
       withdraw.setBounds(350,393,150,30);
       withdraw.addActionListener(this);      
       image.add(withdraw);

       fastcash=new JButton("500");
       fastcash.setBackground(Color.white);
       fastcash.setForeground(Color.black);
       fastcash.setFont(new Font("Raleway",Font.BOLD,14));
       fastcash.setBounds(170,423,150,30);   
       fastcash.addActionListener(this);     
       image.add(fastcash);

       ministatement =new JButton("1000");
       ministatement.setBackground(Color.white);
       ministatement.setForeground(Color.black);
       ministatement.setFont(new Font("Raleway",Font.BOLD,14));
       ministatement.setBounds(350,423,150,30);
       ministatement.addActionListener(this);    
       image.add(ministatement);

       pinchange =new JButton("5000");
       pinchange.setBackground(Color.white);
       pinchange.setForeground(Color.black);
       pinchange.setFont(new Font("Raleway",Font.BOLD,14));
       pinchange.setBounds(170,453,150,30);   
       pinchange.addActionListener(this);     
       image.add(pinchange);

       balance =new JButton("10000");
       balance.setBackground(Color.white);
       balance.setForeground(Color.black);
       balance.setFont(new Font("Raleway",Font.BOLD,14));
       balance.setBounds(350,453,150,30);    
       balance.addActionListener(this);    
       image.add(balance);

       exit =new JButton("Back");
       exit.setBackground(Color.white);
       exit.setForeground(Color.black);
       exit.setFont(new Font("Raleway",Font.BOLD,14));
       exit.setBounds(350,483,150,30);
       exit.addActionListener(this);     
       image.add(exit);



       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
    }
    public static void main(String[] args) {
       new FastCash("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==exit)
        {
          setVisible(false);
          new Transaction(pinnumber).setVisible(true);
        }
        else
        {
           String cash=((JButton)ae.getSource()).getText();
           conn conn=new conn();
           try{
                 ResultSet rs=conn.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
                 int balance=0;
                while(rs.next())
                 {
               rs.next();
                  if(rs.getString("type").equals("Deposit"))
                  {
                       balance +=Integer.parseInt(rs.getString("cash"));
                  }
                  else
                  {
                     balance -=Integer.parseInt(rs.getString("cash"));
                  }
                  }
                 if(ae.getSource()!=exit && balance <= Integer.parseInt(cash))
                 {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                 }
               else{
                Date date =new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+cash+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,cash+" Rs Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                 }
                
           }
           catch(Exception e) 
           {
              System.out.println(e);
           }
        }
        }
    }


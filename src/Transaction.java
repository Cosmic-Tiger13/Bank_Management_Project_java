package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    Transaction(String pinnumber)
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

       deposit =new JButton("Deposit");
       deposit.setBackground(Color.white);
       deposit.setForeground(Color.black);
       deposit.setFont(new Font("Raleway",Font.BOLD,14));
       deposit.setBounds(170,393,150,30);
       deposit.addActionListener(this);        
       image.add(deposit);

       withdraw =new JButton("Cash Withdraw");
       withdraw.setBackground(Color.white);
       withdraw.setForeground(Color.black);
       withdraw.setFont(new Font("Raleway",Font.BOLD,14));
       withdraw.setBounds(350,393,150,30);
       withdraw.addActionListener(this);      
       image.add(withdraw);

       fastcash=new JButton("Fast Cash");
       fastcash.setBackground(Color.white);
       fastcash.setForeground(Color.black);
       fastcash.setFont(new Font("Raleway",Font.BOLD,14));
       fastcash.setBounds(170,423,150,30);   
       fastcash.addActionListener(this);     
       image.add(fastcash);

       ministatement =new JButton("Mini-Statement");
       ministatement.setBackground(Color.white);
       ministatement.setForeground(Color.black);
       ministatement.setFont(new Font("Raleway",Font.BOLD,14));
       ministatement.setBounds(350,423,150,30);
       ministatement.addActionListener(this);    
       image.add(ministatement);

       pinchange =new JButton("PIN change");
       pinchange.setBackground(Color.white);
       pinchange.setForeground(Color.black);
       pinchange.setFont(new Font("Raleway",Font.BOLD,14));
       pinchange.setBounds(170,453,150,30);   
       pinchange.addActionListener(this);     
       image.add(pinchange);

       balance =new JButton("Balance enquiry");
       balance.setBackground(Color.white);
       balance.setForeground(Color.black);
       balance.setFont(new Font("Raleway",Font.BOLD,14));
       balance.setBounds(350,453,150,30);    
       balance.addActionListener(this);    
       image.add(balance);

       exit =new JButton("Exit");
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
       new Transaction("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==exit)
        {
          System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
          setVisible(false);
          new Deposit(pinnumber).setVisible(true);;

        }
        else if(ae.getSource()==withdraw)
        {
          setVisible(false);
          new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
          setVisible(false);
          new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
          setVisible(false);
          new Pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance)
        {
          setVisible(false);
          new Balance(pinnumber).setVisible(true);
          
        }
        else if(ae.getSource()==ministatement)
        {
          setVisible(false);
          new Ministatement(pinnumber).setVisible(true);
        }
    }
}

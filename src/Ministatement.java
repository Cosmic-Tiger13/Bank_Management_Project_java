package bank_management_system;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ministatement extends JFrame  {
String pinnumber;  
    Ministatement(String pinnumber)
    {
       this.pinnumber=pinnumber;
       setLayout(null);

       JLabel mini= new JLabel();
       mini.setBounds(20,140,400,200);
       add(mini);

       JLabel bank=new JLabel("Bank Statement");
       bank.setBounds(150,20,100,20);
       add(bank);

       JLabel balancedisplay=new JLabel();
       balancedisplay.setBounds(20,400,300,20);
       add(balancedisplay);

       JLabel card =new JLabel();
       card.setBounds(20,80,300,20);
       add(card);

       try{
        conn conn=new conn();
        ResultSet rs=conn.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
        while(rs.next())
        {
            card.setText("Card Number: "+"XXXX-XXXX-XXXX-"+rs.getString("cardnumber").substring(12,16));
        }
       }
       catch(Exception e)
       {
        System.out.println(e);
       }

       try{
        conn conn=new conn();
        double balance=0.0;
        ResultSet rs=conn.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
        while (rs.next()) {
            mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("cash")+"<br><br><html>");

             if(rs.getString("type").equals("Deposit"))
                  {
                       balance +=Integer.parseInt(rs.getString("cash"));
                  }
                  else
                  {
                     balance -=Integer.parseInt(rs.getString("cash"));
                  }
        }
        balancedisplay.setText("Your current balance is :"+balance);
       }
       catch(Exception e)
       {
        System.out.println(e);
       }
       
        
       getContentPane().setBackground(Color.white);
       setSize(400,600);
       setLocation(20,20);
     //setUndecorated(true);
       setVisible(true);

    }

    public static void main(String[] args) {
        new Ministatement("");
    }
    
}

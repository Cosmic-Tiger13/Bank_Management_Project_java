package bank_management_system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Balance extends JFrame implements ActionListener{ 
    String pinnumber;
    JButton back,balancenquiry;
    JLabel image;
    Balance(String pinnumber)
    { 
      this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
       Image i2 =i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       this.image =new JLabel(i3);
       image.setBounds(0,0,900,850);
       add(image);

       back =new JButton("Back");
       back.setBounds(160, 458, 150, 30);
       back.addActionListener(this);
       image.add(back);
      
       double balance=0.0;
       conn conn=new conn();
          try{
            ResultSet rs=conn.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
            
            while(rs.next())
            {
            if(rs.getString("type").equals("Deposit"))
            {
              balance +=Integer.parseInt(rs.getString("cash"));
            }
            else
            {
            balance -=Integer.parseInt(rs.getString("cash"));
            }
            }
              JLabel text=new JLabel("Your current Account balance is Rs "+balance);
              text.setForeground(Color.white);
              text.setBounds(160,300,400,20);
              image.add(text);
            
      }
        catch(Exception e)
         {
        System.out.println(e);
        }

       setSize(900,900);
       setLocation(300,0);
     //setUndecorated(true);
       setVisible(true);
    }
    public static void main(String[] args) {
        new Balance("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==back)
      {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
      }
      
    
}
}

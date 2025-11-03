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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class Pinchange extends JFrame implements ActionListener {
    JPasswordField pin,cpin;
    JButton change,back;
    String pinnumber;

    Pinchange(String pinnumber) 
    {this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,850);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(260,250,500,30);
        image.add(text);

        JLabel pintext=new JLabel("New PIN :");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(160,300,100,30);
        image.add(pintext);

        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        pin.setBounds(270,300,200,30);
        image.add(pin);

        JLabel repintext=new JLabel("Confirm PIN :");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        repintext.setBounds(160,340,120,30);
        image.add(repintext);

        cpin=new JPasswordField();
        cpin.setFont(new Font("Raleway",Font.BOLD,14));
        cpin.setBounds(270,340,200,30);
        image.add(cpin);
       
        change=new JButton("Change");
        change.setBackground(Color.white);
        change.setForeground(Color.black);
        change.setFont(new Font("Raleway",Font.BOLD,14));
        change.setBounds(370,440,100,30);   
        change.addActionListener(this);     
        image.add(change);

        back=new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(190,440,100,30);   
        back.addActionListener(this);     
        image.add(back);


        setSize(900,850);
        setLocation(300,0);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae) 
    {if(ae.getSource()==change)
        {
       try{
           String npin=pin.getText();
           String repin=cpin.getText();
           boolean flag=true;

           if(npin.equals("") && flag)
           {
              JOptionPane.showMessageDialog(null,"Enter the new PIN");
              flag =false;
           }
           if(repin.equals("") && flag)
           {
            JOptionPane.showMessageDialog(null,"Enter the Confirm Pin");
            flag=false;
           }

           if(npin.equals(repin) && flag)
           { flag=false;
             conn conn =new conn();
             String query1="update bank set pinnumber ='"+repin+"' where pinnumber='"+pinnumber+"'";
             String query2="update login set pinnumber ='"+repin+"' where pinnumber='"+pinnumber+"'";
             String query3="update signupthree set pinnumber ='"+repin+"' where pinnumber='"+pinnumber+"'";

             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             conn.s.executeUpdate(query3);
             JOptionPane.showMessageDialog(null,"PIN changed successfully");
             setVisible(false);
             new Login().setVisible(true);
              
           }
           else
           {
             JOptionPane.showMessageDialog(null,"Entered PIN did not match");
           }


       }   
       catch(Exception e)
       {
        System.out.println(e);
       }
       }
    
    else if(ae.getSource()==back)
    {
          setVisible(false);
          new Transaction("").setVisible(true);
    }
}
}

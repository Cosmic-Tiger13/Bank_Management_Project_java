package bank_management_system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

    Withdrawl(String pinnumber)
    {this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
       Image i2 =i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       JLabel image =new JLabel(i3);
       image.setBounds(0,0,900,850);
       add(image);

       JLabel text =new JLabel("Enter the amount to be withdrawn");
       text.setBounds(220,300,400,50);
       text.setForeground(Color.white);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(text);

       amount =new JTextField();
       amount.setBounds(200,360,300,30);
       amount.setFont(new Font("Raleway",Font.BOLD,20));
       add(amount);

       withdraw =new JButton("Cash Withdrawl");
       withdraw.setBounds(375,460,130,30);
       withdraw.addActionListener(this);
       image.add(withdraw);

       back =new JButton("Back");
       back.setBounds(375,493,130,30);
       back.addActionListener(this);
       image.add(back);


       

       setSize(900,900);
       setLocation(300,0);
       //setUndecorated(true);
       setVisible(true);
    }
        public static void main(String[] args) {
            new Withdrawl("");
        
    }
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getSource()==withdraw)
            {
                String cash =amount.getText();
                Date date=new Date();
                if(cash.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter amount");
                }
                else
                {
                    try{
                    conn conn=new conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Cash Withdrawl','"+cash+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+cash+" Withdrawn Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
            }
            if(ae.getSource()==back)
            {
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
            }

        }
    
}

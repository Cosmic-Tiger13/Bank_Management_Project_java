package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


    public class SignupOne extends JFrame implements ActionListener
    {   long random;
        Random ran;
        JTextField nameTextField,fnameTextField,emailTextField,addressTextField,
        cityTextField,stateTextField,pincodeTextField;
        JButton next;
        JRadioButton maleButton,femalButton,married,unmarried,other;
        JDateChooser date;
       SignupOne()
     {   setLayout(null);
         ran =new Random();
        random=Math.abs(ran.nextLong()%9000L +1000L);
        JLabel formo =new JLabel("APPLICATION FORM NO. "+random);
        formo.setFont(new Font("Raleway",Font.BOLD,38));
        formo.setBounds(140,20,600,40);
        add(formo);

        JLabel person =new JLabel("Page 1:Personal details");
        person.setFont(new Font("Ariel",Font.BOLD,30));
        person.setBounds(230,100,600,40);
        add(person);

        JLabel name =new JLabel("Name:");
        name.setFont(new Font("Ariel",Font.BOLD,20));
        name.setBounds(140,200,100,30);
        nameTextField =new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(350,200,400,30);
        add(name);
        add(nameTextField);

        JLabel fname=new JLabel("Father Name:");
        fname.setFont(new Font("Ariel",Font.BOLD,20));
        fname.setBounds(140,240,200,30);
         fnameTextField =new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(350,240,400,30);
        add(fname);
        add(fnameTextField);
 
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Ariel",Font.BOLD,20));
        dob.setBounds(140,280,200,30);
        date =new JDateChooser();
        date.setBounds(350,280,400,30);
        add(dob);
        add(date);
        
        JLabel gender =new JLabel("Gender:");
        gender.setFont(new Font("Ariel",Font.BOLD,20));
        gender.setBounds(140,320,100,30);
         maleButton =new JRadioButton("Male");
        maleButton.setBounds(350, 320, 100, 30);
        maleButton.setBackground(Color.white);
        add(maleButton);
        femalButton=new JRadioButton("Female");
        femalButton.setBounds(460,320,100,30);
        femalButton.setBackground(Color.white);
        add(femalButton);
        ButtonGroup grButton =new ButtonGroup();
        grButton.add(maleButton);
        grButton.add(femalButton);
        add(gender);
        
        JLabel email =new JLabel("Email:");
        email.setFont(new Font("Ariel",Font.BOLD,20));
        email.setBounds(140,360,100,30);
        emailTextField =new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(350,360,400,30);
        add(email);
        add(emailTextField);

        JLabel marital =new JLabel("Marital Status:");
        marital.setFont(new Font("Ariel",Font.BOLD,20));
        marital.setBounds(140,400,200,30);
        ButtonGroup maritalButtonGroup =new ButtonGroup();
         married =new JRadioButton("Married");
        married.setBounds(350, 400, 100, 30);
        married.setBackground(Color.white);
        add(married);
         unmarried =new JRadioButton("Unmarried");
        unmarried.setBounds(460, 400, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        other =new JRadioButton("Other");
        other.setBounds(570, 400, 100, 30);
        other.setBackground(Color.white);
        add(other);
        maritalButtonGroup.add(married);
        maritalButtonGroup.add(unmarried);
        maritalButtonGroup.add(other);
        add(marital);

        JLabel address =new JLabel("Address:");
        address.setFont(new Font("Ariel",Font.BOLD,20));
        address.setBounds(140,440,100,30);
        addressTextField =new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(350,440,400,30);
        add(address);
        add(addressTextField);

        JLabel city =new JLabel("City:");
        city.setFont(new Font("Ariel",Font.BOLD,20));
        city.setBounds(140,480,100,30);
        cityTextField =new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(350,480,400,30);
        add(city);
        add(cityTextField);

        JLabel state =new JLabel("State:");
        state.setFont(new Font("Ariel",Font.BOLD,20));
        state.setBounds(140,520,100,30);
        stateTextField =new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(350,520,400,30);
        add(state);
        add(stateTextField);

        JLabel pincode =new JLabel("Pin Code:");
        pincode.setFont(new Font("Ariel",Font.BOLD,20));
        pincode.setBounds(140,560,100,30);
        pincodeTextField =new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(350,560,400,30);
        add(pincode);
        add(pincodeTextField);
        
        next =new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Color.BITMASK,14));
        next.setBounds(350,650,100,30);       
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(800,850);
        setLocation(350,10);
        setVisible(true);
        
     }
    public static void main(String args[])
   {
    new SignupOne();
   }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String formo=""+random;
        String name= nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender =null;

        if(maleButton.isSelected())
        {
              gender ="Male";
        }
        else
        {
            gender="Female";
        }
    
    String email=emailTextField.getText();
    String marital=null;
       if(married.isSelected())
       {
        marital="Married";
       }
       else if(unmarried.isSelected())
       {
        marital="Unmarried";
       }
       else
       {
         marital="Other";
       }
       String address=addressTextField.getText();
       String city=cityTextField.getText();
       String state=stateTextField.getText();
       String pincode =pincodeTextField.getText();

       try{
        boolean flag=true;
        if(name.equals("") && flag)
        {
         JOptionPane.showMessageDialog(null,"Name Field is required");
        flag=false;}
         if(fname.equals("")  && flag)
         {
            JOptionPane.showMessageDialog(null,"Father Name Field required");
                flag=false;}
         if(dob.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Date of birth Field required");
                flag=false;}
         if(gender.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Gender Field required");
                flag=false;}
         if(email.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Email Field required");
                flag=false;}
         if(marital.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Marital Field required");
                flag=false;}
         if(address.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Address Field required");
                flag=false;}
         if(city.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"City Field required");
                flag=false;}
         if(state.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"State Field required");
                flag=false;}
         if(pincode.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Pin-Code Field required");
                flag=false;}
          
         if(flag)
         {
            conn c=new conn();
            String query="insert into signup values('"+formo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
            c.s.executeUpdate(query); 
            setVisible(false);
            new SignupTwo(formo).setVisible(true);
        }
         
       }
       catch(Exception exception)
       {
        System.out.println(exception);
       }
  }
}
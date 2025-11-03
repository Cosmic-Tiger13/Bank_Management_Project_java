package bank_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
    public class SignupTwo extends JFrame implements ActionListener
    {   
        JTextField incomeTextField,panTextField,aadharTextField;
        JButton next;
        JRadioButton senior, non_senior,exists,existn;
        JComboBox religion, categoryBox,eduBox,occuBox,incomeBox;
        // JDateChooser date;
        String formo;
       SignupTwo(String formo)
     {  this.formo=formo; 
        setLayout(null);
        setTitle("NEW APPLICATION FORM -PAGE 2");
        

        JLabel additionaldetails =new JLabel("Page 2:Additional Details");
        additionaldetails.setFont(new Font("Ariel",Font.BOLD,30));
        additionaldetails.setBounds(230,100,600,40);
        add(additionaldetails);

        JLabel religionnanme =new JLabel("Religion:");
        religionnanme.setFont(new Font("Ariel",Font.BOLD,20));
        religionnanme.setBounds(140,200,100,30);
        String valreligion[]={"","Hindu","Muslim","Sikh","Christian,Other"};
        religion=new JComboBox<>(valreligion);
        religion.setBounds(350,200,400,30);
        religion.setBackground(Color.white);
        add(religionnanme);
        add(religion);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Ariel",Font.BOLD,20));
        category.setBounds(140,240,200,30);
        String valcategory[]={"","General","OBC","SC","ST","Other"};
        categoryBox=new JComboBox<>(valcategory);
        categoryBox.setBounds(350,240,400,30);
        categoryBox.setBackground(Color.white);
        add(category);
        add(categoryBox);
 
        JLabel income=new JLabel("Annual Income:");
        income.setFont(new Font("Ariel",Font.BOLD,20));
        income.setBounds(140,280,200,30);
        String incomelist[]={"","Nil","less than 2,50,000","2,50,00-8,00,000","8,00,000-15,00,000","above 15,00,000"};
        incomeBox=new JComboBox<>(incomelist);
        incomeBox.setBackground(Color.white);
        incomeBox.setBounds(350,280,400,30);
        add(income);
        add(incomeBox);
        
        JLabel education =new JLabel("Educational");
        education.setFont(new Font("Ariel",Font.BOLD,20));
        education.setBounds(140,320,200,30);
        add(education);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Ariel",Font.BOLD,20));
        qualification.setBounds(140,340,200,30);
        String eduqual[]={"","Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        eduBox =new JComboBox<>(eduqual);
        eduBox.setBackground(Color.white);
        eduBox.setBounds(350,330,400,30);
        add(qualification);
        add(eduBox);

        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Ariel",Font.BOLD,20));
        occupation.setBounds(140,380,200,30);
        String occupationroles[]={"","Government-Service","Private","Student","Self-Employed","Business","Retired"};
        occuBox=new JComboBox<>(occupationroles);
        occuBox.setBounds(350,380,400,30);
        add(occupation);
        add(occuBox);

        JLabel pan =new JLabel("PAN:");
        pan.setFont(new Font("Ariel",Font.BOLD,20));
        pan.setBounds(140,440,100,30);
        panTextField =new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(350,440,400,30);
        add(pan);
        add(panTextField);

        JLabel aadhar =new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Ariel",Font.BOLD,20));
        aadhar.setBounds(140,480,200,30);
        aadharTextField =new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(350,480,400,30);
        add(aadhar);
        add(aadharTextField);

        JLabel state =new JLabel("Senior Citizen:");
        state.setFont(new Font("Ariel",Font.BOLD,20));
        state.setBounds(140,520,200,30);
        ButtonGroup senior_group=new ButtonGroup();
        senior=new JRadioButton("Yes");
        senior.setBounds(350, 520,100,30);
        senior.setBackground(Color.white);
        add(senior);
        senior_group.add(senior);
        non_senior =new JRadioButton("No");
        non_senior.setBounds(460, 520,100,30);
        non_senior.setBackground(Color.white);
        add(non_senior);
        senior_group.add(non_senior);
        add(state);

        JLabel existing =new JLabel("Existing Account:");
        existing.setFont(new Font("Ariel",Font.BOLD,20));
        existing.setBounds(140,560,200,30);
        ButtonGroup exist_group=new ButtonGroup();
        exists=new JRadioButton("Yes");
        existn=new JRadioButton("No");
        exists.setBounds(350,560,100,30);
        exists.setBackground(Color.white);
        existn.setBounds(460,560,100,30);
        existn.setBackground(Color.white);
        add(exists);
        exist_group.add(exists);
        add(existn);
        exist_group.add(existn);
        add(existing);
        
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
    new SignupTwo("");
   }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)categoryBox.getSelectedItem();
        String seducation=(String)eduBox.getSelectedItem();
        String sincome=(String)incomeBox.getSelectedItem();
        String soccupation=(String)occuBox.getSelectedItem();
        String citizen="";
   
        if(senior.isSelected())
        {
              citizen ="Yes";
        }
        else if(non_senior.isSelected())
        {
            citizen="No";
        }
    
     String existing_acc=null;
       if(exists.isSelected())
       {
        existing_acc="Yes";
       }
       else if(existn.isSelected())
       {
        existing_acc="No";
       }
       String span=panTextField.getText();
       String saadhar=aadharTextField.getText();

       try{
        boolean flag=true;
        if(sreligion.equals("") && flag)
        {
         JOptionPane.showMessageDialog(null,"Religion Field is required");
        flag=false;}
         if(scategory.equals("")  && flag)
         {
            JOptionPane.showMessageDialog(null,"Category Field required");
                flag=false;}
         if(sincome.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Income Field required");
                flag=false;}
         if(seducation.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Education Field required");
                flag=false;}
         if(soccupation.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Occupation Field required");
                flag=false;}
         if(span.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"PAN Field required");
                flag=false;}
         if(saadhar.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Aadhar Field required");
                flag=false;}
         if(citizen.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Citizen Field required");
                flag=false;}
         if(existing_acc.equals("") && flag)
         {
            JOptionPane.showMessageDialog(null,"Account Field required");
                flag=false;}
          
         if(flag)
         {
            conn c=new conn();
            String query="insert into signuptwo values('"+formo+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+citizen+"','"+existing_acc+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formo).setVisible(true);
            
        }
         
       }
       catch(Exception exception)
       {
        System.out.println(exception);
       }
  
}
    }
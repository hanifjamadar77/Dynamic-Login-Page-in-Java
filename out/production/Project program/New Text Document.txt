import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Sign_In_Page {
    JFrame f;
    Font  f1  = new Font(Font.SERIF, Font.PLAIN,  20);
    Font  f2  = new Font(Font.SERIF, Font.PLAIN,  22);
    Font  f3  = new Font(Font.SANS_SERIF,  Font.BOLD, 40);
    Font  f4  = new Font(Font.DIALOG,  Font.BOLD|Font.ITALIC, 15);
    Font  f5  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 20);


    JButton acc,reset , out;
    JLabel createacc ,username , email, pass, country;
    JTextField tuser, temail;
    JPasswordField jpass;
    JComboBox ccontry;
    JRadioButton agree;
    Sign_In_Page(){
        f = new JFrame("Sign In");
        f.setSize(2000,2000);
        f.setLayout(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.BLACK);

        // Panel Modification
        JPanel p1 = new JPanel();
        f.add(p1);
        p1.setLayout(null);
        p1.setBounds(500,120,800,600);


        // Components Modification
        out= new JButton("<<<");
        createacc = new JLabel("Create Account");
        username = new JLabel("Username");
        email= new JLabel("Your Email");
        pass = new JLabel("Create Password");
        country = new JLabel("Select Country");
        acc = new JButton("Create Account");
        reset= new JButton("Reset");

        tuser = new JTextField();
        temail = new JTextField();
        jpass = new JPasswordField();
        ccontry = new JComboBox();
        ccontry.addItem("India");
        ccontry.addItem("China");
        ccontry.addItem("United Kingdom");
        ccontry.addItem("pakistan");
        ccontry.addItem("France");

        agree= new JRadioButton("I Agree To The Terms & Conditions");

        //Adding Components
        p1.add(out);
        p1.add(createacc);
        p1.add(username);
        p1.add(pass);
        p1.add(email);
        p1.add(country);
        p1.add(tuser);
        p1.add(temail);
        p1.add(jpass);
        p1.add(ccontry);
        p1.add(createacc);
        p1.add(acc);
        p1.add(reset);

        p1.add(agree);

        // Arrenging the Components
        out.setBounds(20,20,40,40);
        createacc.setBounds(260,20,300,50);
        username.setBounds(50,80,100,50);
        tuser.setBounds(50,120,300,50);
        email.setBounds(400,80,300,50);
        temail.setBounds(400,120,300,50);
        pass.setBounds(50,200,300,50);
        jpass.setBounds(50,240,300,50);
        country.setBounds(400,200,300,50);
        ccontry.setBounds(400,240,140,50);

        agree.setBounds(260,340,300,50);
        acc.setBounds(280,400,250,60);
        reset.setBounds(280,480,250,60);

        // Fonts of Components
        out.setFont(f3);
        createacc.setFont(f3);
        username.setFont(f2);
        email.setFont(f2);
        pass.setFont(f2);
        country.setFont(f2);
        agree.setFont(f4);
        ccontry.setFont(f4);

        acc.setFont(f5);
        reset.setFont(f5);

        // Coloring to Components
        createacc.setForeground(Color.BLUE);
        acc.setBackground(Color.BLUE);
        acc.setForeground(Color.WHITE);

        reset.setBackground(Color.BLUE);
        reset.setForeground(Color.WHITE);
        tuser.setBackground(Color.LIGHT_GRAY.brighter());
        tuser.setForeground(Color.BLUE);
        tuser.setFont(f4);
        temail.setBackground(Color.LIGHT_GRAY.brighter());
        temail.setForeground(Color.BLUE);
        temail.setFont(f4);
        jpass.setBackground(Color.LIGHT_GRAY.brighter());
        jpass.setForeground(Color.BLUE);
        jpass.setFont(f4);


        acc.addActionListener(new AbstractAction() {

            String user = tuser.getText();
            String email = temail.getText();
            String pass = new String(jpass.getPassword());
            String contry = ccontry.getName();
            @Override
            public void actionPerformed(ActionEvent e) {
                String userPassword = new String(jpass.getPassword());
                if ((userPassword.length() >= 8)) {
                    JOptionPane.showMessageDialog(f, "Please Keep Your Password Less Then 8 Charactors", "Alert", JOptionPane.WARNING_MESSAGE);
                } else if (userPassword.equals("")) {
                    JOptionPane.showMessageDialog(f, "Please Fill the password field properly", "Alert", JOptionPane.WARNING_MESSAGE);

                } else if ((tuser.getText().equals(""))) {
                    JOptionPane.showMessageDialog(f, "Please fill the Username Field Correctly", "Alert", JOptionPane.WARNING_MESSAGE);
                } else if ((temail.getText().equals(""))) {
                    JOptionPane.showMessageDialog(f, "Please fill the Email Field Correctly", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                else {

                    JOptionPane.showMessageDialog(f, "Congratulations ! Your Account is Successfully Created 🥳🥳🥳");
                    f.setVisible(false);
                }

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myloginpage", "root", "");

                   String query = "INSERT INFO userlogin values('"+user +"','"+email +"','"+pass +"','"+ contry +"')";
                   Statement sta = con.createStatement();
                   int x = sta.executeUpdate(query);
                   if (x==0){
                       JOptionPane.showMessageDialog(f, "This is allready Exit.......");
                   } else {
                       JOptionPane.showMessageDialog(f, "Welcome, Your account is sucessfully created");
                   }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            });
         out.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == out) {
                        Login_Page lp = new Login_Page();
                        f.dispose();
                    }
                }
       });
    reset.addActionListener(new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource()==reset){
               tuser.setText("");
               temail.setText("");
               jpass.setText("");
               ccontry.addItem("");
           }
        }
    });


    }

}

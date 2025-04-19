import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Forget_password {
    JFrame f;
    Font f1  = new Font(Font.SERIF, Font.PLAIN,  20);
    Font  f2  = new Font(Font.SERIF, Font.PLAIN,  22);
    Font  f3  = new Font(Font.SANS_SERIF,  Font.BOLD, 40);
    Font  f4  = new Font(Font.DIALOG,  Font.BOLD|Font.ITALIC, 15);
    Font  f5  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 20);

    JTextField temail ;
    JLabel email;
    JButton submit , out;
    Forget_password(){
        f = new JFrame("Forget Password");
        f.setSize(2000,2000);
        f.setVisible(true);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.BLACK);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(700,300,400,350);
        f.add(p);

        email= new JLabel("Please enter your email id ");
        temail = new JTextField();
        submit = new JButton("Submit");
        out = new JButton("<<<");
        // Adding the Components to panel
        p.add(email);
        p.add(temail);
        p.add(submit);
        p.add(out);

        // Arrenging the components
        out.setBounds(20,10,40,40);
        email.setBounds(40,40,300,50);
        temail.setBounds(40,120,300,50);
        submit.setBounds(100,180,200,50);

        // Set Fonts to components
        email.setFont(f2);
        temail.setBackground(Color.LIGHT_GRAY.brighter());
        temail.setForeground(Color.BLUE);
        temail.setFont(f4);
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setFont(f5);
        out.setFont(f3);

        submit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( (temail.getText().equals(""))) {
                    JOptionPane.showMessageDialog(f,"Please fill the Email Field Correctly","Alert",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(f,"Your Email is now in Verifing process so after 1 minute the verification code are send to your Email.....");
                f.dispose();
                }
            }
        });

        out.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == out){
                    Login_Page lp = new Login_Page();
                    f.dispose();
                }
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Login_Page {
    Font f1 = new Font(Font.SERIF, Font.PLAIN, 20);
    Font f2 = new Font(Font.SERIF, Font.PLAIN, 20);
    Font f3 = new Font(Font.SANS_SERIF, Font.BOLD, 30);
    Font f4 = new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 15);
    Font f5 = new Font(Font.DIALOG_INPUT, Font.BOLD | Font.ITALIC, 20);

    JFrame f;
    JPasswordField jpass;
    JTextField tname;
    JButton create, forget, login;

    Login_Page() {
        f = new JFrame("Login Page");
        f.setSize(2000, 2000);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        URI uri1, uri2, uri3;
        try {
            uri1 = new URI("https://www.facebook.com/login/");
            uri2 = new URI("https://accounts.google.com/signin");
            uri3 = new URI("https://x.com");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.lightGray.brighter());

        JLabel llogin = new JLabel("Login");
        JLabel name = new JLabel("Username");
        JLabel pass = new JLabel("Password");
        forget = new JButton("Forget Password?");
        tname = new JTextField();
        jpass = new JPasswordField();
        login = new JButton("Login");
        JCheckBox check = new JCheckBox("Remember me");
        JLabel notragis = new JLabel("Not registered yet?");
        create = new JButton("Create an account");

        JLabel or = new JLabel("-----------------------OR------------------------");

        JButton facebook = new JButton("LOGIN WITH FACEBOOK");
        JButton google = new JButton("LOGIN WITH GOOGLE");
        JButton twitter = new JButton("LOGIN WITH TWITTER");

        // Add components
        p1.add(llogin);
        p1.add(name);
        p1.add(pass);
        p1.add(forget);
        p1.add(tname);
        p1.add(jpass);
        p1.add(check);
        p1.add(login);
        p1.add(notragis);
        p1.add(create);
        p1.add(or);
        p1.add(facebook);
        p1.add(google);
        p1.add(twitter);
        f.add(p1);

        // Set bounds
        p1.setBounds(500, 120, 425, 700);
        llogin.setBounds(50, 10, 100, 40);
        name.setBounds(50, 60, 100, 40);
        tname.setBounds(50, 100, 320, 40);
        pass.setBounds(50, 150, 100, 40);
        jpass.setBounds(50, 190, 320, 40);
        check.setBounds(50, 250, 140, 30);
        login.setBounds(50, 320, 320, 40);
        forget.setBounds(240, 365, 150, 20);
        notragis.setBounds(50, 400, 150, 40);
        create.setBounds(200, 400, 150, 40);
        or.setBounds(40, 440, 550, 30);
        facebook.setBounds(50, 480, 320, 40);
        google.setBounds(50, 530, 320, 40);
        twitter.setBounds(50, 580, 320, 40);

        // Fonts and colors
        llogin.setFont(f3);
        name.setFont(f2);
        tname.setFont(f4);
        pass.setFont(f2);
        jpass.setFont(f4);
        check.setFont(f4);
        forget.setFont(f4);
        forget.setBackground(Color.WHITE);
        forget.setBorder(null);
        login.setFont(f5);
        notragis.setFont(f4);
        create.setFont(f4);
        create.setBackground(Color.WHITE);
        create.setBorder(null);
        create.setForeground(Color.BLUE);
        or.setFont(f1);
        facebook.setFont(f4);
        google.setFont(f4);
        twitter.setFont(f4);

        llogin.setForeground(Color.BLUE);
        forget.setForeground(Color.BLUE);
        create.setForeground(Color.BLUE);
        check.setBackground(Color.lightGray.brighter());
        login.setBackground(Color.blue.brighter());
        login.setForeground(Color.WHITE);
        tname.setBackground(Color.LIGHT_GRAY);
        jpass.setBackground(Color.LIGHT_GRAY);
        jpass.setForeground(Color.BLUE);
        tname.setBorder(null);
        tname.setForeground(Color.BLUE);
        jpass.setBorder(null);
        or.setForeground(Color.LIGHT_GRAY);
        facebook.setBackground(Color.blue.brighter());
        google.setBackground(Color.blue.brighter());
        twitter.setBackground(Color.blue.brighter());
        facebook.setForeground(Color.white);
        google.setForeground(Color.white);
        twitter.setForeground(Color.white);
        f.getContentPane().setBackground(Color.BLACK);

        // LOGIN BUTTON ACTION
        login.addActionListener(e -> {
            String username = tname.getText().trim();
            String password = new String(jpass.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(f, "Username and Password cannot be empty", "Alert", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/myloginpage", "root", "");

                String query = "SELECT * FROM userlogin WHERE username=? AND password=?";
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, username);
                st.setString(2, password);

                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(f, "Login Successful 🎉");
                    f.dispose();
                    // TODO: redirect to dashboard
                } else {
                    JOptionPane.showMessageDialog(f, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }

                rs.close();
                st.close();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(f, "Error: " + ex.getMessage());
            }
        });

        // CREATE ACCOUNT BUTTON
        create.addActionListener(e -> {
            Sign_In_Page sp = new Sign_In_Page(); // Your sign-in class
            f.dispose();
        });

        // FORGET PASSWORD BUTTON
        forget.addActionListener(e -> {
            Forget_password fp = new Forget_password(); // Your forget-password class
            f.dispose();
        });

        // SOCIAL LOGINS
        facebook.addActionListener(e -> openLink(uri1));
        google.addActionListener(e -> openLink(uri2));
        twitter.addActionListener(e -> openLink(uri3));
    }

    private void openLink(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login_Page();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennisDesktop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author vyphan
 */
public class Login extends JFrame implements ActionListener{
    JLabel usernameLabel,passwordLabel;
    JTextField usernameInput;
    JPasswordField passwordInput;
    JButton login,cancel;
    
    Login(){
        super("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        String loginPosterLocation = "Images/defaultpic.png";
        String loginImageLocation = "Images/login.png";
        String cancelImageLocation = "Images/Cancel.png";
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource(loginPosterLocation));
        JLabel loginPoster = new JLabel(image);
        
        
        login = new JButton("Login",new ImageIcon(ClassLoader.getSystemResource(loginImageLocation)));
        cancel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource(cancelImageLocation)));
        
        login.addActionListener(this);
        cancel.addActionListener(this);
        
        JPanel p1,p2;
        p1 = new JPanel();
        p2=new JPanel();
        
        usernameLabel = new JLabel("User Name   ");
        passwordLabel = new JLabel("Password     ");
        
        usernameInput = new JTextField(10);
        passwordInput = new JPasswordField(10);
        
        add(loginPoster,BorderLayout.WEST);
        p1.add(usernameLabel); 
        p1.add(usernameInput);
        p1.add(passwordLabel);
        p1.add(passwordInput);
        
        p2.add(login);
        p2.add(cancel);
        //p4.getRootPane().setDefaultButton(login);
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
         
        setSize(400,250);
        //setLocation(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()== login){
                Conn connect = new Conn();

                String username = usernameInput.getText();
                String password = passwordInput.getText();
                String query = "SELECT * FROM `connexion` WHERE login='"+username+"' AND password = '"+password+"'";

                ResultSet rs = connect.s.executeQuery(query);

                if(rs.next()){
                    new TennisDesktop();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
            }
            else{
                System.exit(0);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
//    public static void main(String[] args){
//        new Login();
//    }
}
package tennisDesktop;

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vyphan
 */
public class Opening {
     public static void main(String args[]){
        SFrame sf = new SFrame("Tennis Desktop App");
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sf.setVisible(true);
        int i=1,x=1;
        //sf.setLocation(650, 600);
        for(i =2; i<=600; i+=4,x+=1){
            //sf.setLocationRelativeTo(null);
            sf.setLocation((700-((i+x)/2) ),400-(i/2));
            
            sf.setSize(i+x,i);
            
            
            try{
                Thread.sleep(10);
            }catch(Exception e) { }
        }
    }
    
}

class SFrame extends JFrame implements Runnable{
    Thread threadForLoadingEffect;
    SFrame(String s){
        super(s);
        setLayout(new FlowLayout());
        
        //we get the location of the image
        String locationOfImage = "Images/bg.png";
        
        // we set the image as a imageicon
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource(locationOfImage));
        
        //Scaling the image to a desired height and width , returns scaled image
        Image image = background.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        
        //creating imageicon with the scaled image
        ImageIcon scaledBackground = new ImageIcon(image);
        
        JLabel backgroundLabel = new JLabel(scaledBackground);
        add(backgroundLabel);
        
        threadForLoadingEffect = new Thread(this);
        threadForLoadingEffect.start();
        
    }
    
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            //Login f1 = new Login();
            //new Conn();
            new Login();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
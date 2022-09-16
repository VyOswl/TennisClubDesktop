package tennisDesktop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
/**
 *
 * @author vyphan
 */
public class Conn {

    public Connection c;
    public Statement s;
    private String url = "jdbc:mysql://localhost/tennis_club";
    private String username = "";
    private String password = "";

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Conn() {
        try {
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La base de donné n'est pas connectée");
        }
    }
}
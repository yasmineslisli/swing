import models.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPage extends JDialog{
    private JTextField tfusername;
    private JPasswordField pfpassword;
    private JButton LOGINButton;
    private JPanel loginPanel;

    public LoginPage(JFrame parent){

        super(parent);
        setTitle("Login");
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = tfusername.getText();
                String password = String.valueOf(pfpassword.getPassword());

                user = getAuthenticatedUser(username, password);

                if(user!= null)
                {
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(LoginPage.this,
                                                    "Username or Password invalid",
                                                            "Try again",
                                                                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public Utilisateur user;
    private Utilisateur getAuthenticatedUser(String username, String password)
    {
        Utilisateur user =null;

        final String DB_URL = "jdbc:mysql://localhost:3306/scrap";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);

            Statement stmt =conn.createStatement();
            String sql ="SELECT * FROM Utilisateur WHERE username=? AND mdp=?";
            PreparedStatement preparedStatement =conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet =preparedStatement.executeQuery();

            if(resultSet.next())
            {
                    //public Utilisateur(String nom, String prenom, String genre, String username, String mdp, String profession, String email) {

                user=new Utilisateur();
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));
                user.setGenre(resultSet.getString("genre"));
                user.setUsername(resultSet.getString("username"));
                user.setMdp(resultSet.getString("mdp"));

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }
}

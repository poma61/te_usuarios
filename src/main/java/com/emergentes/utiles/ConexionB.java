package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ConexionB {
    static public String driver = "com.mysql.cj.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_anuncios";
    static public String usuario = "root";
    static public String contrasena = "";
    
    protected Connection conn = null;

    public ConexionB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Error del driver"+ex.getMessage());
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Error al conectar con la base "
                + "de datos"+ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconn(){
        try {
            conn.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Error al cerrar la conexión: "
                  + ""+ex.getMessage());
        }
    }
}

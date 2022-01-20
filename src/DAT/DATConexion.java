/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DATConexion 
{
    //Conectarse a la BDD
    public static Connection con;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
            String driver = "com.mysql.jdbc.Driver";
            String user = "root";
            String password=  "root";
            String url = "jdbc:mysql://localhost:3306/recursos_educativos";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
    };
    
    public Connection AbrirConexion() throws ClassNotFoundException, SQLException
    {
        con = getConnection();
        System.out.println("FUNCIONA ESTA HUEVADA");
        return con;
    }
    
    public void CerrarConexion() throws SQLException
    {
       con.close();
    }
}

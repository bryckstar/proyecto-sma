/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PalaHZ
 */
public class DATRecursos_Aprendizaje {
    DATConexion conectar = new DATConexion();
    
    public ResultSet consultarRA(String mensaje) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM recurso WHERE titulo_recurso = '"
                +mensaje+ "':";
        PreparedStatement pst = conectar.AbrirConexion().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    };
}

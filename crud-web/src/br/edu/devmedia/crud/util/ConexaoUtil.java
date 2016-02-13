package br.edu.devmedia.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe de geração de novas conexões
 * 
 * @author George 
 */
public class ConexaoUtil {


	public static Connection getConexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_devmedia","root","root"); 
	}
}

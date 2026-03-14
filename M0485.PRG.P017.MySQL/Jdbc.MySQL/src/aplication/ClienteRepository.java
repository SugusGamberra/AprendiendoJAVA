package aplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteRepository {

	//todo lo q tiene persistencia en bbddd se le dice repository
	// user y pass para conectarnos a la bbdd
	private String url;
	private String user;
	private String password;
	
	//constructor
	public ClienteRepository(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	//metodo q nos devuelva un objeto q sea una conexion
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public void create(Cliente cliente) {
		String sql = "INSERT INTO `m0495_prg_p23`.`clientes` (`razon_social`,`nombre_comercial`,`limite_credito`) VALUES (?, ?, ?);";
		
		try {
			//obtenemos la conexion
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//valores a cumplimentar
			preparedStatement.setString(1, cliente.getRazonSocial());
			preparedStatement.setString(2, cliente.getNombreComercial());
			preparedStatement.setDouble(3, cliente.getLimiteCredito());
			//ejecuta la actualizacion
			preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ArrayList<Cliente> findAll() {
		
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		String sql = "SELECT * from Clientes;";
		
		try {
			//obtenemos la conexion y la sentencia a ejecutar
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			//obtener filas y columnas
			while(resultSet.next()) {
				
				Cliente cliente = new Cliente();
//				cliente.setId(resultSet.getInt("id"));
//				cliente.setRazonSocial(resultSet.getString("razon_social"));
//				cliente.setNombreComercial(resultSet.getString("nombre_comercial"));
//				cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));
				
				//tb se puede poner x el orden d las columnas
				cliente.setId(resultSet.getInt(1));
				cliente.setRazonSocial(resultSet.getString(2));
				cliente.setNombreComercial(resultSet.getString(3));
				cliente.setLimiteCredito(resultSet.getDouble(4));
				
				resultado.add(cliente);
			}
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return resultado;
	}
	
}

package aplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class ClienteRepository {
	
	// patron singleton
	private static ClienteRepository instance = null;
	
	public static ClienteRepository getInstance(String url, String user, String password) {
		if (instance == null) {
			instance = new ClienteRepository(url, user, password);
		}
		
		return instance;
	}

	//todo lo q tiene persistencia en bbddd se le dice repository
	// user y pass para conectarnos a la bbdd
	private String url;
	private String user;
	private String password;
	
	//constructor
	private ClienteRepository(String url, String user, String password) {
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
	
	public void update(Cliente cliente) {
		String sql = "UPDATE `m0495_prg_p23`.`clientes` SET razon_social = ?, nombre_comercial = ?, limite_credito = ? WHERE id = ?;";
		
		try {
			//obtenemos la conexion
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//valores a cumplimentar
			preparedStatement.setString(1, cliente.getRazonSocial());
			preparedStatement.setString(2, cliente.getNombreComercial());
			preparedStatement.setDouble(3, cliente.getLimiteCredito());
			preparedStatement.setInt(4, cliente.getId());
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
			//consulta sin parámetros
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			//obtener filas y columnas
			while(resultSet.next()) {
				
				Cliente cliente = this.getClienteByResultSet(resultSet);
				
				resultado.add(cliente);
			}
			
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return resultado;
	}
	
	// leer pasando un parametro
	public Optional<Cliente> findById(int id) {
		Optional<Cliente> resultado = Optional.empty();
		//Consulta
		String sql = "SELECT * from Clientes WHERE id =?";
		
		try {
			Connection connection = this.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//if (resultSet.first()) {
			if (resultSet.next()) {
				Cliente cliente = this.getClienteByResultSet(resultSet);
				resultado = Optional.of(cliente);
				
			}
			
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
				
		return resultado;
	}
	
	public ArrayList<Cliente> findByRazonSocial(String razonSocial) {
		ArrayList<Cliente> resultado = new ArrayList<Cliente>();
		//Consulta
		String sql = "SELECT * from Clientes WHERE razon_social like ?";
		
		try {
			Connection connection = this.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + razonSocial + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Cliente cliente = this.getClienteByResultSet(resultSet);
				resultado.add(cliente);
				
			}
			
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
				
		return resultado;
	}
	
	//en caso d no encontrar un cliente devuelve null
//	public Cliente findById2(int id) {
//		Cliente resultado = null;
//				
//		return resultado;
//	}
	
	private Cliente getClienteByResultSet(ResultSet resultSet) throws SQLException {
		Cliente cliente = new Cliente();
//		cliente.setId(resultSet.getInt("id"));
//		cliente.setRazonSocial(resultSet.getString("razon_social"));
//		cliente.setNombreComercial(resultSet.getString("nombre_comercial"));
//		cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));
		
		//tb se puede poner x el orden d las columnas
		cliente.setId(resultSet.getInt(1));
		cliente.setRazonSocial(resultSet.getString(2));
		cliente.setNombreComercial(resultSet.getString(3));
		cliente.setLimiteCredito(resultSet.getDouble(4));
		
		return cliente;
	}
	
}

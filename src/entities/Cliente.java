package entities;


import interfaces.DAO;
public class Cliente {
	private Integer idCliente;
	private String nombre;
	private String email;
	
	public Cliente() {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
	}
	
	
	
	public Cliente(Integer idCliente, String nombre, String email) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	@Override
	public String toString() {
		return "Cliente idCliente = " + idCliente + ", nombre = " + nombre + ", email = " + email + " \n";
	}






	


	
	

}

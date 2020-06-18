package co.com.coomeva.tiendaBk.dto;

import java.util.Collection;

public class TestClienteDTO {
	private long idcliente;
	private String apellidos;
	private String direccion;
	private String email;
	private Long identifiacion;
	private String nombres;
	private String telefono;
	private Collection<TestFacturaDTO> testFacturasByIdcliente;

	public long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdentifiacion() {
		return identifiacion;
	}

	public void setIdentifiacion(Long identifiacion) {
		this.identifiacion = identifiacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Collection<TestFacturaDTO> getTestFacturasByIdcliente() {
		return testFacturasByIdcliente;
	}

	public void setTestFacturasByIdcliente(Collection<TestFacturaDTO> testFacturasByIdcliente) {
		this.testFacturasByIdcliente = testFacturasByIdcliente;
	}
}

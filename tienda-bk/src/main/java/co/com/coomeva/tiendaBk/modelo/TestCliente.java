package co.com.coomeva.tiendaBk.modelo;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_CLIENTE", schema = "PUBLIC", catalog = "TIENDA")
public class TestCliente {
	private long idcliente;
	private String apellidos;
	private String direccion;
	private String email;
	private Long identifiacion;
	private String nombres;
	private String telefono;
	private Collection<TestFactura> testFacturasByIdcliente;

	@Id
	@Column(name = "IDCLIENTE", nullable = false, precision = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", initialValue = 1)
	public long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}

	@Basic
	@Column(name = "APELLIDOS", nullable = false, length = 100)
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Basic
	@Column(name = "DIRECCION", nullable = false, length = 300)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Basic
	@Column(name = "EMAIL", nullable = true, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "IDENTIFIACION", nullable = false, precision = 0)
	public Long getIdentifiacion() {
		return identifiacion;
	}

	public void setIdentifiacion(Long identifiacion) {
		this.identifiacion = identifiacion;
	}

	@Basic
	@Column(name = "NOMBRES", nullable = false, length = 100)
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Basic
	@Column(name = "TELEFONO", nullable = true, length = 50)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TestCliente that = (TestCliente) o;
		return idcliente == that.idcliente && Objects.equals(apellidos, that.apellidos)
				&& Objects.equals(direccion, that.direccion) && Objects.equals(email, that.email)
				&& Objects.equals(identifiacion, that.identifiacion) && Objects.equals(nombres, that.nombres)
				&& Objects.equals(telefono, that.telefono);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idcliente, apellidos, direccion, email, identifiacion, nombres, telefono);
	}

	@OneToMany(mappedBy = "testClienteByIdcliente")
	public Collection<TestFactura> getTestFacturasByIdcliente() {
		return testFacturasByIdcliente;
	}

	public void setTestFacturasByIdcliente(Collection<TestFactura> testFacturasByIdcliente) {
		this.testFacturasByIdcliente = testFacturasByIdcliente;
	}
}

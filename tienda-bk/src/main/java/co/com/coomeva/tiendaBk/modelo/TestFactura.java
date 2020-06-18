package co.com.coomeva.tiendaBk.modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_FACTURA", schema = "PUBLIC", catalog = "TIENDA")
public class TestFactura {
	private long idfactura;
	private Date fechaventa;
	private BigDecimal valortotal;
	private Integer idcliente;
	private TestCliente testClienteByIdcliente;
	private Collection<TestFacturaDetalle> testFacturaDetallesByIdfactura;

	@Id
	@Column(name = "IDFACTURA", nullable = false, precision = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", initialValue = 1)
	public long getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public void setIdfactura(long idfactura) {
		this.idfactura = idfactura;
	}

	@Basic
	@Column(name = "FECHAVENTA", nullable = false)
	public Date getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	@Basic
	@Column(name = "VALORTOTAL", nullable = false, precision = 3)
	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TestFactura that = (TestFactura) o;
		return idfactura == that.idfactura && Objects.equals(fechaventa, that.fechaventa)
				&& Objects.equals(valortotal, that.valortotal);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idfactura, fechaventa, valortotal);
	}

	@Basic
	@Column(name = "IDCLIENTE", nullable = true, precision = 0, insertable = false, updatable = false)
	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	@ManyToOne
	@JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE", nullable = true, insertable = false, updatable = false)
	public TestCliente getTestClienteByIdcliente() {
		return testClienteByIdcliente;
	}

	public void setTestClienteByIdcliente(TestCliente testClienteByIdcliente) {
		this.testClienteByIdcliente = testClienteByIdcliente;
	}

	@OneToMany(mappedBy = "testFacturaByIdfactura")
	public Collection<TestFacturaDetalle> getTestFacturaDetallesByIdfactura() {
		return testFacturaDetallesByIdfactura;
	}

	public void setTestFacturaDetallesByIdfactura(Collection<TestFacturaDetalle> testFacturaDetallesByIdfactura) {
		this.testFacturaDetallesByIdfactura = testFacturaDetallesByIdfactura;
	}
}

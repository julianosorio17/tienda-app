package co.com.coomeva.tiendaBk.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

public class TestFacturaDTO {
	private long idfactura;
	private Date fechaventa;
	private BigDecimal valortotal;
	private Integer idcliente;
	private TestClienteDTO testClienteByIdcliente;
	private Collection<TestFacturaDetalleDTO> testFacturaDetallesByIdfactura;

	public long getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(long idfactura) {
		this.idfactura = idfactura;
	}

	public Date getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public TestClienteDTO getTestClienteByIdcliente() {
		return testClienteByIdcliente;
	}

	public void setTestClienteByIdcliente(TestClienteDTO testClienteByIdcliente) {
		this.testClienteByIdcliente = testClienteByIdcliente;
	}

	public Collection<TestFacturaDetalleDTO> getTestFacturaDetallesByIdfactura() {
		return testFacturaDetallesByIdfactura;
	}

	public void setTestFacturaDetallesByIdfactura(Collection<TestFacturaDetalleDTO> testFacturaDetallesByIdfactura) {
		this.testFacturaDetallesByIdfactura = testFacturaDetallesByIdfactura;
	}
}

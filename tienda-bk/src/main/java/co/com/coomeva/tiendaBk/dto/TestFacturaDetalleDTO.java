package co.com.coomeva.tiendaBk.dto;

import java.math.BigDecimal;

public class TestFacturaDetalleDTO {
	private long idfacturadetalle;
	private Long cantidad;
	private BigDecimal valortotal;
	private BigDecimal valorunidad;
	private int idfactura;
	private int idproducto;
	private TestFacturaDTO testFacturaByIdfactura;
	private TestProductoDTO testProductoByIdproducto;

	public long getIdfacturadetalle() {
		return idfacturadetalle;
	}

	public void setIdfacturadetalle(long idfacturadetalle) {
		this.idfacturadetalle = idfacturadetalle;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorunidad() {
		return valorunidad;
	}

	public void setValorunidad(BigDecimal valorunidad) {
		this.valorunidad = valorunidad;
	}

	public int getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public TestFacturaDTO getTestFacturaByIdfactura() {
		return testFacturaByIdfactura;
	}

	public void setTestFacturaByIdfactura(TestFacturaDTO testFacturaByIdfactura) {
		this.testFacturaByIdfactura = testFacturaByIdfactura;
	}

	public TestProductoDTO getTestProductoByIdproducto() {
		return testProductoByIdproducto;
	}

	public void setTestProductoByIdproducto(TestProductoDTO testProductoByIdproducto) {
		this.testProductoByIdproducto = testProductoByIdproducto;
	}
}

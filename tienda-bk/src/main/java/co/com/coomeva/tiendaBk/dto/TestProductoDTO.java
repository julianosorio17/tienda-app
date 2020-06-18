package co.com.coomeva.tiendaBk.dto;

import java.math.BigDecimal;
import java.util.Collection;

public class TestProductoDTO {
	private long idproducto;
	private String codigo;
	private String nombre;
	private Long stock;
	private BigDecimal valorunidad;
	private Collection<TestFacturaDetalleDTO> testFacturaDetallesByIdproducto;

	public long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(long idproducto) {
		this.idproducto = idproducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public BigDecimal getValorunidad() {
		return valorunidad;
	}

	public void setValorunidad(BigDecimal valorunidad) {
		this.valorunidad = valorunidad;
	}

	public Collection<TestFacturaDetalleDTO> getTestFacturaDetallesByIdproducto() {
		return testFacturaDetallesByIdproducto;
	}

	public void setTestFacturaDetallesByIdproducto(Collection<TestFacturaDetalleDTO> testFacturaDetallesByIdproducto) {
		this.testFacturaDetallesByIdproducto = testFacturaDetallesByIdproducto;
	}
}

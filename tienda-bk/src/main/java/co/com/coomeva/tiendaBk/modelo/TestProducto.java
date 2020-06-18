package co.com.coomeva.tiendaBk.modelo;

import java.math.BigDecimal;
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
@Table(name = "TEST_PRODUCTO", schema = "PUBLIC", catalog = "TIENDA")
public class TestProducto {
	private long idproducto;
	private String codigo;
	private String nombre;
	private Long stock;
	private BigDecimal valorunidad;
	private Collection<TestFacturaDetalle> testFacturaDetallesByIdproducto;

	@Id
	@Column(name = "IDPRODUCTO", nullable = false, precision = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", initialValue = 1)
	public long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(long idproducto) {
		this.idproducto = idproducto;
	}

	@Basic
	@Column(name = "CODIGO", nullable = false, length = 30)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Basic
	@Column(name = "NOMBRE", nullable = false, length = 100)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic
	@Column(name = "STOCK", nullable = false)
	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Basic
	@Column(name = "VALORUNIDAD", nullable = false, precision = 3)
	public BigDecimal getValorunidad() {
		return valorunidad;
	}

	public void setValorunidad(BigDecimal valorunidad) {
		this.valorunidad = valorunidad;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TestProducto that = (TestProducto) o;
		return idproducto == that.idproducto && Objects.equals(codigo, that.codigo)
				&& Objects.equals(nombre, that.nombre) && Objects.equals(stock, that.stock)
				&& Objects.equals(valorunidad, that.valorunidad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idproducto, codigo, nombre, stock, valorunidad);
	}

	@OneToMany(mappedBy = "testProductoByIdproducto")
	public Collection<TestFacturaDetalle> getTestFacturaDetallesByIdproducto() {
		return testFacturaDetallesByIdproducto;
	}

	public void setTestFacturaDetallesByIdproducto(Collection<TestFacturaDetalle> testFacturaDetallesByIdproducto) {
		this.testFacturaDetallesByIdproducto = testFacturaDetallesByIdproducto;
	}
}

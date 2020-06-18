package co.com.coomeva.tiendaBk.modelo;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_FACTURA_DETALLE", schema = "PUBLIC", catalog = "TIENDA")
public class TestFacturaDetalle {
    private long idfacturadetalle;
    private Long cantidad;
    private BigDecimal valortotal;
    private BigDecimal valorunidad;
    private int idfactura;
    private int idproducto;
    private TestFactura testFacturaByIdfactura;
    private TestProducto testProductoByIdproducto;

    @Id
    @Column(name = "IDFACTURADETALLE", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", initialValue = 1)
    public long getIdfacturadetalle() {
        return idfacturadetalle;
    }

    public void setIdfacturadetalle(long idfacturadetalle) {
        this.idfacturadetalle = idfacturadetalle;
    }

    @Basic
    @Column(name = "CANTIDAD", nullable = false)
    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "VALORTOTAL", nullable = false, precision = 3)
    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestFacturaDetalle that = (TestFacturaDetalle) o;
        return idfacturadetalle == that.idfacturadetalle &&
                Objects.equals(cantidad, that.cantidad) &&
                Objects.equals(valortotal, that.valortotal) &&
                Objects.equals(valorunidad, that.valorunidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfacturadetalle, cantidad, valortotal, valorunidad);
    }

    @Basic
    @Column(name = "IDFACTURA", nullable = false, precision = 0)
    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    @Basic
    @Column(name = "IDPRODUCTO", nullable = false, precision = 0)
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @ManyToOne
    @JoinColumn(name = "IDFACTURA", referencedColumnName = "IDFACTURA", nullable = true, insertable=false, updatable=false)
    public TestFactura getTestFacturaByIdfactura() {
        return testFacturaByIdfactura;
    }

    public void setTestFacturaByIdfactura(TestFactura testFacturaByIdfactura) {
        this.testFacturaByIdfactura = testFacturaByIdfactura;
    }

    @ManyToOne
    @JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO", nullable = false, insertable=false, updatable=false)
    public TestProducto getTestProductoByIdproducto() {
        return testProductoByIdproducto;
    }

    public void setTestProductoByIdproducto(TestProducto testProductoByIdproducto) {
        this.testProductoByIdproducto = testProductoByIdproducto;
    }
}

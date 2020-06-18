package co.com.coomeva.tiendaBk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.coomeva.tiendaBk.dto.TestDetalleFacturaDTO;
import co.com.coomeva.tiendaBk.modelo.TestFacturaDetalle;

@SuppressWarnings("unused")
@Repository
public interface TestFacturaDetalleRepository extends JpaRepository<TestFacturaDetalle, Long> {
	List<TestFacturaDetalle> findByidfactura(int idFactura);
}

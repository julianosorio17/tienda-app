package co.com.coomeva.tiendaBk.repository;

import java.math.BigDecimal;

import java.util.Objects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.coomeva.tiendaBk.modelo.TestFactura;

@SuppressWarnings("unused")
@Repository
public interface TestFacturaRepository extends JpaRepository<TestFactura, Long> {

}

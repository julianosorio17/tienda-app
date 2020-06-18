package co.com.coomeva.tiendaBk.repository;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.coomeva.tiendaBk.dto.TestClienteDTO;
import co.com.coomeva.tiendaBk.modelo.TestCliente;

@SuppressWarnings("unused")
@Repository
public interface TestClienteRepository extends JpaRepository<TestCliente, Long> {
	Optional<TestCliente> findByIdentifiacion(Long identifiacion);

}

package co.com.coomeva.tiendaBk.service;

import java.util.List;
import java.util.Optional;

import co.com.coomeva.tiendaBk.dto.TestClienteDTO;


public interface TestClienteService{
	TestClienteDTO save(TestClienteDTO clienteDTO);

	List<TestClienteDTO> findAll();

	void delete(Long id);

	Optional<TestClienteDTO> findOne(Long id);

	public Optional<TestClienteDTO> findByIdentificacion(Long identificacion);
}

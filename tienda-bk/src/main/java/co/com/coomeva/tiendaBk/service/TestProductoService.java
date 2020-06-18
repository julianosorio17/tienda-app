package co.com.coomeva.tiendaBk.service;

import java.util.List;
import java.util.Optional;

import co.com.coomeva.tiendaBk.dto.TestProductoDTO;

public interface TestProductoService {
	TestProductoDTO save(TestProductoDTO productoDTO);

	List<TestProductoDTO> findAll();

	void delete(Long id);

	Optional<TestProductoDTO> findOne(Long id);

}

package co.com.coomeva.tiendaBk.service;

import java.util.List;

import co.com.coomeva.tiendaBk.dto.TestFacturaAllDTO;
import co.com.coomeva.tiendaBk.dto.TestFacturaDTO;

public interface TestFacturaService {
	TestFacturaDTO save(TestFacturaDTO productoDTO);

	List<TestFacturaAllDTO> findAll();

	void delete(Long id);

//	Optional<TestFacturaDTO> findOne(Long id);

}

package co.com.coomeva.tiendaBk.service;

import java.util.List;

import co.com.coomeva.tiendaBk.dto.TestDetalleFacturaDTO;
import co.com.coomeva.tiendaBk.dto.TestFacturaDetalleDTO;

public interface TestFacturaDetalleService {
	TestFacturaDetalleDTO save(TestFacturaDetalleDTO productoDTO);

	List<TestFacturaDetalleDTO> findAll();

	void delete(Long id);

	public List<TestDetalleFacturaDTO> findOne(int id);

}

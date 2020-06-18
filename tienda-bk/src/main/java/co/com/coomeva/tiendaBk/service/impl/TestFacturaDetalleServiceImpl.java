package co.com.coomeva.tiendaBk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.coomeva.tiendaBk.dto.TestDetalleFacturaDTO;
import co.com.coomeva.tiendaBk.dto.TestFacturaDetalleDTO;
import co.com.coomeva.tiendaBk.modelo.TestFacturaDetalle;
import co.com.coomeva.tiendaBk.repository.TestFacturaDetalleRepository;
import co.com.coomeva.tiendaBk.service.TestFacturaDetalleService;

@Service
@Transactional
public class TestFacturaDetalleServiceImpl implements TestFacturaDetalleService {

	private final TestFacturaDetalleRepository testFacturaDetalleRepository;

	private final ModelMapper testFacturaDetalleMapper;

	public TestFacturaDetalleServiceImpl(TestFacturaDetalleRepository testFacturaDetalleRepository) {
		this.testFacturaDetalleMapper = new ModelMapper();
		this.testFacturaDetalleRepository = testFacturaDetalleRepository;
	}

	@Override
	public TestFacturaDetalleDTO save(TestFacturaDetalleDTO testFacturaDetalleDTO) {
		TestFacturaDetalle detalle = testFacturaDetalleMapper.map(testFacturaDetalleDTO, TestFacturaDetalle.class);
		detalle = testFacturaDetalleRepository.save(detalle);
		return testFacturaDetalleMapper.map(detalle, TestFacturaDetalleDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TestFacturaDetalleDTO> findAll() {
		return testFacturaDetalleRepository.findAll().stream()
				.map(detalle -> testFacturaDetalleMapper.map(detalle, TestFacturaDetalleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		testFacturaDetalleRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TestDetalleFacturaDTO> findOne(int id) {

		return testFacturaDetalleRepository.findByidfactura(id).stream()
				.map(detalle -> testFacturaDetalleMapper.map(detalle, TestDetalleFacturaDTO.class))
				.collect(Collectors.toList());
	}
}

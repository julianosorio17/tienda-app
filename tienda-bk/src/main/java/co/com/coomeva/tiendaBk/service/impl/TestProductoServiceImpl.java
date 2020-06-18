package co.com.coomeva.tiendaBk.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.coomeva.tiendaBk.dto.TestClienteDTO;
import co.com.coomeva.tiendaBk.dto.TestProductoDTO;
import co.com.coomeva.tiendaBk.modelo.TestProducto;
import co.com.coomeva.tiendaBk.repository.TestProductoRepository;
import co.com.coomeva.tiendaBk.service.TestProductoService;

@Service
@Transactional
public class TestProductoServiceImpl implements TestProductoService {

	private final TestProductoRepository testProductoRepository;

	private final ModelMapper productoMapper;

	public TestProductoServiceImpl(TestProductoRepository testProductoRepository) {
		this.productoMapper = new ModelMapper();
		this.testProductoRepository = testProductoRepository;
	}

	@Override
	public TestProductoDTO save(TestProductoDTO productoDTO) {
		TestProducto producto = productoMapper.map(productoDTO, TestProducto.class);
		producto = testProductoRepository.save(producto);
		return productoMapper.map(producto, TestProductoDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TestProductoDTO> findAll() {
		return testProductoRepository.findAll().stream()
				.map(producto -> productoMapper.map(producto, TestProductoDTO.class)).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		testProductoRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TestProductoDTO> findOne(Long id) {
		return testProductoRepository.findById(id).map(producto -> {
			return productoMapper.map(producto, TestProductoDTO.class);
		});
	}
	
}

package co.com.coomeva.tiendaBk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.coomeva.tiendaBk.dto.TestFacturaAllDTO;
import co.com.coomeva.tiendaBk.dto.TestFacturaDTO;
import co.com.coomeva.tiendaBk.modelo.TestFactura;
import co.com.coomeva.tiendaBk.modelo.TestFacturaDetalle;
import co.com.coomeva.tiendaBk.modelo.TestProducto;
import co.com.coomeva.tiendaBk.repository.TestFacturaDetalleRepository;
import co.com.coomeva.tiendaBk.repository.TestFacturaRepository;
import co.com.coomeva.tiendaBk.repository.TestProductoRepository;
import co.com.coomeva.tiendaBk.service.TestFacturaService;

@Service
@Transactional
public class TestFacturaServiceImpl implements TestFacturaService {

	private final TestFacturaRepository testFacturaRepository;

	private final TestFacturaDetalleRepository detalleRepository;

	private final TestProductoRepository productoRepository;

	private final ModelMapper mapper;

	public TestFacturaServiceImpl(TestFacturaRepository testFacturaRepository,
			TestFacturaDetalleRepository detalleRepository, TestProductoRepository productoRepository) {
		this.mapper = new ModelMapper();
		this.testFacturaRepository = testFacturaRepository;
		this.detalleRepository = detalleRepository;
		this.productoRepository = productoRepository;
	}

	@Override
	public TestFacturaDTO save(TestFacturaDTO testFacturaDetalleDTO) {
		TestFactura testFactura = mapper.map(testFacturaDetalleDTO, TestFactura.class);
		testFactura.setIdcliente(testFacturaDetalleDTO.getIdcliente());
		TestFactura testFacturaResponse = testFacturaRepository.save(testFactura);
		testFacturaDetalleDTO.getTestFacturaDetallesByIdfactura().forEach(detalle -> {
			System.out.println(detalle.getTestProductoByIdproducto().getNombre());
			detalle.setTestFacturaByIdfactura(mapper.map(testFacturaResponse, TestFacturaDTO.class));
			detalle.setIdfactura((int) testFacturaResponse.getIdfactura());
			detalleRepository.save(mapper.map(detalle, TestFacturaDetalle.class));

			TestProducto productoUpdate = productoRepository
					.getOne(detalle.getTestProductoByIdproducto().getIdproducto());
			Long stockActual = productoUpdate.getStock();
			productoUpdate.setStock(stockActual - 1);
			productoRepository.save(productoUpdate);
		});
		return mapper.map(testFacturaResponse, TestFacturaDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TestFacturaAllDTO> findAll() {
		List<TestFacturaAllDTO> list = testFacturaRepository.findAll().stream()
				.map(factura -> mapper.map(factura, TestFacturaAllDTO.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void delete(Long id) {
		testFacturaRepository.deleteById(id);
	}

}

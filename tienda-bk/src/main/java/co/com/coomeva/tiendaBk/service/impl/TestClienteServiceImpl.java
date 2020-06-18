package co.com.coomeva.tiendaBk.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.coomeva.tiendaBk.dto.TestClienteDTO;
import co.com.coomeva.tiendaBk.modelo.TestCliente;
import co.com.coomeva.tiendaBk.repository.TestClienteRepository;
import co.com.coomeva.tiendaBk.service.TestClienteService;

@Service
@Transactional
public class TestClienteServiceImpl implements TestClienteService {

	private final TestClienteRepository testClienteRepository;

	private final ModelMapper clienteMapper;

	public TestClienteServiceImpl(TestClienteRepository testClienteRepository) {
		this.clienteMapper = new ModelMapper();
		this.testClienteRepository = testClienteRepository;
	}

	@Override
	public TestClienteDTO save(TestClienteDTO clienteDTO) {
		TestCliente cliente = clienteMapper.map(clienteDTO, TestCliente.class);
		cliente = testClienteRepository.save(cliente);
		return clienteMapper.map(cliente, TestClienteDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TestClienteDTO> findAll() {
		return testClienteRepository.findAll().stream().map(cliente -> clienteMapper.map(cliente, TestClienteDTO.class))
				.collect(Collectors.toList());

	}

	@Override
	public void delete(Long id) {
		testClienteRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TestClienteDTO> findOne(Long id) {
		return testClienteRepository.findById(id).map(cliente -> {
			return clienteMapper.map(cliente, TestClienteDTO.class);
		});
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TestClienteDTO> findByIdentificacion(Long identificacion) {
		return testClienteRepository.findByIdentifiacion(identificacion).map(cliente -> {
			return clienteMapper.map(cliente, TestClienteDTO.class);
		});
	}
}

package co.com.coomeva.tiendaBk.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.coomeva.tiendaBk.dto.TestClienteDTO;
import co.com.coomeva.tiendaBk.service.TestClienteService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestClienteResource {

	private final TestClienteService testClienteService;

	public TestClienteResource(TestClienteService testClienteService) {
		this.testClienteService = testClienteService;
	}

	@PostMapping("/clientes")
	public TestClienteDTO createClientes(@Valid @RequestBody TestClienteDTO clientesDTO) throws Exception {
		TestClienteDTO result = testClienteService.save(clientesDTO);
		return result;
	}

	@PutMapping("/clientes")
	public TestClienteDTO updateClientes(@Valid @RequestBody TestClienteDTO clientesDTO) throws Exception {
		if (clientesDTO.getIdcliente() == 0) {
			throw new Exception();
		}
		TestClienteDTO result = testClienteService.save(clientesDTO);
		return result;
	}

	@GetMapping("/clientes")
	public List<TestClienteDTO> getAllClientes() {
		return testClienteService.findAll();
	}

	@DeleteMapping("/clientes/{id}")
	public void deleteClientes(@PathVariable Long id) {
		testClienteService.delete(id);
	}

	@GetMapping("/clientes/{id}")
	public TestClienteDTO getCliente(@PathVariable Long id) {
		Optional<TestClienteDTO> clienteDTO = testClienteService.findOne(id);
		return clienteDTO.isPresent() ? clienteDTO.get() : null;
	}

	@GetMapping("/clientes/identificacion/{identificacion}")
	public TestClienteDTO getClienteByIdentificacion(@PathVariable Long identificacion) {
		Optional<TestClienteDTO> clienteDTO = testClienteService.findByIdentificacion(identificacion);
		return clienteDTO.isPresent() ? clienteDTO.get() : null;
	}
}

package co.com.coomeva.tiendaBk.rest;

import java.util.List;

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

import co.com.coomeva.tiendaBk.dto.TestFacturaDetalleDTO;
import co.com.coomeva.tiendaBk.service.TestFacturaDetalleService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestFacturaDetalleResource {

	private final TestFacturaDetalleService testFacturaDetalleService;

	public TestFacturaDetalleResource(TestFacturaDetalleService testFacturaDetalleService) {
		this.testFacturaDetalleService = testFacturaDetalleService;
	}

	@PostMapping("/testFacturaDetalle")
	public TestFacturaDetalleDTO createFacturaDetalles(@Valid @RequestBody TestFacturaDetalleDTO testFacturaDetalleDTO)
			throws Exception {
		if (testFacturaDetalleDTO.getIdfacturadetalle() != 0) {
			throw new Exception();
		}
		TestFacturaDetalleDTO result = testFacturaDetalleService.save(testFacturaDetalleDTO);
		return result;
	}

	@PutMapping("/testFacturaDetalle")
	public TestFacturaDetalleDTO updateFacturaDetalles(@Valid @RequestBody TestFacturaDetalleDTO tesFacturaDetalleDTO)
			throws Exception {
		if (tesFacturaDetalleDTO.getIdfacturadetalle() == 0) {
			throw new Exception();
		}
		TestFacturaDetalleDTO result = testFacturaDetalleService.save(tesFacturaDetalleDTO);
		return result;
	}

	@GetMapping("/testFacturaDetalle")
	public List<TestFacturaDetalleDTO> getAllFacturaDetalles() {
		return testFacturaDetalleService.findAll();
	}

	@DeleteMapping("/testFacturaDetalle/{id}")
	public void deleteFacturaDetalles(@PathVariable Long id) {
		testFacturaDetalleService.delete(id);
	}

//	@GetMapping("/testFacturaDetalle/{id}")
//	public TestFacturaDetalleDTO getCliente(@PathVariable Long id) {
//		Optional<TestFacturaDetalleDTO> clienteDTO = testFacturaDetalleService.findOne(id);
//		return clienteDTO.isPresent() ? clienteDTO.get() : null;
//	}
}

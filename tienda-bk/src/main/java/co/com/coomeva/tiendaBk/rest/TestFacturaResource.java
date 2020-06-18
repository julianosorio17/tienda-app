package co.com.coomeva.tiendaBk.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.coomeva.tiendaBk.dto.TestDetalleFacturaDTO;
import co.com.coomeva.tiendaBk.dto.TestFacturaAllDTO;
import co.com.coomeva.tiendaBk.dto.TestFacturaDTO;
import co.com.coomeva.tiendaBk.service.TestFacturaDetalleService;
import co.com.coomeva.tiendaBk.service.TestFacturaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestFacturaResource {

	private final TestFacturaService testFacturaService;

	private final TestFacturaDetalleService detalleService;

	public TestFacturaResource(TestFacturaService testFacturaService, TestFacturaDetalleService detalleService) {
		this.testFacturaService = testFacturaService;
		this.detalleService = detalleService;
	}

	@PostMapping("/testFactura")
	public TestFacturaDTO createFacturas(@Valid @RequestBody TestFacturaDTO testFacturaDTO) throws Exception {
		if (testFacturaDTO.getIdfactura() != 0) {
			throw new Exception();
		}
		TestFacturaDTO result = testFacturaService.save(testFacturaDTO);
		return result;
	}

	@PutMapping("/testFactura")
	public TestFacturaDTO updateFacturas(@Valid @RequestBody TestFacturaDTO testFacturaDTO) throws Exception {
		if (testFacturaDTO.getIdfactura() == 0) {
			throw new Exception();
		}
		TestFacturaDTO result = testFacturaService.save(testFacturaDTO);
		return result;
	}

	@GetMapping("/testFactura")
	public List<TestFacturaAllDTO> getAllFacturas() {
		return testFacturaService.findAll();
	}

	@GetMapping("/testFactura/detalle/{id}")
	public List<TestDetalleFacturaDTO> findDetalleFactura(@PathVariable int id) {
		List<TestDetalleFacturaDTO> detalleDTO = detalleService.findOne(id);
		return detalleDTO;
	}

}

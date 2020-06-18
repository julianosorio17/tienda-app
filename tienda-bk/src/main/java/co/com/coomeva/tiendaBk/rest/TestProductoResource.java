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

import co.com.coomeva.tiendaBk.dto.TestProductoDTO;
import co.com.coomeva.tiendaBk.service.TestFacturaDetalleService;
import co.com.coomeva.tiendaBk.service.TestProductoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestProductoResource {

	private final TestProductoService testProductoService;

	public TestProductoResource(TestProductoService testProductoService,
			TestFacturaDetalleService facturaDetalleService) {
		this.testProductoService = testProductoService;
	}

	@PostMapping("/testProducto")
	public TestProductoDTO createProductos(@Valid @RequestBody TestProductoDTO testProductoDTO) throws Exception {
		if (testProductoDTO.getIdproducto() != 0) {
			throw new Exception();
		}
		TestProductoDTO result = testProductoService.save(testProductoDTO);
		return result;
	}

	@PutMapping("/testProducto")
	public TestProductoDTO updateProductos(@Valid @RequestBody TestProductoDTO testProductoDTO) throws Exception {
		if (testProductoDTO.getIdproducto() == 0) {
			throw new Exception();
		}
		TestProductoDTO result = testProductoService.save(testProductoDTO);
		return result;
	}

	@GetMapping("/testProducto")
	public List<TestProductoDTO> getAllProductos() {
		return testProductoService.findAll();
	}

	@DeleteMapping("/testProducto/{id}")
	public void deleteProductos(@PathVariable Long id) {
		testProductoService.delete(id);
	}
}

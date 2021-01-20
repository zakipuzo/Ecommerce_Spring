package ma.pfa.springsecurity.presentation.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.pfa.springsecurity.aop.LogExecutionTime;
import ma.pfa.springsecurity.aop.Tracabilite;
import ma.pfa.springsecurity.domaine.ProductVo;
import ma.pfa.springsecurity.service.IProductService;

@RestController
public class ProductRestController {
	/**
	 * @Autowired permet d'injecter le bean de type IProdcutService (objet
	 *            représentant la couche métier). Ici, le Design Pattern qui est
	 *            appliqué est l'IOC (Inversion Of Control).
	 */
	@Autowired
	private IProductService service;

	/**
	 * Pour chercher tous les productlyés
	 */
	@GetMapping(value = "/rest/product", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@LogExecutionTime
	@Tracabilite
	public List<ProductVo> getAll() {
		return service.getProducts();
	}

	/**
	 * Pour chercher un productloyé par son id
	 */
	@GetMapping(value = "/rest/product/{id}")
	public ResponseEntity<Object>  getEmpById(@PathVariable(value = "id") Long productVoId) {
		ProductVo productVoFound = service.getProductById(productVoId);
		if (productVoFound == null)
			return new ResponseEntity<>("productloyee doen't exist", HttpStatus.OK);
		return new ResponseEntity<>(productVoFound, HttpStatus.OK);
	}

	/**
	 * Pour créer un nouveau productloyé
	 */
	@PostMapping(value = "/rest/product")
	@LogExecutionTime
	public ResponseEntity<Object> createEmp(@Valid @RequestBody ProductVo productVo) {
		service.save(productVo);
		return new ResponseEntity<>("productloyee is created successfully", HttpStatus.CREATED);
	}

	/**
	 * Pour modifier un produit par son id
	 */
	@PutMapping(value = "/rest/product/{id}")
	public ResponseEntity<Object> updateEmp(@PathVariable(name = "id") Long productVoId, @RequestBody ProductVo productVo) {
		ProductVo productVoFound = service.getProductById(productVoId);
		if (productVoFound == null)
			return new ResponseEntity<>("productloyee doen't exist", HttpStatus.OK);
		productVo.setId(productVoId);
		service.save(productVo);
		return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
	}

	/**
	 * Pour supprimer un productloyé par son id
	 */
	@DeleteMapping(value = "/rest/product/{id}")
	public ResponseEntity<Object> deleteEmp(@PathVariable(name = "id") Long productVoId) {
		ProductVo productVoFound = service.getProductById(productVoId);
		if (productVoFound == null)
			return new ResponseEntity<>("productloyee doen't exist", HttpStatus.OK);
		service.delete(productVoId);
		return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
	}
	
	/**
	 * Pour chercher tous les productlyés
	 */
	@GetMapping(value = "/rest/sort/{fieldName}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ProductVo> sortBy(@PathVariable String fieldName) {
		return service.sortBy(fieldName);
	}
	
	/**
	 * Afficher la liste des productloyés en utilisant la pagination
	 */
	@GetMapping("/rest/pagination/{pageid}/{size}")
	public List<ProductVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
		return service.findAll(pageid, size);
	}
}

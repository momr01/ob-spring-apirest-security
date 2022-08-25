package ar.com.momr.obspringej456.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.momr.obspringej456.entities.Laptop;
import ar.com.momr.obspringej456.repository.LaptopRepository;

@RestController
public class LaptopController {
	
	private LaptopRepository laptopRepository;
	
	public LaptopController(LaptopRepository laptopRepository) {
		this.laptopRepository = laptopRepository;
	}
	
	@GetMapping("/api/laptops")
	public List<Laptop> findAll(){
		return laptopRepository.findAll();
	}
	
	@GetMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
		Optional<Laptop> laptopOpt = laptopRepository.findById(id);
		
		if(laptopOpt.isPresent()) {
			return ResponseEntity.ok(laptopOpt.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/api/laptops")
	public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
		if(laptop.getId()!=null) {
			return ResponseEntity.badRequest().build();
		}
		Laptop result = laptopRepository.save(laptop);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/api/laptops")
	public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
		if(laptop.getId()==null) {
			return ResponseEntity.badRequest().build();
		}
		if(!laptopRepository.existsById(laptop.getId())) {
			return ResponseEntity.notFound().build();
		}
		
		Laptop result = laptopRepository.save(laptop);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> delete(@PathVariable Long id){
		if(!laptopRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		laptopRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/api/laptops")
	public ResponseEntity<Laptop> deleteAll(){
		laptopRepository.deleteAll();
		return ResponseEntity.noContent().build();
	}
	

}

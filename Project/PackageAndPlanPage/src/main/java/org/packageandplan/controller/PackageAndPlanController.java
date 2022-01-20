package org.packageandplan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.packageandplan.exception.ResourceNotFoundException;
import org.packageandplan.model.DabbaOrder;
import org.packageandplan.model.NonVegCatteringOrder;
import org.packageandplan.model.VegCatteringOrder;
import org.packageandplan.repository.DabbaOrderRepository;
import org.packageandplan.repository.NonVegCatteringOrderRepository;
import org.packageandplan.repository.VegCatteringOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class PackageAndPlanController {
	
	@Autowired
	private DabbaOrderRepository dabbaOrderRepository;

	//Save dabbaOrder information
	@PostMapping("packageplan")
	public DabbaOrder createDabbaOrder(@RequestBody DabbaOrder dabbaOrder) {
		return this.dabbaOrderRepository.save(dabbaOrder);
	}

	//get DabbaOrder information - Id, size & price
	@GetMapping("packageplan")
	public List<DabbaOrder> getDabbaOrder(){
		return this.dabbaOrderRepository.findAll();
	}

	//Update the DabbaOrder information
	@PutMapping("/packageplan/{id}")
	public ResponseEntity<DabbaOrder> getDabbaOrderById
	(@PathVariable(value = "id")Long dabbaOrderId, 
			@Validated @RequestBody DabbaOrder dabbaOrderDetails)
					throws ResourceNotFoundException{
		DabbaOrder dOrder = dabbaOrderRepository.findById(dabbaOrderId).orElseThrow(() -> 
		new ResourceNotFoundException("DabbaOrder not found for this id :: " + dabbaOrderId));

		dOrder.setType(dabbaOrderDetails.getType());
		dOrder.setPrice(dabbaOrderDetails.getPrice());
		return ResponseEntity.ok(this.dabbaOrderRepository.save(dOrder));	
	}	
	//delete the DabbaOrder information
	@DeleteMapping("packageplan/{id}")
	public Map<String, Boolean> deleteDabbaOrder(@PathVariable(value="id")Long dabbaOrderId)
			throws ResourceNotFoundException{
		DabbaOrder dOrder = dabbaOrderRepository.findById(dabbaOrderId)
				.orElseThrow(( ) -> new ResourceNotFoundException
						("Employee is not found by that id :: "+ dabbaOrderId));
		this.dabbaOrderRepository.delete(dOrder);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@Autowired
	private VegCatteringOrderRepository vegCatteringOrderRepository;	

	//Save VegCatteringOrder information
	@PostMapping("packageplan/veg")
	public VegCatteringOrder createVegCatteringOrder(@RequestBody VegCatteringOrder vegCatteringOrder) {
		return this.vegCatteringOrderRepository.save(vegCatteringOrder);
	}

	//get VegCatteringOrder information - Id, size & price
	@GetMapping("packageplan/veg")
	public List<VegCatteringOrder> getVegCatteringOrder(){
		return this.vegCatteringOrderRepository.findAll();
	}

	//Update the VegCatteringOrder information
	@PutMapping("/packageplan/veg/{id}")
	public ResponseEntity<VegCatteringOrder> getVegCatteringOrderById
	(@PathVariable(value = "id")Long vegCatteringOrderId, 
			@Validated @RequestBody VegCatteringOrder vegCatteringOrderDetails)
					throws ResourceNotFoundException{
		VegCatteringOrder dOrder = vegCatteringOrderRepository.findById(vegCatteringOrderId).orElseThrow(() -> 
		new ResourceNotFoundException("VegCatteringOrderId not found for this id :: " + vegCatteringOrderId));

		dOrder.setSize(vegCatteringOrderDetails.getSize());
		dOrder.setPrice(vegCatteringOrderDetails.getPrice());
		return ResponseEntity.ok(this.vegCatteringOrderRepository.save(dOrder));	
	}

	//delete the VegCatteringOrder information
	@DeleteMapping("packageplan/veg/{id}")
	public Map<String, Boolean> deleteVegCatteringOrderDetails(@PathVariable(value="id")Long vegCatteringOrderId)
			throws ResourceNotFoundException{
		VegCatteringOrder dOrder = vegCatteringOrderRepository.findById(vegCatteringOrderId)
				.orElseThrow(( ) -> new ResourceNotFoundException
						("VegCatteringOrder is not found by that id :: "+ vegCatteringOrderId));
		this.vegCatteringOrderRepository.delete(dOrder);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@Autowired
	private NonVegCatteringOrderRepository nonVegCatteringOrderRepository;	

	//Save NonVegCatteringOrder information
	@PostMapping("packageplan/nonveg")
	public NonVegCatteringOrder createNonVegCatteringOrder(@RequestBody NonVegCatteringOrder nonVegCatteringOrder) {
		return this.nonVegCatteringOrderRepository.save(nonVegCatteringOrder);
	}

	//get NonVegCatteringOrder information - Id, size & price
	@GetMapping("packageplan/nonveg")
	public List<NonVegCatteringOrder> getNonVegCatteringOrder(){
		return this.nonVegCatteringOrderRepository.findAll();
	}
	//Update the NonVegCatteringOrder information
	@PutMapping("/packageplan/nonveg/{id}")
	public ResponseEntity<NonVegCatteringOrder> getNonVegCatteringOrderById
	(@PathVariable(value = "id")Long nonVegCatteringOrderId, 
			@Validated @RequestBody NonVegCatteringOrder nonVegCatteringOrderDetails)
					throws ResourceNotFoundException{
		NonVegCatteringOrder dOrder = nonVegCatteringOrderRepository.findById(nonVegCatteringOrderId).orElseThrow(() -> 
		new ResourceNotFoundException("NonVegCatteringOrderId not found for this id :: " + nonVegCatteringOrderId));

		dOrder.setSize(nonVegCatteringOrderDetails.getSize());
		dOrder.setPrice(nonVegCatteringOrderDetails.getPrice());
		return ResponseEntity.ok(this.nonVegCatteringOrderRepository.save(dOrder));	
	}

	//delete the NonVegCatteringOrder information
	@DeleteMapping("packageplan/nonveg/{id}")
	public Map<String, Boolean> deleteNonVegCatteringOrderDetails(@PathVariable(value="id")Long nonVegCatteringOrderId)
			throws ResourceNotFoundException{
		NonVegCatteringOrder dOrder = nonVegCatteringOrderRepository.findById(nonVegCatteringOrderId)
				.orElseThrow(( ) -> new ResourceNotFoundException
						("NonVegCatteringOrder is not found by that id :: "+ nonVegCatteringOrderId));
		this.nonVegCatteringOrderRepository.delete(dOrder);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

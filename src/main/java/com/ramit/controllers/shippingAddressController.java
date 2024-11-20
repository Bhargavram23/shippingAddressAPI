package com.ramit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramit.AddressRepository;
import com.ramit.models.Address;
@RestController
public class shippingAddressController {
	@Autowired
	AddressRepository addressRepo;
	@PostMapping("/shipping")
	public Address upsertAddressByExample(@RequestBody Address address) {
		List<Address> allAddress = addressRepo.findAll(Example.of(address));
		Address refAddress = null;
		if(allAddress.isEmpty()) {
			refAddress = addressRepo.save(address);
		}
		else {
			refAddress = allAddress.get(0);
		}
		return addressRepo.findById(refAddress.getAddressId()).get();
	}
	@GetMapping("/msg")
	public String basicResponse() {
		return "sucess";
	}
}

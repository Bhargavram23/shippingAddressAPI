package com.ramit;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramit.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}

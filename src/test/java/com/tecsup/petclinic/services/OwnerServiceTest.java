package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
	private OwnerService ownerService;
	//Cristhian Marcelo
	@Test
	public void testCreateOwner() {


		String OWNER_NAME = "Juan Arellano";
		String OWNER_ADDRESS = "Av.Cascanueces";
		String OWNER_CITY = "Lima";


		Owner owner = new Owner(OWNER_NAME, OWNER_ADDRESS, OWNER_CITY);

		Owner ownerCreated = this.ownerService.create(owner);

		log.info("OWNER CREATED: " + ownerCreated.toString());

		assertNotNull(ownerCreated.getId());
		assertEquals(OWNER_NAME, ownerCreated.getName());
		assertEquals(OWNER_ADDRESS, ownerCreated.getAddress());
		assertEquals(OWNER_CITY, ownerCreated.getCity());
	}
}

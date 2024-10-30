package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
	private OwnerService ownerService;

	/**
	 * Test para actualizar un dueño.
	 */
	@Test
	public void testUpdateOwner() {
		int ID = 1;  // Asegúrate de que el ID exista en la base de datos
		String NEW_NAME = "Carlos";
		String NEW_ADDRESS = "123 New Street";
		String NEW_CITY = "New City";
		Owner owner = null;

		try {
			// Busca al dueño existente
			owner = ownerService.findById(ID);
			owner.setName(NEW_NAME);
			owner.setAddress(NEW_ADDRESS);
			owner.setCity(NEW_CITY);

			// Actualiza el dueño
			ownerService.update(owner);

			// Verifica el cambio
			Owner updatedOwner = ownerService.findById(ID);
			assertEquals(NEW_NAME, updatedOwner.getName());
			assertEquals(NEW_ADDRESS, updatedOwner.getAddress());
			assertEquals(NEW_CITY, updatedOwner.getCity());

			log.info("Updated owner: " + updatedOwner);
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test para eliminar un dueño.
	 */
	@Test
	public void testDeleteOwner() {
		int ID = 1;  // Asegúrate de que el ID exista en la base de datos para eliminar

		try {
			// Elimina al dueño
			ownerService.deleteById(ID);

			// Intenta buscar al dueño eliminado
			ownerService.findById(ID);
			fail("Expected an OwnerNotFoundException to be thrown");
		} catch (OwnerNotFoundException e) {
			log.info("Owner successfully deleted");
		}
	}
}

package com.tp2.main.modelTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.tp2.main.model.Persona;
import java.time.LocalDate;

public class PersonaTest {

    @Test
    public void testSetterGetter() {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setDni("12345678");
        persona.setTelefono("123456789");
        persona.setDireccion("Calle 123");
        persona.setFechaNacimiento(LocalDate.of(1990, 5, 15));

        assertEquals("Juan", persona.getNombre());
        assertEquals("Perez", persona.getApellido());
        assertEquals("12345678", persona.getDni());
        assertEquals("123456789", persona.getTelefono());
        assertEquals("Calle 123", persona.getDireccion());
        assertEquals(LocalDate.of(1990, 5, 15), persona.getFechaNacimiento());
    }
}

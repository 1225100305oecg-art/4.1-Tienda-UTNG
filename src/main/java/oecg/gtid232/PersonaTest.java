package oecg.gtid232;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    void validarGetterNombre() {
        Persona persona = new Persona(
                "Juan",
                20,
                "juan@gmail.com"
        );

        assertEquals("Juan", persona.getNombre());
    }

    @Test
    void validarToString() {
        Persona persona = new Persona(
                "Juan",
                20,
                "juan@gmail.com"
        );

        String resultado = persona.toString();

        assertTrue(resultado.contains("Juan"));
        assertTrue(resultado.contains("20"));
        assertTrue(resultado.contains("juan@gmail.com"));
    }
}

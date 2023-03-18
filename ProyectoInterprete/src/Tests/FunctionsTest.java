package Tests;

import Modelo.Functions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @Test
    void crearFuncion() {
        Functions f = new Functions();
        ArrayList<Object> a = new ArrayList<>();
        f.crearFuncion("Hola", a);
        assertEquals(true, f.funcionExiste("Hola"));
    }


    @Test
    void getExp() {
        Functions f = new Functions();
        ArrayList<Object> a = new ArrayList<>();
        f.crearFuncion("Hola", a);
        assertEquals(true, f.funcionExiste("Hola"));
    }


}
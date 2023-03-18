package Tests;

import Modelo.Defvar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefvarTest {

    @Test
    void defvar() {
        Defvar df = new Defvar();
        df.Defvar("Hola");
        assertEquals(true, df.existe("Hola"));
    }

    @Test
    void setQ() {
        Defvar df = new Defvar();
        df.Defvar("X");
        df.SetQ("X", "10", false);
        assertEquals("10", df.getVariable("X", false));
    }
}
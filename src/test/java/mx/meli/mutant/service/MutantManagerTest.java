package mx.meli.mutant.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutantManagerTest {

    MutantManager mutantManager = new MutantManager();

    @Test
    public void isMutant_horizontal() {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(mutantManager.isMutant(adn));
    }

    @Test
    public void isMutant_horizontal_notMath() {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAXG", "CFCCTA", "TCACTG"};
        assertFalse(mutantManager.isMutant(adn));
    }

    @Test
    public void isMutant_vertical() {
        String[] adn = {"ATGCGA", "AAGTGC", "ATATGT", "AGAAGG", "CCCXTA", "TCACTG"};
        assertTrue(mutantManager.isMutant(adn));
    }
}

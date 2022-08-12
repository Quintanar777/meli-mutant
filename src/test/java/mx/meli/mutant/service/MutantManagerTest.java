package mx.meli.mutant.service;

import mx.meli.mutant.exception.MutanManagerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutantManagerTest {

    MutantManager mutantManager = new MutantManager();

    @Test
    public void inMutant() throws MutanManagerException {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(mutantManager.isMutant(adn));
    }

    @Test
    public void isMutant_horizontal() throws MutanManagerException {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(mutantManager.isMutant(adn));
    }

    @Test
    public void isMutant_horizontal_notMath() throws MutanManagerException {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAXG", "CFCCTA", "TCACTG"};
        assertFalse(mutantManager.isMutant(adn));
    }

    @Test
    public void isMutant_vertical() throws MutanManagerException {
        String[] adn = {"ATGCGA", "AAGTGC", "ATATGT", "AGAAGG", "CCCXTA", "TCACTG"};
        assertTrue(mutantManager.isMutant(adn));
    }
}

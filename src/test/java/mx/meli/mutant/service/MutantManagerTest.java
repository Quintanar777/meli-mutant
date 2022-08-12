package mx.meli.mutant.service;

import mx.meli.mutant.exception.MutanManagerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MutantManagerTest {

    MutantManager mutantManager = new MutantManager();

    @Test
    public void inMutant() throws MutanManagerException {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(mutantManager.isMutant(adn));
    }

    @Test
    public void inMutant_inputError() throws MutanManagerException {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "AAA"};
        MutanManagerException mutanManagerException = assertThrows(MutanManagerException.class, () -> mutantManager.isMutant(adn));
        assertEquals("Input ADN invalid", mutanManagerException.getMessage());
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

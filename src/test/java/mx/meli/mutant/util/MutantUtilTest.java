package mx.meli.mutant.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MutantUtilTest {

    @Test
    public void adnLineIsMutant_AAAA() {
        assertTrue(MutantUtil.adnLineIsMutant("FSDAAAASDG"));
    }

    @Test
    public void adnLineIsMutant_TTTT() {
        assertTrue(MutantUtil.adnLineIsMutant("FSDTTTTSDG"));
    }

    @Test
    public void adnLineIsMutant_CCCC() {
        assertTrue(MutantUtil.adnLineIsMutant("FSDCCCCSDG"));
    }

    @Test
    public void adnLineIsMutant_GGGG() {
        assertTrue(MutantUtil.adnLineIsMutant("FSDGGGGSDG"));
    }

    @Test
    public void adnLineIsMutant_notMatch() {
        assertFalse(MutantUtil.adnLineIsMutant("FSDGXGGSDG"));
    }

    @Test
    public void getLineVertical() {
        String[] array = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        String lineZero = MutantUtil.getLineVertical(array, 0);
        assertEquals("ACTACT", lineZero);

        String lineOne = MutantUtil.getLineVertical(array, 1);
        assertEquals("TATGCC", lineOne);
    }

    @Test
    public void getLineVertical_columnNotExist() {
        String[] array = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCAC"};
        String lineZero = MutantUtil.getLineVertical(array, 5);
        assertEquals("ACTGA", lineZero);
    }

    @Test
    public void getArrayLinesObliqua() {
        String[] adn = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        List<String> arrayLinesObliqua = MutantUtil.getArrayLinesObliqua(adn);
        assertNotNull(arrayLinesObliqua);
        assertEquals(5, arrayLinesObliqua.size());
        //valida la linea diagonal
        assertTrue(arrayLinesObliqua.stream().anyMatch(s -> s.equals("AAAATG")));
        //valida las lineas arriba de la diagonal
        assertTrue(arrayLinesObliqua.stream().anyMatch(s -> s.equals("TGTGA")));
        assertTrue(arrayLinesObliqua.stream().anyMatch(s -> s.equals("GTGG")));
        //valida las lineas abajo de la diagonal
        assertTrue(arrayLinesObliqua.stream().anyMatch(s -> s.equals("CTACT")));
        assertTrue(arrayLinesObliqua.stream().anyMatch(s -> s.equals("TGCC")));
    }
}

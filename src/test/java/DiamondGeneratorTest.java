import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by monteillet on 07/12/2015.
 */
public class DiamondGeneratorTest {


    @Test
    public void testDiamondWithALetter() {
        String diamond = DiamondGenerator.diamond('A');
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("A").
                assertEndOfDiamond();

    }

    @Test
    public void testDiamondWithBLetter() {
        String diamond = DiamondGenerator.diamond('B');
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine(" A ").
                assertNextLine("B B").
                assertNextLine(" A ").
                assertEndOfDiamond();

    }

    @Test
    public void testDiamondWithCLetter() {
        String diamond = DiamondGenerator.diamond('C');
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("  A  ").
                assertNextLine(" B B ").
                assertNextLine("C   C").
                assertNextLine(" B B ").
                assertNextLine("  A  ").
                assertEndOfDiamond();

    }

    @Test
    public void testDiamondWithDLetter() {
        String diamond = DiamondGenerator.diamond('D');
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("   A   ").
                assertNextLine("  B B  ").
                assertNextLine(" C   C ").
                assertNextLine("D     D").
                assertNextLine(" C   C ").
                assertNextLine("  B B  ").
                assertNextLine("   A   ").
                assertEndOfDiamond();

    }

    @Test
    public void testDiamondWithELetter() {
        String diamond = DiamondGenerator.diamond('E');
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("    A    ").
                assertNextLine("   B B   ").
                assertNextLine("  C   C  ").
                assertNextLine(" D     D ").
                assertNextLine("E       E").
                assertNextLine(" D     D ").
                assertNextLine("  C   C  ").
                assertNextLine("   B B   ").
                assertNextLine("    A    ").
                assertEndOfDiamond();

    }


    private static class DiamondKataAssert {

        Queue<String> diamondLines = new LinkedList<String>();

        private DiamondKataAssert(Queue<String> diamondLines) {
            this.diamondLines = diamondLines;
        }

        public static DiamondKataAssert withDiamond(String diamond) {
            Queue<String> diamondLines = new LinkedList<String>();
            for (String split : diamond.split("\n")) {
                diamondLines.add(split);
            }
            return new DiamondKataAssert(diamondLines);
        }

        public DiamondKataAssert assertNextLine(String expectedLine) {
            String actualLine = diamondLines.remove();
            assertThat(actualLine).isEqualTo(expectedLine);
            return this;
        }

        public void assertEndOfDiamond() {
            assertThat(diamondLines).isEmpty();
        }

    }
}

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by monteillet on 07/12/2015.
 */
public class DiamondKataTest {


    @Test
    public void testDepth1() {
        String diamond = DiamondKata.diamondKata(1);
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("A").
                assertEndOfDiamond();

    }

    @Test
    public void testDepth2() {
        String diamond = DiamondKata.diamondKata(2);
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("-A-").
                assertNextLine("B-B").
                assertNextLine("-A-").
                assertEndOfDiamond();

    }

    @Test
    public void testDepth3() {
        String diamond = DiamondKata.diamondKata(3);
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("--A--").
                assertNextLine("-B-B-").
                assertNextLine("C---C").
                assertNextLine("-B-B-").
                assertNextLine("--A--").
                assertEndOfDiamond();

    }

    @Test
    public void testDepth4() {
        String diamond = DiamondKata.diamondKata(4);
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("---A---").
                assertNextLine("--B-B--").
                assertNextLine("-C---C-").
                assertNextLine("D-----D").
                assertNextLine("-C---C-").
                assertNextLine("--B-B--").
                assertNextLine("---A---").
                assertEndOfDiamond();

    }

    @Test
    public void testDepth5() {
        String diamond = DiamondKata.diamondKata(5);
        DiamondKataAssert.withDiamond(diamond).
                assertNextLine("----A----").
                assertNextLine("---B-B---").
                assertNextLine("--C---C--").
                assertNextLine("-D-----D-").
                assertNextLine("E-------E").
                assertNextLine("-D-----D-").
                assertNextLine("--C---C--").
                assertNextLine("---B-B---").
                assertNextLine("----A----").
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

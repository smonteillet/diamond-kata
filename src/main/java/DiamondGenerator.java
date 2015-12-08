/**
 * Created by monteillet on 07/12/2015.
 */
public class DiamondGenerator {

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final String PADDING_CHARACTER = " ";
    private static final String LINE_DELIMITER = "\n";

    /**
     * Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.
     * For example: print-diamond ‘C’ prints ('-' are replaced by whitespace in final output)
     * --A--
     * -B-B-
     * C---C
     * -B-B-
     * --A--
     *
     * @param widdestLetter
     * @return the corresponding diamond
     */
    public static String diamond(char widdestLetter) {
        int depth = getDiamondDepth(widdestLetter);
        int diamondLineLength = depth * 2 - 1;
        String diamond = buildDiamondLine(0, diamondLineLength, widdestLetter);
        int padding = 1;
        for (int i = depth - 1; 0 < i; i--) {
            String diamondLine = buildDiamondLine(padding, diamondLineLength, alphabet[i - 1]);
            diamond = diamondLine + diamond + diamondLine;
            padding++;
        }
        return diamond;
    }

    /**
     * For the widdest letter in the final diamond, return the diamond depth. For example, A => 1, B => 2, C => 3 ...
     *
     * @param widdestLetter
     * @return the diamond depth
     */
    private static int getDiamondDepth(char widdestLetter) {
        int depth = 1;
        for (char letter : alphabet) {
            if (letter == widdestLetter) {
                return depth;
            }
            depth++;
        }
        throw new IllegalArgumentException(widdestLetter + " is not supported");
    }

    /**
     * Build the needed diamond line depending on parameters
     *
     * @param externalPadding   for current diamond letter
     * @param diamondlineLength
     * @param diamondLetter
     * @return the diamond line
     */
    private static String buildDiamondLine(int externalPadding, int diamondlineLength, char diamondLetter) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < diamondlineLength; i++) {
            str.append(PADDING_CHARACTER);
        }
        str.setCharAt(externalPadding, diamondLetter);
        str.setCharAt(diamondlineLength - externalPadding - 1, diamondLetter);
        return str.append(LINE_DELIMITER).toString();
    }

}

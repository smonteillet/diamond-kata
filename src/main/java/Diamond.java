/**
 * Created by monteillet on 07/12/2015.
 */
public class Diamond {

    private static final char FIRST_LETTER = 'A';
    private static final String PADDING_CHARACTER = " ";
    private static final String LINE_DELIMITER = "\n";

    /**
     * Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.
     * For example: print-diamond ‘C’ prints ('-' are replaced by Diamond.PADDING_CHARACTER in final output)
     * --A--
     * -B-B-
     * C---C
     * -B-B-
     * --A--
     *
     * @param lastLetter
     * @return the corresponding diamond
     */
    public static String generate(char lastLetter) {
        int diamondLineLength = 2 * alphabetIndex(lastLetter) - 1;
        int externalPadding = 0;
        String diamond = buildDiamondLine(externalPadding++, lastLetter, diamondLineLength);
        while (lastLetter != FIRST_LETTER) {
            String diamondLine = buildDiamondLine(externalPadding++, lastLetter--, diamondLineLength);
            diamond = diamondLine + diamond + diamondLine;
        }
        return diamond;
    }

    /**
     * Build the needed diamond line depending on parameters
     *
     * @param externalPadding for current diamond letter
     * @param diamondLetter   the diamond letter for this line
     * @return the diamond line
     */
    private static String buildDiamondLine(int externalPadding, char diamondLetter, int diamondlineLength) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < diamondlineLength; i++) {
            str.append(PADDING_CHARACTER);
        }
        str.setCharAt(externalPadding, diamondLetter);
        str.setCharAt(diamondlineLength - externalPadding - 1, diamondLetter);
        return str.append(LINE_DELIMITER).toString();
    }

    /**
     * For a given character, returns its alphabet index. For exemple, C => 3
     * @param character
     * @return corresponding alphabet index
     */
    private static int alphabetIndex(char character) {
        return (character - 'A') + 1;
    }

}

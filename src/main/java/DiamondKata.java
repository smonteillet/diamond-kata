/**
 * Created by monteillet on 07/12/2015.
 */
public class DiamondKata {

    private static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final String PADDING_CHARACTER = "-";
    private static final String LINE_DELIMITER = "\n";

    public static String diamondKata(int depth) {
        int lineMaxLength = depth * 2 - 1;
        int padding = 0;
        String diamond = buildDiamondLine(padding++, lineMaxLength, alphabet[depth - 1]) + LINE_DELIMITER;
        for (int i = depth - 1; 0 < i; i--) {
            String diamondLine = buildDiamondLine(padding, lineMaxLength, alphabet[i-1]);
            diamond = diamondLine + LINE_DELIMITER + diamond + diamondLine + LINE_DELIMITER;
            padding++;
        }
        return diamond;
    }

    private static String buildDiamondLine(int externalPadding, int lineMaxLength, char diamondCharacter) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lineMaxLength; i++) {
            str.append(PADDING_CHARACTER);
        }
        str.setCharAt(externalPadding, diamondCharacter);
        str.setCharAt(lineMaxLength - externalPadding - 1, diamondCharacter);
        return str.toString();
    }

}

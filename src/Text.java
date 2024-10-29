import java.util.Scanner;


public class Text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        System.out.println(textModifier(inputText));
    }

    public static String textModifier(String inputText) {
        inputText = removeExtraSpaces(inputText);

        StringBuilder modifiedText = new StringBuilder();
        int sum = calculateSumAndModifyText(inputText, modifiedText);

        String resultString = modifiedText.toString().trim();
        if (sum > 0) {
            resultString += " " + sum;
        }
        return resultString;
    }

    private static String removeExtraSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        boolean space = false;
        for (char c : text.toCharArray()) {
            if (c != ' ' || !space) {
                sb.append(c);
            }
            space = (c == ' ');
        }
        return sb.toString();
    }

    private static int calculateSumAndModifyText(String text, StringBuilder sb) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == '-') {
                if (i > 0 && i < text.length() - 1) {
                    char left = text.charAt(i - 1);
                    char right = text.charAt(i + 1);

                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(right);
                    sb.append(left);
                    i++;
                }
            } else if (c == '+') {
                sb.append('!');
            } else if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            } else {
                sb.append(c);
            }
        }
        return sum;
    }
}

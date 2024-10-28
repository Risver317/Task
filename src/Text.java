import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        System.out.println(textModifier(inputText));
    }

    public static String textModifier(String text) {
        StringBuilder sb = new StringBuilder();
        boolean space = false;

        for (char c : text.toCharArray()) {
            if (c != ' ' || !space) {
                sb.append(c);
            }
            space = (c == ' ');
        }
        text = sb.toString();


        sb = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '-') {
                if (i > 0 && i < text.length() - 1) {
                    char left = text.charAt(i - 1);
                    char right = text.charAt(i + 1);
                    sb.setCharAt(sb.length() - 1, right);
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

        String finalTxt = sb.toString().trim();

            if (sum > 0) {
                finalTxt += " " + sum;
            }
            return finalTxt;
        }
    }

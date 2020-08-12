package checker;

import converter.Converter;

public class Checker {
    private String expression;

    public Checker(String expression) {
        this.expression = expression;
    }

    public void check() throws Exception {
        if (expression.matches("[0-9]+[*/+-][0-9]+") || expression.matches("[IVX]+[*/+-][IVX]+")) {
            expression = expression.replaceAll("[*/+-]", " ");
            String a = expression.substring(0, expression.indexOf(" ")).trim();
            String b = expression.substring(expression.indexOf(" ")).trim();
            checkNumbers(a, b);
        }
        else {
            throw new Exception("The expression doesn't matches a pattern!");
        }
    }

    private void checkNumbers(String num1, String num2) throws Exception {
        int a;
        int b;
        if (num1.matches("[IVX]+")) {
            a = Converter.toArabic(num1);
            b = Converter.toArabic(num2);
        }
        else {
            a = Integer.parseInt(num1);
            b = Integer.parseInt(num2);
        }

        if ((a < 1) || (a > 10) || (b < 1) || (b > 10))
            throw new Exception("The expression doesn't matches a pattern!");
    }
}
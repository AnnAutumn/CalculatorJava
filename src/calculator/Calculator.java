package calculator;
import converter.Converter;

public class Calculator extends Expression {
    private String input;
    private Expression expression;
    private String result;

    public Calculator(String input) {
        this.input = input;
    }

    public String calculate() {
        expression = new Expression();
        setAction();

        String[] array = input.split("[+-/*]");                        //разрезает выражение на две части

        if (isArabic(array[0])) {                                            //если числа арабские, считает и возвращает арабское число
            expression.setA(Integer.parseInt(array[0]));
            expression.setB(Integer.parseInt(array[1]));
            result = String.valueOf(expression.getResult());
            return result;
        }
        expression.setA(Converter.toArabic(array[0]));                           //если числа римские, возвращает римское число
        expression.setB(Converter.toArabic(array[1]));
        result = Converter.toRoman(expression.getResult());
        return result;
    }

    private boolean isArabic(String number) {                                     //возвращает true, если цифры арабские
        return number.matches("\\d+");
    }

    private void setAction() {
        if (input.contains("+"))
            expression.setAction('+');
        if (input.contains("-"))
            expression.setAction('-');
        if (input.contains("*"))
            expression.setAction('*');
        if (input.contains("/"))
            expression.setAction('/');
    }
}
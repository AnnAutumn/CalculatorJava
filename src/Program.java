import checker.Checker;
import calculator.Expression;
import calculator.Calculator;
import java.util.Scanner;

public class Program {
    private static Checker checker;
    private static Calculator calculator;
    private static String result;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine().replaceAll(" ", "");           //убираем сразу все пробелы
        checker = new Checker(input);
        checker.check();                                                            //проверяем, соответствует ли выражение требованиям

        calculator = new Calculator(input);
        result = calculator.calculate();

        System.out.printf(result);
    }
}

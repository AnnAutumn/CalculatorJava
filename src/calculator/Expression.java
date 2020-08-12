package calculator;

public class Expression {
    private int a;
    private int b;
    private char action;
    private int result;

    protected int getResult() {
        count();
        return result;
    }

    private void count(){
        switch (action) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> result = a / b;
        }
    }

    protected void setA(int a) {
        this.a = a;
    }

    protected void setB(int b) {
        this.b = b;
    }

    protected void setAction(char action) {
        this.action = action;
    }
}

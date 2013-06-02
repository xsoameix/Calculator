package inter;

import symbol.*;

public class Expr {
    public Token op;
    public Expr expr1, expr2;
    private int result;

    public Expr(Token op, Expr expr1, Expr expr2) {
        this.op = op;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    Expr gen() {
        return new Expr(op, expr1.reduce(), expr2.reduce());
    }

    Expr reduce() {
        return this;
    }

    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }

    void emit(String s) {
        System.out.println("\t" + s);
    }
}

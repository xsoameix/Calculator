package symbol;

import inter.*;

public class Num extends Token {
    private int value;

    public Num(int value) {
        super(Type.NUM);
        this.value = value;
    }

    public int cal(Expr a, Expr b) {
        return value;
    }

    public String toString() {
        return "" + value;
    }
}

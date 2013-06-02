package symbol;

import inter.*;

public class Token {
    private int type;

    public Token(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public int cal(Expr a, Expr b) {
        return -1;
    }

    public String toString() {
        return "" + type;
    }
}

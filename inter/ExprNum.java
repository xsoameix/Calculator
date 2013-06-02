package inter;

import symbol.*;

public class ExprNum extends Expr {
    public ExprNum(Token op) {
        super(op, null, null);

        setResult(op.cal(null, null));
    }

    public String toString() {
        return op.toString();
    }
}

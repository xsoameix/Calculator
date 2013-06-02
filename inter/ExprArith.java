package inter;

import symbol.*;

public class ExprArith extends Expr {

    public ExprArith(Token op, Expr expr1, Expr expr2) {
        super(op, expr1, expr2);

        setResult(op.cal(expr1, expr2));
    }

    Expr reduce() {
        Expr e = gen();
        Temp t = new Temp();
        emit(t.toString() + " = " + e.toString());
        return t;
    }
}

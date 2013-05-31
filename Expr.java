class Expr {
    Token op;
    Expr expr1, expr2;
    int result;

    Expr(Token op, Expr expr1, Expr expr2) {
        this.op = op;
        this.expr1 = expr1;
        this.expr2 = expr2;

        if(op.type == Type.ADD) {
            result = expr1.result + expr2.result;
        } else if(op.type == Type.SUB) {
            result = expr1.result - expr2.result;
        } else if(expr1 == null && expr2 == null) {
            Num n = (Num) op;
            result = n.value;
        } else {
            System.out.println("syntax error");
            System.exit(1);
        }
    }
}

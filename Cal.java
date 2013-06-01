// expr -> unary opE
// unary -> - num | num
// opE -> + num Es opE |
//        - num Es opE
// (opE : operator with expression)
//
// Es -> = Es | epsilon
// (Es : expressions)
class Cal {
    private Scanner scanner;
    private Token look;

    public static void main(String args[]) {
        Scanner s = new Scanner();
        Cal c = new Cal(s);
        c.expr();
    }

    Cal(Scanner s) {
        scanner = s;
    }

    void expr() {
        next();
        switch(look.type) {
        case Type.SUB:
        case Type.NUM:
            // expr -> [unary] opE
            Expr expr1 = unary();

            // expr -> unary [opE]
            Expr expr = opE(expr1);
            break;
        default:
            syntaxError();
        }
    }

    Expr opE(Expr expr1) {
        Expr expr = null;
        switch(look.type) {
        case Type.ADD:
        case Type.SUB:
            System.out.println("cal : " + expr1.result);

            // [+] num Es opE | [-] num Es opE
            Token op = look;
            next();

            // + [num] Es opE | - [num] Es opE
            Expr expr2 = num();

            // Build AST node.
            expr = new Expr(op, expr1, expr2);

            // + num [Es] opE | - num [Es] opE
            boolean cal = false;
            expr = Es(expr, cal);

            // + num Es [opE] | - num Es [opE]
            expr = opE(expr);
            break;
        case Type.EOF:
            break;
        default:
            syntaxError();
        }
        return expr;
    }

    Expr Es(Expr expr, boolean cal) {
        switch(look.type) {
        case Type.EQ:
            if(cal) {
                // Build AST node.
                expr = new Expr(expr.op, expr, expr.expr2);
            } else {
                cal = true;
            }

            System.out.println(expr.result);

            // Es -> [=] Es | epsilon
            next();

            // Es -> = [Es] | epsilon
            expr = Es(expr, cal);
            break;
        case Type.ADD:
        case Type.SUB:
        case Type.EOF:
            break;
        default:
            syntaxError();
        }
        return expr;
    }

    Expr unary() {
        Expr expr = null;
        switch(look.type) {
        case Type.SUB:
            // unary -> [-] num | num
            next();

            // unary -> - [num] | num
            expr = num();

            expr.result = -expr.result;
            break;
        case Type.NUM:
            // unary -> - num | [num]
            expr = num();
            break;
        default:
            syntaxError();
        }
        return expr;
    }

    Expr num() {
        Expr expr = null;
        switch(look.type) {
        case Type.NUM:
            expr = new Expr(look, null, null);
            next();
            break;
        default:
            syntaxError();
        }
        return expr;
    }

    void next() {
        look = scanner.scan();
    }

    void syntaxError() {
        System.out.println("Syntax error");
        System.exit(1);
    }
}

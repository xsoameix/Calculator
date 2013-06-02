package inter;

public class Stmt {
    private Expr expr;

    public Stmt(Expr e) {
        expr = e;
    }

    public void gen() {
        Expr e = expr.gen();
        Temp t = new Temp();
        emit(t.toString() + " = " + e.toString());
    }

    void emit(String s) {
        System.out.println("\t" + s);
    }
}

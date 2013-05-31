class Num extends Token {
    int value;

    Num(int value) {
        super(Type.NUM);
        this.value = value;
    }
}

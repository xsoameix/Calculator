class Scanner {
    char look = ' ';

    void read() {
        try {
            look = (char) System.in.read();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    Token scan() {
        while(look == ' ' || look == '\t' || look == '\n') {
            read();
        }

        if(Character.isDigit(look)) {
            int num = 0;
            do {
                num *= 10;
                num += look - '0';
                read();
            } while(Character.isDigit(look));
            return new Num(num);
        }

        look = (look == '+') ? Type.ADD : look;
        look = (look == '-') ? Type.SUB : look;
        look = (look == '=') ? Type.EQ : look;
        Token tok = new Token(look);
        read();
        return tok;
    }
}

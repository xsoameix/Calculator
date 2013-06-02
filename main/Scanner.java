package main;

import symbol.*;

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

        Token tok = null;
        switch(look) {
        case '+':
            tok = new Add();
            break;
        case '-':
            tok = new Sub();
            break;
        case '=':
            tok = new Token(Type.EQ);
            break;
        case '$':
            tok = new Token(Type.EOF);
            break;
        default:
            System.out.println("syntax error");
            System.exit(1);
        }
        read();
        return tok;
    }
}

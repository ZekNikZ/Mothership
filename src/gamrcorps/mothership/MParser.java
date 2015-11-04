package src.gamrcorps.mothership;

public class MParser {
    public String code;
    public MStack stack;

    public MParser(String code, MStack stack) {
        this.code = code;
        this.stack = stack;
    }

    public MParser(String code, MStack stack, boolean parse) {
        this.code = code;
        this.stack = stack;
        if (parse) parse();
    }

    public void parse() {
        parse(code);
    }

    public void parse(String toParse) {
        for (int index = 0; index < toParse.length(); ) {
            if (MNumber.isNumeric(toParse.charAt(index))) {
                int temp = 0;
                String num = "";
                try {
                    while (MNumber.isNumeric(toParse.charAt(index + temp)) || toParse.charAt(index + temp) == '.') {
                        num += String.valueOf(toParse.charAt(index + temp));
                        temp++;
                    }
                } catch (StringIndexOutOfBoundsException e) {}
                stack.push(new MNumber(num));
                index += temp;
            } else if (toParse.charAt(index) == ' ' || toParse.charAt(index) == '\n') {
                index++;
            } else {
                index++;
            }
        }
    }
}
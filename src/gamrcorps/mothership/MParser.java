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
            if (MCharacter.isNumeric(toParse.charAt(index))) {
                int temp = 0;
                String num = "";
                    while (index + temp < toParse.length() && (MCharacter.isNumeric(toParse.charAt(index + temp)) || toParse.charAt(index + temp) == '.')) {
                        num += String.valueOf(toParse.charAt(index + temp));
                        temp++;
                    }
                stack.push(new MNumber(num));
                index += temp;
            } else if (MCharacter.isWhitespace(toParse.charAt(index))) {
                index++;
            } else if (index+2<toParse.length() && MOps.isOperator(toParse.substring(index,index+2))) {
                MOps.runOperator(toParse.substring(index,index+2), stack);
                index+=2;
            } else if (MOps.isOperator(toParse.substring(index,index+1))) {
                MOps.runOperator(toParse.substring(index,index+1), stack);
                index++;
            } else {
                index++;
            }
        }
    }
}
package ch.zhaw.ads.solutions;

import ch.zhaw.ads.CommandExecutor;

public class BracketServer implements CommandExecutor {

    ListStack bracketStack;

    @Override
    public String execute(String s) throws Exception {
        return Boolean.toString(checkBrackets(s));
    }

    public boolean checkBrackets(String s) {
        bracketStack = new ListStack();

        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {
            if (isBracket(split[i])) {
                if (isOpenBracket(split[i]) || (split[i].equals("/") && (i != split.length-1) && split[i+1].equals("*"))) {
                    bracketStack.push(split[i]);
                } else if (isClosingBracket(split[i]) || (split[i].equals("/") && split[i-1].equals("*"))){
                    if (!bracketStack.isEmpty() && getMatchingBracket(bracketStack.peek().toString()).equals(split[i])) {
                        bracketStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return bracketStack.isEmpty();
    }

    private boolean isBracket(String c) {
        return c.equals("(") || c.equals("{") || c.equals("[") || c.equals("<") || c.equals("/")
                || c.equals(")") || c.equals("}") || c.equals("]") || c.equals(">");
    }

    private boolean isOpenBracket(String c) {
        return c.equals("(") || c.equals("{") || c.equals("[") || c.equals("<");
    }

    private boolean isClosingBracket(String c) {
        return c.equals(")") || c.equals("}") || c.equals("]") || c.equals(">");
    }

    private String getMatchingBracket(String s) {
        return switch (s) {
            case "{" -> "}";
            case "}" -> "{";
            case "(" -> ")";
            case ")" -> "(";
            case "[" -> "]";
            case "]" -> "[";
            case "<" -> ">";
            case ">" -> "<";
            case "/" -> "/";
            default -> throw new IllegalStateException("Invalid bracket: " + s);
        };
    }

}

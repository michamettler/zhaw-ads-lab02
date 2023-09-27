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

        for (String c : split) {
            if (isBracket(c)) {
                if (isOpenBracket(c)) {
                    bracketStack.push(c);
                } else {
                    if (getMatchingBracket(bracketStack.peek().toString()).equals(c)) {
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
        return c.equals("(") || c.equals("{") || c.equals("[") || c.equals(")") || c.equals("}") || c.equals("]");
    }

    private boolean isOpenBracket(String c) {
        return c.equals("(") || c.equals("{") || c.equals("[");
    }

    private String getMatchingBracket(String s) {
        return switch (s) {
            case "{" -> "}";
            case "}" -> "{";
            case "(" -> ")";
            case ")" -> "(";
            case "[" -> "]";
            case "]" -> "ü";
            default -> throw new IllegalStateException("Invalid bracket: " + s);
        };
    }

}

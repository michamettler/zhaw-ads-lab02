package ch.zhaw.ads.solutions;

import ch.zhaw.ads.CommandExecutor;

public class WellformedXmlServer implements CommandExecutor {

    ListStack xmlStack;

    @Override
    public String execute(String s) throws Exception {
        return Boolean.toString(checkWellformed(s));
    }

    public boolean checkWellformed(String s) {
        xmlStack = new ListStack();

        String[] tokens = s.split("<");

        for (var token : tokens) {
            if (!(token.contains("/>") || token.isEmpty())) {
                if (token.charAt(0) != '/') {
                    token = token.substring(0, token.length() - 1);

                    if (isTokenIndependent(token)) {
                        xmlStack.push(token);
                    } else {
                        xmlStack.push(token.split(" ")[0]);
                    }

                } else {
                    token = token.substring(1);
                    token = token.substring(0, token.length() - 1);
                    if (!xmlStack.isEmpty() &&  xmlStack.peek() != null && token.equals(xmlStack.peek().toString())) {
                        xmlStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return xmlStack.isEmpty();
    }

    private boolean isTokenIndependent(String token) {
        if (token == null) return false;
        return token.matches("<[a-zA-Z\\s]+/>");
    }


}

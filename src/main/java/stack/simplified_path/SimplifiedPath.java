package stack.simplified_path;

import java.util.Stack;

public class SimplifiedPath {

    public String simplify(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (!("".equals(s) || ".".equals(s))) {
                if ("..".equals(s)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        return buildPath(stack);
    }

    private String buildPath(Stack<String> stack) {
        StringBuilder simplifiedPath = new StringBuilder(stack.pop());
        while (!stack.isEmpty()) {
            simplifiedPath.insert(0, stack.pop() + "/");
        }
        return "/"+ simplifiedPath;
    }
}

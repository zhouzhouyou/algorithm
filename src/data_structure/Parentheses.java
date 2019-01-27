package data_structure;

public class Parentheses {
    private static boolean isParentheses(String string) {
        MyStack<Character> myStack = new MyStack<>();
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (character.equals(')')) {
                if (!myStack.pop().equals('(')) {
                    return false;
                }
            } else if (character.equals(']')) {
                if (!myStack.pop().equals('[')) {
                    return false;
                }
            } else if (character.equals('}')) {
                if (!myStack.pop().equals('{')) {
                    return false;
                }
            } else {
                myStack.push(character);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String trueString = "[]{[()]}()";
        String falseString = "{[}]";
        System.out.println(isParentheses(trueString));
        System.out.println(isParentheses(falseString));

        MyStack<Character> myStack = new MyStack<>();
        for (int i = 0; i < trueString.length(); i++) {
            myStack.push(trueString.charAt(i));
        }
        for (Character character: myStack) System.out.print(character);
        System.out.println();
        MyStack<Character> stack = MyStack.copy(myStack);
        for (Character character: stack) System.out.print(character);

    }

}

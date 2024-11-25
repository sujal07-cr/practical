import java.util.*;
public class Qtwo {
static int getPrecedence(char op){
switch(op){
    case '+':
    case '-':
        return 1;
    case '*':
    case '/':
        return 2;
    case '^':
        return 3;
}
return -1;
}
static String output(String infix){
    Stack<Character> stack = new Stack<>();
    StringBuilder postfix = new StringBuilder();
    for (int i = 0; i < infix.length(); i++) {
        char curr = infix.charAt(i);
        if (Character.isLetterOrDigit(curr)){
            postfix.append(curr);
        }
       else if (curr == '('){
            stack.push(curr);
        }
        else if (curr == ')'){
            while(!stack.isEmpty() && stack.peek() != '('){
                postfix.append(stack.pop());
            }
            stack.pop();
        }
        else {
            while(!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(curr) ){
                postfix.append(stack.pop());
            }
            stack.push(curr);
        }

    }
    while(!stack.isEmpty()){
        postfix.append(stack.pop());
    }
    return postfix.toString();
}

    public static void main(String[] args) {
        String infixExpression = "a-b*c-d/e+f";
        System.out.println(output(infixExpression));
    }
}

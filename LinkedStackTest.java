public class LinkedStackTest {

    public static void main(String[] args) {
    
        String infix = "a*b/(c-a)+d*e";
        String postFix = convertToPostFix(infix);

        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + postFix);

    }

    private static String convertToPostFix(String infix){
        LinkedStack<Character> operatorStack = new LinkedStack<Character>();

        String postfix = "";
        int length = infix.length();
        int counter = 0;
        char nextCharacter;
        char topOperator;

        while(counter < length){
            nextCharacter = infix.charAt(counter);
            boolean isLetter = Character.isLetter(nextCharacter);

            switch(nextCharacter){
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                // All operators should use the same code
                case '+':
                case '-':
                case '*':
                case '/':

                    while(!operatorStack.isEmpty() && precedenceCheck(nextCharacter) <= precedenceCheck(operatorStack.peek())){
                        postfix += operatorStack.peek();
                        operatorStack.pop();
                    }
                    
                    operatorStack.push(nextCharacter);
                
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    topOperator = operatorStack.pop();
                    while(topOperator != '('){
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    if(isLetter)
                        postfix += nextCharacter;
                    break;
            }

            counter++;
        }

        while(!operatorStack.isEmpty()){
            topOperator = operatorStack.pop();
            postfix += topOperator;
        }

        return postfix;
    }

    private static int precedenceCheck(char operator){
        int value;

        switch(operator){
            case '+':
            case '-':
                value = 1;
                break;
            case '*':
            case '/':
                value = 2;
                break;
            case '^':
                value = 3;
            default:
                value = -1;
                break;
        }

        return value;
    }
}

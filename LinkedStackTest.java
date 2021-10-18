public class LinkedStackTest {

    public static void main(String[] args) {
    
        String infix = "a*b/(c-a)+d*e";
        String postFix = convertToPostFix(infix);

        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + postFix);

    }

    /**
     * Converts an infix string into a post fix string
     * @param infix which gets converted into a postfix string
     * @return post fix string
     */
    private static String convertToPostFix(String infix){
        LinkedStack<Character> operatorStack = new LinkedStack<Character>();

        // Initializes the postfix return string
        String postfix = "";
        int length = infix.length();
        int counter = 0;
        char nextCharacter;
        char topOperator;

        while(counter < length){
            //checks every char in String to check if it is a letter
            nextCharacter = infix.charAt(counter);
            boolean isLetter = Character.isLetter(nextCharacter);

            // depending on the operand, it is assigned a value
            switch(nextCharacter){
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                // All operators should use the same code
                case '+':
                case '-':
                case '*':
                case '/':
                    // Checks precedence of the operator as assigned by the precedenceCheck() method
                    // pops top entry from stack
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
                    // pops top operator from stack
                    // keeps popping until open parenthesis is at top
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
    
    /**
     * Assigns value of precendence to each operator
     * @param operator, value to assign precedence
     * @return value of precedence from operator
     */
    private static int precedenceCheck(char operator){
        int value;

        // each operator is assigned a value
        // in accordance to Order of Operations
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

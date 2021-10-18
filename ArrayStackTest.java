public class ArrayStackTest {
    public static void main(String[] args) {

        // Initiates post fix string
        String postFix = "ab*ca-/de*+";
        int result = solvePostFix(postFix);

        System.out.printf("The solution to '%s' is: %d\n", postFix, result);
    }

    /**
     * Solves postfix String
     * @param postFix to solve
     * @return int value of postfix
     */
    private static int solvePostFix(String postFix){
        ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>(10);
        int size = postFix.length();
        int count = 0;
        int solution = 0;
        char nextCharacter;
        int val;

        while(count < size){
            // checks if character is a number
            nextCharacter = postFix.charAt(count);
            boolean isLetter = Character.isLetter(nextCharacter);
            switch(nextCharacter){
                // if next char is an operand, pop the last 2 values from stack
                case '^':
                case '+':
                case '-':
                case '*':
                case '/':
                    int operandOne = valueStack.pop();
                    int operandTwo = valueStack.pop();
                    solution = result(operandOne, operandTwo, nextCharacter);
                    //pushes solution from result()
                    valueStack.push(solution);
                    break;
                default:
                    // if next char is a letter, push the value onto stack
                    if(isLetter){
                        val = valueOfCharacter(nextCharacter);
                        valueStack.push(val);
                    }   
                    break;
            }

            count++;
        }
        // returns value of stack
        return valueStack.peek();
    }

    /**
     * depending on operation, do that to both operands
     * @param op1 2nd value in operation, (x-op1)
     * @param op2 1st value in operation, (op2-x)
     * @param operation to be done on operands
     * @return value of result of operation
     */
    private static int result(int op1, int op2, char operation){
        int result;

        switch(operation){
            case '+':
                result = op2 + op1;
                break;
            case '-':
                result = op2 - op1;
                break;
            case '*':
                result = op2 * op1;
                break;
            case '/':
                result = op2 / op1;
                break;
            case '^':
                for(int i = 0; i < op1; i++)
                    op2 += op2;
                result = op2;
                break;
            default:
                result = 0;
        }

        return result;
    }
    
    /**
     * Gives value to a character
     * @param check character to be given value
     * @return int value of character
     */
    private static int valueOfCharacter(char check){
        int result;

        // Returns value based on char
        switch(check){
            case 'a':
                result = 2;
                break;
            case 'b':
                result = 3;
                break;
            case 'c':
                result = 4;
                break;
            case 'd':
                result = 5;
                break;
            case 'e':
                result = 6;
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }
}

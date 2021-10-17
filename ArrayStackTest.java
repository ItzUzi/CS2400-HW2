public class ArrayStackTest {
    public static void main(String[] args) {
        String postFix = "ab*ca-/de*+";
        int result = solvePostFix(postFix);

        System.out.printf("The solution to '%s' is: %d\n", postFix, result);
    }

    private static int solvePostFix(String postFix){
        ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>(10);
        int size = postFix.length();
        int count = 0;
        int solution = 0;
        char nextCharacter;
        int val;

        while(count < size){
            nextCharacter = postFix.charAt(count);
            boolean isLetter = Character.isLetter(nextCharacter);
            switch(nextCharacter){
                case '^':
                case '+':
                case '-':
                case '*':
                case '/':
                    int operandOne = valueStack.pop();
                    int operandTwo = valueStack.pop();
                    solution = result(operandOne, operandTwo, nextCharacter);
                    valueStack.push(solution);
                    break;
                default:
                    if(isLetter){
                        val = valueOfCharacter(nextCharacter);
                        valueStack.push(val);
                    }   
                    break;
            }

            count++;
        }

        return valueStack.peek();
    }

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

    private static int valueOfCharacter(char check){
        int result;

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

package Modelo;
import Modelo.Stack.StackVector;

public class OperacionesAritmeticas {
    StackVector<Double> stack = new StackVector<>();


    public double evaluate(String expression) throws ArithmeticException {

        for (int i = 0; i < expression.length(); i++) {

            String e = String.valueOf(expression.charAt(i));

            /*
             * Verifica si es espacio
             */
            if (!e.equals(" ")){
                /*
                 * Reconoce los diferentes operadores del Postflix
                 */
                if (e.equals("+")||e.equals("-")||e.equals("*")||e.equals("/")){
                    double operandoB = stack.pop();
                    double operandoA = stack.pop();
                    switch (e) {
                        case "+":
                            stack.push(operandoA + operandoB);
                            break;
                        case "-":
                            stack.push(operandoA - operandoB);
                            break;
                        case "*":
                            stack.push(operandoA * operandoB);
                            break;
                        case "/":
                            if(operandoB == 0){
                                stack.push(0.0);
                            }else{
                                stack.push(operandoA / operandoB);
                            }
                            break;
                    }

                    /*
                     * Cuando es un operando se realiza el push
                     */
                }else {
                    stack.push(Double.parseDouble(e));
                }
            }
        }
        return stack.pop();
    }

}

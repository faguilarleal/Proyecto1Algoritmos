package Modelo;

public class OperacionesAritmeticas {

    public String evaluate(String operador, String a , String b) throws ArithmeticException {
        String r = "";
        int resultado = 0;
        int A = (Integer.parseInt(a));
        int B = (Integer.parseInt(b));

        switch (operador){
            case "+":
                resultado = A + B;
                r = String.valueOf(resultado);
                break;
            case "-":
                resultado = A - B;
                r = String.valueOf(resultado);
                break;
            case "/":
                if (A % B == 0){
                    resultado = A / B;
                    r = String.valueOf(resultado);
                }
                else {
                    r = a+" / " + b;
                }
                break;
            case "*":
                resultado = A * B;
                r = String.valueOf(resultado);
                break;

        }
        return r;

    }

}

package Modelo;

public class OperacionesAritmeticas {

    public String evaluate(String operador, String a , String b) throws ArithmeticException {
        String r = "";
        Double resultado = 0.0;
        Double A = Double.valueOf(a);
        Double B = Double.valueOf(b);

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
                resultado = A / B;
                r = String.valueOf(resultado);
                break;
            case "*":
                resultado = A * B;
                r = String.valueOf(resultado);
                break;

        }
        return r;

    }

}

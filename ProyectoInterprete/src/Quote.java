public class Quote {
    public Quote(){

    }
    public String mayus(String cadena){
        String cad="";
        for (int n = 0;n <cadena.length (); n ++) { 
            char c = cadena.charAt (n);
            cad+=Character.toUpperCase(c);
        }
        return cad;
    }
}

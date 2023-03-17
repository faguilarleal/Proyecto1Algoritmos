package Modelo;

import Modelo.Stack.StackVector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Functions {
    private HashMap<String, ArrayList<Object>> funciones = new HashMap<>();

    public void crearFuncion(String nombre, ArrayList<Object> values){
        funciones.put(nombre, values);
    }

    public boolean funcionExiste(String nombre){
        return funciones.containsKey(nombre);
    }

    public ArrayList<Object> getExp(String nombre){
        ArrayList<Object> exp = (ArrayList<Object>) funciones.get(nombre).get(1);
        return exp;
    }

    public ArrayList<Object> getParams(String nombre){
        ArrayList<Object> params = (ArrayList<Object>) funciones.get(nombre).get(0);
        return params;
    }



}

package model;
public enum TipoJornada{
    TARDE,
    MANANA;

    // obtener un elemento a partir de un string
    public static TipoJornada getTipoJornada(String texto){
        if(texto.equalsIgnoreCase("mañana")){
            return MANANA;
        } else if (texto.equalsIgnoreCase("tarde")){
            return TARDE;
        }
        return null;
    }
}
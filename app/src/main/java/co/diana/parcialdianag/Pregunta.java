package co.diana.parcialdianag;

public class Pregunta {
    String id;
    String texto;

    public Pregunta(){

    }
    public Pregunta(String id,String texto){

        this.id=id;
        this.texto=texto;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

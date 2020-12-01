package co.diana.parcialdianag;

public class Voto {
    String id;
    String idpregunta;
    int puntaje;

    public Voto(String id,String idpregunta,int puntaje){
        this.id=id;
        this.idpregunta=idpregunta;
        this.puntaje=puntaje;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(String idpregunta) {
        this.idpregunta = idpregunta;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

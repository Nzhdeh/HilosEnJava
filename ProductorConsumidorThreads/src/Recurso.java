import java.util.ArrayList;
import java.util.LinkedList;

public class Recurso {

    private LinkedList<String> listaFrases;
    //Métodos de interés:
    /*
     * addFirst / addLast
     * poll / pollFirst
     *
     * */

    public Recurso() {
        this.listaFrases = new LinkedList<>();
    }

    public Recurso(LinkedList<String> listaFrases) {
        this.listaFrases = listaFrases;

    }

    public LinkedList<String> getListaFrases() {
        return listaFrases;
    }

    public void setListaFrases(LinkedList<String> listaFrases) {
        this.listaFrases = listaFrases;
    }

    public boolean isArrayCompleto() {

        boolean isCompleto = false;
        if (listaFrases.size() >= Main.CAPACIDAD_MAX) {
            isCompleto = true;
        }
        return isCompleto;
    }


}

public class Main {
    static final int ITERACIONES_MAX = 50;
    static final int CAPACIDAD_MAX = 5;

    public static void main(String[] args) {


        ThreadsController controller = new ThreadsController();
        Recurso recurso = new Recurso();
        Productor productor = new Productor(recurso, controller);
        Consumidor consumidor = new Consumidor(recurso, controller);

        Thread hiloProductor = new Thread(productor);
        Thread hiloConsumidor = new Thread(consumidor);

        hiloProductor.start();
        hiloConsumidor.start();


    }
}

public class Consumidor
        implements Runnable {

    //Debe consumir cosas (frases) del recurso y pintarlas en pantalla

    private Recurso recurso;
    private ThreadsController controller;

    public Consumidor(Recurso recurso, ThreadsController controller) {

        this.recurso = recurso;
        this.controller = controller;
    }

    public void consumir() {

        try {
            long numeroAleatorio = (long) (Math.random() * 500);
            //System.out.println("Tiempo en milis: " + numeroAleatorio);
            Thread.sleep(numeroAleatorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fraseObtenida = recurso.getListaFrases().pollLast();
        System.out.println(fraseObtenida);
        System.out.println("Soy el consumidor, he consumido: " + fraseObtenida);

    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <= Main.ITERACIONES_MAX; ) {
                System.out.println("Consumidor - Iteración: " + i + " de "+ Main.ITERACIONES_MAX);

                if (this.recurso.getListaFrases().size() > 0) {
                    consumir();
                    i++;
                    System.out.println("Consumidor - do notify");
                    controller.doNotify();
                } else {
                    //dormir ?
                    System.out.println("Consumidor - do wait");
                    controller.doWait();
                }
                System.out.println("CONS - Recurso tiene: " +recurso.getListaFrases().size() + " elementos");
            }

        }
    }
}

import javax.management.MBeanAttributeInfo;

public class Productor

        implements Runnable {

    //Debe producir cosas (frases) y ponerlas en el recurso
    private Recurso recurso;

    private ThreadsController controller;

    /*Esto es para generar frases aleatorias*/
    private String[] firstWord = {"The", "A", "One", "Some", "Any"};
    private String[] secondWord = {"boy", "dog", "car", "bicycle"};
    private String[] thirdWord = {"ran", "jumped", "sang", "moves"};
    private String[] fourthWord = {"away", "towards", "around", "near"};

    private int oneLength = firstWord.length;
    private int secondLength = secondWord.length;
    private int thirdLength = thirdWord.length;
    private int fourthLength = fourthWord.length;

    public Productor(Recurso recurso, ThreadsController controller) {

        this.recurso = recurso;
        this.controller = controller;
    }

    public void producir() {
        try {
            long numeroAleatorio = (long) (Math.random() * 150);
            Thread.sleep(numeroAleatorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * secondLength);
        int rand3 = (int) (Math.random() * thirdLength);
        int rand4 = (int) (Math.random() * fourthLength);
        String phrase = new StringBuilder(firstWord[rand1]).append(" ")
                .append(secondWord[rand2]).append(" ")
                .append(thirdWord[rand3]).append(" ")
                .append(fourthWord[rand4]).toString();
        recurso.getListaFrases().addFirst(phrase);  //lo añade al primer elemento de la lista
        System.out.println("Soy el productor, he producido: " + phrase);

    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <= Main.ITERACIONES_MAX; ) {
                System.out.println("Productor - Iteración: " + i + " de "+ Main.ITERACIONES_MAX);

                if (!this.recurso.isArrayCompleto()) {
                    producir();
                    i++;
                    System.out.println("Productor - do notify");
                    controller.doNotify();
                } else {
                    //dormir ?
                    System.out.println("Productor - do wait");
                    controller.doWait();
                }
                System.out.println("PROD - Recurso tiene: " +recurso.getListaFrases().size() + " elementos");
            }
        }

    }


}

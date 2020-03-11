package clases;

public class Controlador extends Thread
{
	protected Productos counter = null;

	public Controlador()
	{
		
	}
	
    public Controlador(Productos counter){
       this.counter = counter;
    }

    public void run() {
	for(int i=0; i<10; i++){
          counter.add(i);
       }
    }
}

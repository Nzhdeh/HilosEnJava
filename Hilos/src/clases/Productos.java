package clases;

public class Productos 
{	
	
	long count = 0;
    
    public synchronized void add(long value){
      this.count += value;
    }
    
//	public void GenerarNumeroAleatorio() 
//	{
//		
//	}
}

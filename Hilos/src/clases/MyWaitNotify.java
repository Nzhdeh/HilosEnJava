package clases;

public class MyWaitNotify 
{
	Controlador myMonitorObject = new Controlador();
	boolean isNotificado=false;
	

  public void doWait()
  {
    synchronized(myMonitorObject)
    {
      if(!isNotificado)
      {
        try{
          myMonitorObject.wait();
         } catch(InterruptedException e)
	       {
	        	System.out.println(e);
	       }
      }
      //clear signal and continue running.
      isNotificado = false;
    }
  }

  public void doNotify()
  {
    synchronized(myMonitorObject)
    {
    	isNotificado = true;
      myMonitorObject.notify();
    }
  }
}

package main;

import clases.Controlador;
import clases.Productos;

public class Main 
{
	public static void main(String[] args) 
	{
		//hay que poner un slip de un tiempo de aleatorio 
		//en los metodos para simular la realidad
		System.out.println("fffffffffffff");
		Productos counter = new Productos();
	    Thread  threadA = new Controlador(counter);
	    Thread  threadB = new Controlador(counter);
	
	    threadA.start();
	    threadB.start();
	    
	    System.out.println("ggggggggggggggg");
	}
}

package Tema2.Ejercicios;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio01ProdCons1 {
	static volatile boolean produced;
	static volatile double product;
	
	public static void producer() {
		product = Math.random();
		produced = true;
	}
	
	public static void consumer() {
		while(!produced);
		println("The product " + product + " has been consumed.");
	}
	
	public static void main(String[] args) {
		produced = false;
		product = -1;
		
		createThread("producer");
		createThread("consumer");
		
		startThreadsAndWait();
	}
}

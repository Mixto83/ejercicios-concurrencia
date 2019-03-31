package Tema2.Ejercicios;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio02ProdConsN2 {
	static volatile boolean producing;
	static volatile double product;
	static final int NUM_PRODUCTS = 5;
	
	public static void producer() {
		product = 0;
		
		for(int i = 0; i < NUM_PRODUCTS; i++) {
			product++;
			//sleepRandom(100);
			producing = false;
			while(!producing);
		}
	}
	
	public static void consumer() {
		for(int i = 0; i < NUM_PRODUCTS; i++) {
			while(producing);
			println("The product " + product + " has been consumed.");
			//sleepRandom(100);
			producing = true;
		}
		
	}
	
	public static void main(String[] args) {
		producing = true;
		product = -1;
		
		createThread("producer");
		createThread("consumer");
		
		startThreadsAndWait();
	}
}

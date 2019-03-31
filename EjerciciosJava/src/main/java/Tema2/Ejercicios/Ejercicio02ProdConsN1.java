package Tema2.Ejercicios;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

//Version con dos booleanos
public class Ejercicio02ProdConsN1 {
	static volatile boolean produced;
	static volatile boolean consumed;
	static volatile double product;
	static final int NUM_PRODUCTS = 5;
	
	public static void producer() {
		product = 0;
		
		for(int i = 0; i < NUM_PRODUCTS; i++) {
			product++;
			consumed = false;
			//sleepRandom(100);
			produced = true;
			while(!consumed);
		}
	}
	
	public static void consumer() {
		for(int i = 0; i < NUM_PRODUCTS; i++) {
			while(!produced);
			println("The product " + product + " has been consumed.");
			produced = false;
			//sleepRandom(100);
			consumed = true;
		}
		
	}
	
	public static void main(String[] args) {
		produced = false;
		consumed = false;
		product = -1;
		
		createThread("producer");
		createThread("consumer");
		
		startThreadsAndWait();
	}
}

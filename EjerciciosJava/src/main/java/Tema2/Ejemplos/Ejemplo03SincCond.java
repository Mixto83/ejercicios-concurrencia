package Tema2.Ejemplos;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejemplo03SincCond {
	static volatile boolean continuar; //condicion
	
	public static void a() {
		print("PA1 ");
		continuar = true; //condicion
		print("PA2 ");
	}
	
	public static void b() {
		print("PB1 ");
		while(!continuar); //espera (no hace PB2 hasta que PA1 termine
		print("PB2 ");
	}
	
	public static void main(String[] args) {
		continuar = false;
		
		createThread("a");
		createThread("b");
		
		startThreadsAndWait();
	}
}

// PA1 -> PA2
//	   \
//	    >
// PB1 -> PB2

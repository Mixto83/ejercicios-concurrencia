package Tema2.Ejemplos;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejemplo02MaxMinConc {
	static volatile double n1, n2, min, max;
	
	public static void min() {
		min = n1 < n2? n1 : n2;
	}
	
	public static void max() {
		max = n1 > n2? n1 : n2;
	}
	
	public static void main(String[] args) {
		n1 = 3; n2 = 5; // I0
		createThread("min"); // I1
		createThread("max"); // I2
		startThreadsAndWait();
		println("m:" + min + " M:" + max); // I3
	}
}

// Diagrama de precedencia
//	  -> I2
// I0		 ->I3
//	  -> I3

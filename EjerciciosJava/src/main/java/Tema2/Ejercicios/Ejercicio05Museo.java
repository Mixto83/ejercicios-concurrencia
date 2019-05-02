package Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio05Museo {
	
	public static void visit() {
		while(true) {
			enterMutex();
			
			printlnI("hola");
			sleepRandom(1000);
			printlnI("que bonito!");
			printlnI("alucinante!");
			sleepRandom(1000);
			printlnI("adios");
			
			exitMutex();
			
			println("de paseo");
		}
	}
	
	public static void main(String[] args) {
		createThreads(3, "visit");
		startThreadsAndWait();
	}
}

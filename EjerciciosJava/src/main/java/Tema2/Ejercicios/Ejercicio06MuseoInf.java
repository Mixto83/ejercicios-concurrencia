package Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio06MuseoInf {
	
	public static int people;
	
	public static void visit() {
		while(true) {
			enterMutex();
			people++;
			printlnI("hola, somos " + people);
			exitMutex();
			
			printlnI("que bonito!");
			printlnI("alucinante!");
			
			enterMutex();
			people--;
			printlnI("adios a los " + people);
			exitMutex();			
			
			printlnI("de paseo");
		}
	}
	
	public static void main(String[] args) {
		people = 0;
		createThreads(3, "visit");
		startThreadsAndWait();
	}
}

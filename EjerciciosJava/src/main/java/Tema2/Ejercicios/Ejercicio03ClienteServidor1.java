package Tema2.Ejercicios;
import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio03ClienteServidor1 {
	
	static volatile int request;
	static volatile int response;
	
	static volatile boolean sent;
	static volatile boolean processed;
	
	
	public static void client() {
		request = (int) (Math.round(Math.random()*10));
		//sleepRandom(100);
		//println("Peticion " + request + " enviada");
		sent = true;
		while(!processed);
		println("Respuesta " + response + " recibida");
		//sleepRandom(100);
		//processed = false; //No hace falta porque es solo una ejecucion
	}
	
	public static void server() {
		while(!sent);
		response = request + 1;
		//sleepRandom(100);
		//println("Peticion " + request + " procesada a " + response);
		//sent = false; //No hace falta porque es solo una ejecucion
		//sleepRandom(100);
		processed = true;
	}
	
	public static void main(String[] args) {
		request = -1;
		response = -1;
		sent = false;
		processed = false;
		
		createThread("client");
		createThread("server");
		
		startThreadsAndWait();
	}
}

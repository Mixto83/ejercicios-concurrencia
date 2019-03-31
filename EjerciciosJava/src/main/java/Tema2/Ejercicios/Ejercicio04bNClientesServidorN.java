/* ------------------
 * PENDIENTE DE BUSCAR SOLUCION
 * ------------------
 */

package Tema2.Ejercicios;

import static es.urjc.etsii.code.concurrency.SimpleConcurrent.*;

public class Ejercicio04bNClientesServidorN {

	static volatile int request;
	static volatile int response;

	static volatile boolean sent;
	static volatile boolean processed;

	public static void client() {
		while(true) {
			request = (int) (Math.round(Math.random() * 10));
			//sleepRandom(100);
			//println("Peticion " + request + " enviada");
			sent = true;
			while (!processed);
			processed = false;
			println("Respuesta " + response + " recibida");
			//sleepRandom(100);
			
		}
	}

	public static void server() {
		while(true) {
			while (!sent);
			sent = false;
			response = request + 1;
			//sleepRandom(100);
			//println("Peticion " + request + " procesada a " + response);
			//sleepRandom(100);
			processed = true;
		}
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

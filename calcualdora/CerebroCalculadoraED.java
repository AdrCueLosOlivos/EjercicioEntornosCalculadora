package calcualdora;

import java.util.Scanner;

public class CerebroCalculadoraED {

	private Operaciones operacion;
	private double resultado, numero1, numero2;
	private String[] historial;
	private final int TAMANOHISTORIAL = 5;
	Scanner tecladoCce = new Scanner(System.in);

	CerebroCalculadoraED() {
		historial = new String[TAMANOHISTORIAL];
		resultado = 0;
	}
//Se encarga de reedireccionar hacia la operacion segun el numero introducido y realiza la operacion
	public void procesarOperacion(String op) {
		Operaciones operacion;
		System.out.println("proceso " + op);
		switch (op) {
		//En estas funciones segun el numero introducido se ejecutara una operacion de las disponibles
		case "1":
			operacion = Operaciones.SUMAR;
			operarSuma(operacion);
			break;
		case "2":
			operacion = Operaciones.RESTAR;
			operarResta(operacion);
			break;
		case "3":
			operacion = Operaciones.MULTIPLICAR;
			operarMultiplica(operacion);
			break;
		case "4":
			operacion = Operaciones.DIVIDIR;
			operarDivide(operacion);
			break;
		case "5":
			operacion = Operaciones.SUMAR_RES;
			operarSumaRes(operacion);
			break;
		case "6":
			operacion = Operaciones.RESTAR_RES;
			operarRestaRes(operacion);
			break;
		case "7":
			operacion = Operaciones.MULTIPLICAR_RES;
			operarMultiplicaRes(operacion);
			break;
		case "8":
			operacion = Operaciones.DIVIDIR_RES;
			operarDivideRes(operacion);
			break;
		case "9":
			operacion = Operaciones.RESULTADO;
			mostrarResultadoActual(operacion);
			break;
		case "10":
			operacion = Operaciones.RANDOM;
			numeroAleatorio(operacion);
			break;
		case "11":
			operacion = Operaciones.HISTORIAL;
			operarHistorial(operacion);
			break;
			//en caso de poner un numero o simbolo erroneo o que no sea reconocido  
			//saldra esto por pantalla y te permitira volver a introducir otra vez el numero 
		default:
			System.out.println("ERROR: La operación " + op + " no es conocida.");
		}
	}
	//Se trata de la operacion que Suma ambos numeros introducidos
	private void operarSuma(Operaciones op) {
		setOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que resta ambos numeros introducidos
	private void operarResta(Operaciones op) {
		setOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que multiplicacion ambos numeros introducidos
	private void operarMultiplica(Operaciones op) {
		setOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que division ambos numeros introducidos
	private void operarDivide(Operaciones op) {
		setOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que Suma del ultimo resultado y un numero introducido
	private void operarSumaRes(Operaciones op) {
		setOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que resta del ultimo resultado y un numero introducido
	private void operarRestaRes(Operaciones op) {
		setOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que multiplicacion del ultimo resultado y un numero introducido
	private void operarMultiplicaRes(Operaciones op) {
		setOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que division del ultimo resultado y un numero introducido
	private void operarDivideRes(Operaciones op) {
		setOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	//Se trata de la operacion que muestra el ultimo resultado obtenido
	private void mostrarResultadoActual(Operaciones op) {
		setOperacion(op);
		System.out.println("El valor actual del resultado es: " + this.resultado + "\n");
	}
	//Se trata de la operacion que genera un numero aleatorio de 1 a 100 
	private void numeroAleatorio(Operaciones op) {
		setOperacion(op);
		this.resultado = (double)(Math.random()*100+1);
		System.out.println("El número aleatorio generado es: " + this.resultado + "\n");
		anadirHistorialAleatorio(op);
	}
	//Es la operacion que almacena los ultimos 5 resultados y nos los muestra
	private void operarHistorial(Operaciones op) {
		System.out.println("*** Historial de las cinco últimas operaciones ***");
		for (String hist : historial) {
			System.out.println(hist);
		}
		System.out.println("\n");
	}
	
	private void setOperacion(Operaciones op) {
		System.out.println("//////////////////////////////");
		System.out.println("-> " + op.getNombre() + " - " + op.getInfo());
	}
	//Se utiliza para las operaciones que solo necesitan un numero y el resultado ultimo obtenido
	private void pedirUnNumero() {
		System.out.println("Introduce el número: ");
		this.numero1 = this.resultado;
		this.numero2 = tecladoCce.nextDouble();
	}
	//Se utiliza para pedir los 2 numero en las operaciones
	private void pedirDosNumeros() {
		System.out.println("Introduce el primer número: ");
		this.numero1 = tecladoCce.nextDouble();
		System.out.println("Introduce el segundo número: ");
		this.numero2 = tecladoCce.nextDouble();
	}
	//Se muestra el resultado obtenido en la operacion que hemos realizado
	private void mostrarResultado(Operaciones op) {
		System.out.println("El resultado de la operación " + op.getNombre().toLowerCase() + " es:");
		System.out.println(Double.toString(numero1) 
				+ " " + op.getSimbolo() + " " 
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado) + "\n");
	}
	//Conserva los resultados obtenidos por si fuese necesario mostrarlos
	private void anadirHistorial(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " 
				+ Double.toString(numero1) 
				+ " " + op.getSimbolo() + " " 
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}
	
	public void anadirHistorialAleatorio(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " 
				+ Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}

	public Operaciones getOperacion() {
		return operacion;
	}

}

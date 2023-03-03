package calcualdora;

import java.util.Scanner;

public class CalculadoraED {

	public static void main(String[] args) {
		//Tiene la funcion de detectar los numeros introducidos por el usuario
		CerebroCalculadoraED cce = new CerebroCalculadoraED();
		try (Scanner teclado = new Scanner(System.in)) {
			String entrada;
			do {
				imprimirCabecera();
				imprimirSeleccionOp();
				//te permite poner los numero o simbolos , en caso de introducir erroneamente , te volvera a dejar introducirlos
				entrada = teclado.next();
				if (validarEntrada(entrada)) {
					cce.procesarOperacion(entrada);
				}else {
					System.out.println("Entrada no reconocida");
				}
				//en caso de introducir "x" la consola se cerrara
			} while (!entrada.equals("x"));
		}
		imprimirDespedida();
	}
	
	// muestra por pantalla una cabecera para la calculadora
	private static void imprimirCabecera() {
		System.out.println("*----------------------------------*");
		System.out.println("*----------Calculadora ED----------*");
		System.out.println("*----------------------------------*");
	}
	// muestra por pantalla una despedida para la calculadora
	private static void imprimirDespedida() {
		System.out.println("*-----------------------------------------*");
		System.out.println("*----¡Gracias por usar Calculadora ED!----*");
		System.out.println("*-----------------------------------------*");
	}
    //muestra por pantalla un menu de opciones para la calculadora
	private static void imprimirSeleccionOp() {
		Operaciones[] ops = Operaciones.values();
		for(Operaciones op: ops)
		{
			System.out.println(op.getOpcionMenu());
	    }
		System.out.println("¿Qué operación desea realizar? (x para terminar)");
	}
	
	// Si el usuario quiere salir introduzca "X" ,
    // si no se empieza operaciones y 
    // nos permite introducir segun el enum hace la operacion que quiera el usuario 
    private static boolean validarEntrada(String entrada) {
        if (entrada.equals("x")) {
            return true;
        } else {
            Operaciones[] ops = Operaciones.values();
            for(Operaciones op: ops) {
                if(Integer.toString(op.getId()).equals(entrada)) {
                    return true;
                }
            }
            return false;
        }
    }	
}

package calcualdora;

public enum Operaciones {
	//Realiza la suma de los numeros pedidos por pantalla
	SUMAR("Suma","+","Suma dos números",1),
	//Realiza la resta de los 2 numeros pedidos por pantalla
	RESTAR("Resta","-","Resta dos números",2),
	//Realiza la multiplicacion de 2 numeros que son pedidos por pantalla
	MULTIPLICAR("Multiplicación","*","Multiplica dos números",3),
	//Realiza la division de 2 numeros introducidos por pantalla
	DIVIDIR("División","/","Divide dos números",4),
	//Suma que realizada entre el resultado anterior y un numero introducido por el usuario
	SUMAR_RES("Sumar al resultado","+=","Suma un número al resultado actual",5),
	//Resta que realizada entre el resultado anterior y un numero introducido por el usuario
	RESTAR_RES("Restar al resultado","-=","Al resultado actual le resta un número",6),
	//Multiplicacion que es realizada entre el resultado anterior y un numero introducido por el usuario
	MULTIPLICAR_RES("Multiplicar al resultado","*=","Multiplica un número al resultado actual",7),
	//Division que se realiza entre el resultado anterior y un numero introducido por el usuario
	DIVIDIR_RES("Dividir al resultado","/=","Resultado actual dividido por un número",8),
	//Te muestra el ultimo resultado obtenido 
	RESULTADO("Mostrar resultado","!","Muestra el último resultado",9),
	//Nos muestra un numero aleatorio entre 1 a 100 
	RANDOM("Número aleatorio","¿?","Crea un número aleatorio 1-100", 10),
	//Muestra el resultado de nuestras operaciones anteriores 
	HISTORIAL("Historial","h","Muestra las cinco últimas operaciones",11);
	
	private final String nombreOperacion;
	private final String simboloOperacion;
	private final String setOperacion;
	private final int idOperacion;
	
	Operaciones (String nombre, String simbolo, String set, int id){
		this.nombreOperacion = nombre;
		this.simboloOperacion = simbolo;
		this.setOperacion = set;
		this.idOperacion = id;
	}
	//Realiza el string para poder saber que operacion va a ser realizada segun el usuario 
	public String getNombre() {return nombreOperacion;}
	public String getInfo() {return setOperacion;}
	public String getSimbolo() {return simboloOperacion;}
	public int getId() {return idOperacion;}
	public String getOpcionMenu() {return idOperacion + ".- " + nombreOperacion;}
	 @Override
	    public String toString() {
	        return String.format("%s (%s)", getSimbolo() );
	    }
}
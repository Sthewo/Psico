public class MecPalanca {

	
	public static void main(String[] args) {
		
		double posicionCaja = posicionCaja(1);
		String posicionFuerza = posicionFuerza(1);
		String pregunta = "La caja pesa X = [1,10] y esta situada a "+posicionCaja+"m del centro de la palanca, para levantar la caja ¿Qué fuerza hay que aplicar sobre "+posicionFuerza+"?";
		System.out.println(pregunta);
	}
	
	//PREGUNTA: (Las preguntas 1,2,3 es la misma pregunta pero reformulada, la pregunta 4 es diferente)
	//1. La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}?
	//2. Para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?
	//3. Que fuerza debemos hacer para equilibrar la balanza, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?
	//4. La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, sobre que punto debe colocarse la segunda caja que pesa Y para que la balanza este equilibrada?
	//TODO generar numero X
	//TODO seleccionar la pregunta
	//TODO elegir el lugar sobre el que hacer la fuerza || calcular el peso de la segunda caja.
	//TODO una vez tenemos el enunciado calcular el resultado.
	
	public static String getEnunciadoProblema( int numeroProblema,  int pesoCaja, double posicionCaja, String posicionFuerza){
		String enunciado = "";
		
		switch (numeroProblema){
		case 1:
			enunciado = "La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}?";
			break;
		case 2:
			enunciado = "Para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?";
			break;
		case 3:
			enunciado = "Que fuerza debemos hacer para equilibrar la balanza, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?";
			break;
		case 4:
			enunciado = "La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, sobre que punto debe colocarse la segunda caja que pesa Y para que la balanza este equilibrada?";
			break;
		case 5:
			enunciado = "La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, sobre que punto debe colocarse la segunda caja que pesa Y para que la balanza este equilibrada?";
			break;
		}
			
		
		return enunciado;
	}
	
	public static double posicionCaja( int numero ){
		double posicion = 0;
		
		switch (numero){
		case 1:
			posicion = 1;
			break;
		case 2:
			posicion = 1.5;
			break;
		case 3:
			posicion = 2;
			break;
		}
		
		return posicion;
	}
	
	public static String posicionFuerza( int numero ){
		String posicion = "";
		
		switch (numero){
		case 1:
			posicion = "A";
			break;
		case 2:
			posicion = "B";
			break;
		case 3:
			posicion = "C";
			break;
		}
		
		return posicion;
	}
	
		
	

}

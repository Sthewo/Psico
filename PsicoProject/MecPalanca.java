public class MecPalanca {

	
	public static void main(String[] args) {
		
		double posicionCaja = posicionCaja(1);
		String posicionFuerza = posicionFuerza(1);
		String pregunta = "La caja pesa X = [1,10] y esta situada a "+posicionCaja+"m del centro de la palanca, para levantar la caja ¿Qué fuerza hay que aplicar sobre "+posicionFuerza+"?";
		System.out.println(pregunta);
	}
	
	//PREGUNTA:
	//La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}?
	//Para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?
	//Que fuerza debemos hacer para equilibrar la balanza, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?
	//La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, sobre que punto debe colocarse la segunda caja para que la balanza este equilibrada?
	//TODO generar numero X
	//TODO elegir el lugar sobre el que hacer la fuerza
	//TODO una vez tenemos el enunciado calcular el resultado.
	
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

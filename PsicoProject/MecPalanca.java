public class MecPalanca {
	
	//clase para guardar la distancia y el nombre de la posicion(ya que ambos valores se obtienen en la misma funcion y hace falta retornarlos juntos)
	static public class cajaB{
		public cajaB(String f_posicion, double f_distancia){
			posicion = f_posicion;
			distancia = f_distancia;
		}
		
		public String posicion = "A";
		public double distancia = 1;
			
	};
	
	//clase para tratar las respuestas sin usar VGlobales, igual que la anterior clase, se devuelve todo desde la misma funcion
	static public class resultado{
		public resultado(){
			a = "";
			b = "";
			c = "";
			d = "";
			correcto = "";
		}
		
		public String a;
		public String b;
		public String c;
		public String d;
		public String correcto;
			
	}
	
	public static void main(String[] args) {
		
		//Esto es para generar preguntas de forma aleatoria, por si no las queremos de forma ordenada 
		/*
		int numeroPregunta = RNG(1,3);
		int pesoCaja = RNG(1,10);
		int pesoCajaB = RNG(1,10);
		int posicionCaja = posicionCaja(RNG(1,3));
		String nombreFoto = nombreFoto(posicionCaja);
		cajaB cajaB = posicionFuerza(RNG(1,3));
		*/
		//Hacemos todas las combinaciones posibles de pesos de caja, posicion de la caja y posicion de la fuerza
		for( int f_pesoCaja = 1; f_pesoCaja < 21; f_pesoCaja++){
			for(int f_posicionCaja = 1; f_posicionCaja < 4; f_posicionCaja++){
				for(int f_posicionFuerza = 1; f_posicionFuerza < 4; f_posicionFuerza++){
					cajaB cajaB = posicionFuerza(f_posicionFuerza);//Calculamos distancia y posicion de la caja
					String nombreFoto = nombreFoto(f_posicionCaja);//Obtenemos el nombre de la foto para la posicion de la caja elegida 
					int posicionCaja = posicionCaja(f_posicionCaja);//Obtenemos la letra de la posicion de la caja
					int pesoCajaB = 0;// todavia no se usa, solo se inicializa a 0
					int numeroPregunta = RNG(1,3);//obtenemos una de las tres posibles maneras de formular la pregunta
					
					//Pasamos los valores y los ponemos todos juntos en CSV
					System.out.println(getCSV(numeroPregunta, f_pesoCaja, pesoCajaB, posicionCaja, nombreFoto, cajaB));
				}
			}
		}
	}
	
	//PREGUNTA: (Las preguntas 1,2,3 es la misma pregunta pero reformulada, la pregunta 4 es diferente)
	//1. La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}?
	//2. Para equilibrar la balanza que fuerza hay que aplicar sobre LETRA = {A, B, C}, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?
	//3. Que fuerza debemos hacer para equilibrar la balanza, si la caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}?
	//4. La caja pesa X = [1,10] y esta situada a m = {1m, 1'5m, 2m}, sobre que punto debe colocarse la segunda caja que pesa Y para que la balanza este equilibrada?
	//
	
	// Peso de la cajaB no se usa
	public static String getCSV(int numeroPregunta, int pesoCaja, int pesoCajaB, int posicionCaja, String nombreFoto, cajaB cajaB){
		
		
		String pregunta = generaEnunciadoProblema(numeroPregunta, pesoCaja, posicionCaja, cajaB, pesoCajaB);
		resultado resultado = calcularResultado(numeroPregunta, pesoCaja, posicionCaja, cajaB, pesoCajaB);
		
		String CSV = ""; 
		CSV += "mecanica;";
		CSV += pregunta + ";";
		CSV += nombreFoto +";";
		CSV += ";;;;;;";
		CSV += "a)"+ resultado.a +";";
		CSV += "b)"+ resultado.b +";";
		CSV += "c)"+ resultado.c +";";
		CSV += "d)"+ resultado.d +";";
		CSV += resultado.correcto +";";
		CSV += "El peso de la caja, multiplicado por la distancia de la caja hasta el medio de la palanca, debe ser igual para ambas cajas.;";//Tip
		
		
		return CSV;
	}
	
	public static String generaEnunciadoProblema( int numeroProblema,  int pesoCaja, int posicionCaja, cajaB cajaB, int pesoCajaB ){
		String enunciado = "";
		
		switch (numeroProblema){
		case 1:
			enunciado = "La caja pesa " + pesoCaja + "Kg y está situada a " + posicionCaja + "m del centro de la palanca, para equilibrar la balanza qué fuerza hay que aplicar sobre " + cajaB.posicion + ".";
			break;
		case 2:
			enunciado = "Para equilibrar la balanza qué fuerza hay que aplicar sobre " + cajaB.posicion + ". Si la caja pesa " + pesoCaja + "Kg y está situada a " + posicionCaja + "m del centro.";
			break;
		case 3:
			enunciado = "Qué fuerza debemos hacer sobre el punto " + cajaB.posicion + " para equilibrar la balanza, si la caja pesa " + pesoCaja + "Kg y está situada a " + posicionCaja + "m del centro.";
			break;
		/*case 4:
			enunciado = "La caja pesa " + pesoCaja + "Kg y esta situada a " + posicionCaja + "m del centro de la palanca ¿Sobre que punto debe colocarse la segunda caja que pesa " + pesoCajaB + "Kg para que la balanza este equilibrada?";
			break;
		case 5:
			enunciado = "La caja pesa " + pesoCaja + "Kg y esta situada a " + posicionCaja + "m del centro de la palanca ¿Sobre que punto debe colocarse la segunda caja que pesa " + pesoCajaB + "Kg para que la balanza este equilibrada?";
			break;*/
		}
		return enunciado;
	}
			
	//Dado un numero del 1 al 3 te dice a que distancia esta la caja del centro
	public static int posicionCaja( int numero ){
		int posicion = 0;
		
		switch (numero){
		case 1:
			posicion = 4;
			break;
		case 2:
			posicion = 2;
			break;
		case 3:
			posicion = 1;
			break;
		}
		
		return posicion;
	}
	
	//Dada la posicion 1->4m, 2->2m, 3->1m te dice la foto que le corresponde
	public static String nombreFoto( int numero ){
		String foto = "";
		switch (numero){
		case 1:
			foto = "mec09062018-1.png";
			break;
		case 2:
			foto = "mec09062018-2.png";
			break;
		case 3:
			foto = "mec09062018-3.png";
			break;
		}
		
		return foto;
	}
	
	
	//Dado un numero del 1 al 3 te dice que posicion(A,B,C) y la distancia de esa posicion al centro. 
	public static cajaB posicionFuerza( int numero ){
		
		cajaB cajaB = new cajaB("A",1);
		
		switch (numero){
		case 1:
			cajaB.posicion = "A";
			cajaB.distancia = 1;
			break;
		case 2:
			cajaB.posicion = "B";
			cajaB.distancia = 2;
			break;
		case 3:
			cajaB.posicion = "C";
			cajaB.distancia = 4;
			break;
		}
		
		return cajaB;
	}
	

	//Dado el enunciado y los datos minimos peso distanca y posicion de la fuerza calcula el resultado, los 3 resultados falsos, los desordena y los devuelve como String
	//Peso cajaB no se usa
	public static resultado calcularResultado( int numeroProblema,  int pesoCaja, int posicionCaja, cajaB cajaB, int pesoCajaB ){
		
		resultado resultado = new resultado();
		
		double calculo = pesoCaja * posicionCaja / cajaB.distancia;
		
		if( numeroProblema == 1 || numeroProblema == 2 || numeroProblema == 3 ){
			
			
			resultado.a = calculo 	  + "";
			resultado.b = calculo * 2 + "";
			resultado.c = calculo * 3 + "";
			resultado.d = calculo * 4 + "";
			
			String pattern = "(.*)\\.0";
			resultado.a = resultado.a.replaceAll(pattern, "$1");
			resultado.b = resultado.b.replaceAll(pattern, "$1");
			resultado.c = resultado.c.replaceAll(pattern, "$1");
			resultado.d = resultado.d.replaceAll(pattern, "$1");
			resultado.correcto = resultado.a;
			
		}
		
		desordenarResultados(resultado);
		
		
		return resultado;
	}
	
	//Desordena los resultados y le asigna la letra correspondiente a la respuesta correcta
	public static resultado desordenarResultados(resultado resultado){
		
		String temp;
		
		switch(RNG(1,4)){//Intercambia A con otra respuesta
			case 1:
				break;
			case 2:
				temp = resultado.a;
				resultado.a = resultado.b;
				resultado.b = temp;
				break;
			case 3:
				temp = resultado.a;
				resultado.a = resultado.c;
				resultado.c = temp;
				break;
			case 4:
				temp = resultado.a;
				resultado.a = resultado.d;
				resultado.d = temp;
				break;
		}
		
		switch(RNG(1,4)){//Intercambia B con otra respuesta
		case 1:
			break;
		case 2:
			temp = resultado.b;
			resultado.b = resultado.a;
			resultado.a = temp;
			break;
		case 3:
			temp = resultado.b;
			resultado.b = resultado.c;
			resultado.c = temp;
			break;
		case 4:
			temp = resultado.b;
			resultado.b = resultado.d;
			resultado.d = temp;
			break;
		}
		
		switch(RNG(1,4)){//Intercambia C con otra respuesta
		case 1:
			break;
		case 2:
			temp = resultado.c;
			resultado.c = resultado.a;
			resultado.a = temp;
			break;
		case 3:
			temp = resultado.c;
			resultado.c = resultado.b;
			resultado.b = temp;
			break;
		case 4:
			temp = resultado.c;
			resultado.c = resultado.d;
			resultado.d = temp;
			break;
		}
		
		switch(RNG(1,4)){//Intercambia D con otra respuesta
		case 1:
			break;
		case 2:
			temp = resultado.d;
			resultado.d = resultado.a;
			resultado.a = temp;
			break;
		case 3:
			temp = resultado.d;
			resultado.d = resultado.b;
			resultado.b = temp;
			break;
		case 4:
			temp = resultado.d;
			resultado.d = resultado.c;
			resultado.c = temp;
			break;
		}
		
		if(resultado.correcto == resultado.a){
			resultado.correcto = "a)"+resultado.correcto;
		}else if( resultado.correcto == resultado.b){
			resultado.correcto = "b)"+resultado.correcto;
		}else if( resultado.correcto == resultado.c){
			resultado.correcto = "c)"+resultado.correcto;
		}else if( resultado.correcto == resultado.d){
			resultado.correcto = "d)"+resultado.correcto;
		}
			
		
		
		return resultado;
	}
	
	public static int RNG( int DESDE, int HASTA ){
		int random = (int )(Math.random() * HASTA + DESDE);
		
		return random;
	}
	
}

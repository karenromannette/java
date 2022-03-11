package frases;
/*Frases [option]
 * [option] puede ser "todos", para mostrar todas las frases
 * Si no se esntrega el argumento [option], muestra una frase aleatoria*/
public class Frases {
	
	public static String[] frases = {
			"Nada cambia si nada cambia",
			"Al que madruga Dios lo ayuda",
			"camaron que se duerme se lo lleva la corriente",
			"Arroz con leche me quiero casar",
	};

	public static void main(String[] args) {
		if( args.length == 0) {
			mostrarFraseAleatoria();
		}else {
			mostrarTodasLasFrases();
		}
		
	}
    public static void mostrarFraseAleatoria() {	
	     double numeroAleatorio = Math.random() * frases.length;
	     int numeroAleatorioEntero = (int) numeroAleatorio;
	     System.out.println(frases[numeroAleatorioEntero]);
	    	
    	
    	
    }
    
    public static void mostrarTodasLasFrases() {
    	for(int i = 0; i < frases.length; i++) {
    		System.out.println( frases[i] );
    	}
    	
    }
}

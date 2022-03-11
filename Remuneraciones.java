package remuneraciones;

public class Remuneraciones {

	public static void main(String[] args) {
		if(args.length < 6) {
			mostratAyuda();
		}else {
			calcularRemuneraciones(args);
		}
		
		

	}

	

	private static void mostratAyuda() {
		System.out.println("Remuneraciones [sueldo-base] [colacion] [movilizacion] [afp] [salud] [tipo-contrato]");
		System.out.println(" Ejemplo Remuneraciones 1000000 100000 20000 habitat vidatres f (fijo) ");
		//i=indefinido f=fijo c=trabajador casa particular
	}
	
	private static void calcularRemuneraciones(String[] args) {
		//todas las conversiones de tipos de datos
		int sueldoBase = Integer.parseInt(args[0]);
		int colacion = Integer.parseInt(args[1]);
		int movilizacion = Integer.parseInt(args[2]);
		String afp = args[3];
		String salud = args[4];
		char tipoContrato = args[5].charAt(0);
		
		int montoImponible = calcularMontoImponible(sueldoBase);
		int montoAFP = calcularMontoAFP(montoImponible, afp);
		int montoSalud = calcularMontoSalud(montoImponible, salud);
		int seguroCesantia = calcularSeguroCesantia(montoImponible, tipoContrato);
		
		System.out.printf("Monto imponible: $%d\n", montoImponible);
		System.out.printf("AFP: %s\n",afp);
		System.out.printf("Monto AFP: $%d\n",montoAFP);
		System.out.printf("Salud: %s\n", salud);
		System.out.printf("Monto salud : $%d\n", montoSalud);
		System.out.printf("Contrato: %s\n", tipoContrato);
		System.out.printf("Monto seguro cesantia : $%d\n", seguroCesantia);
		
	}
	
	private static int calcularMontoImponible(int sueldoBase){
		return sueldoBase;
	}
	
	private static int calcularMontoNoImponible(int colacion, int movilizacion) {
		return colacion + movilizacion;
	}
	
	private static int calcularMontoAFP(int montoImponible, String afp) {
		switch (afp) {
		case "capital":{
			return (int) (montoImponible*0.1144);
		}
		case "cuprum":{
			return (int) (montoImponible*0.1144);
		}
		case "habitat":{
			return (int) (montoImponible*0.1127);
		}
		case "planvital":{
		return (int) (montoImponible*0.1116);
	    }
		case "provida":{
			return (int) (montoImponible*0.1145);
		}
		case "modelo":{
			return (int) (montoImponible*0.1058);
		}
		case "uno":{
			return (int) (montoImponible*0.1069);
		}
		
		
	} 
		return 0;
	}
	
	private static int calcularMontoSalud(int montoImponible, String salud) {
		float uf = 31539.65f;
		switch (salud) {
		case "fonasa":{
			return (int) (montoImponible*0.07);
		}
		case "vidatres":{
			return (int) (uf*2.74);
		}
		case "banmedica":{
			return (int) (uf*2.86);
		}
		case "cruzblanca":{
			return (int) (uf*2.75);
		}
		case "colmena":{
			return (int) (uf*2.76);
		}
		case "masvida":{
			return (int) (uf*2.75);
		}
		case "cosalud":{
			return (int) (uf*2.71);
		}
		}
		
		return 0;
	}
	
	private static int calcularSeguroCesantia (int montoImponible, char tipoContrato) {
		switch (tipoContrato) {
		case 'i':{
			return (int) (montoImponible*0.024);
		}
		case 'f':{
			return (int) (montoImponible*0.03);
		}
		case 'c':{
			return (int) (montoImponible*0.03);
		}
		}
		return 0;
	}
	
	
}

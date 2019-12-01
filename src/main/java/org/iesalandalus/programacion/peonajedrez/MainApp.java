package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	static Peon peonDefecto;
	static Peon peonColor;
	static Object crearPeonColor;
	static Peon peonColorColumna;
	static Object crearPeonColorColumna;
		
	public static void main(String[] args) {
		
		do{
				mostrarMenu();
						
			switch (elegirOpcion())
			{
				case 1: crearPeonDefecto();
					break;
				case 2: crearPeonColor();
					break;
				case 3: crearPeonColorColumna();
					break;
				case 4: mostrarPeon();
					break;
			}
			
		}while (elegirOpcion()!=5);	
				
	}	
		
		private static void crearPeonDefecto() {
			peonDefecto = new Peon();
			System.out.println("Has creado un Peón por defecto. ");
			System.out.println(peonDefecto);		
			
		}
		
		private static void mostrarPeon() {
			if (MainApp.peonDefecto==null)
				throw new NullPointerException("No hay creado peón por defecto.");
			else 
				System.out.println(MainApp.peonDefecto);		
						
			if (MainApp.crearPeonColor==null)
				throw new NullPointerException("No hay creado peón por color");
			else 
				System.out.println(MainApp.crearPeonColor);
							
			if (MainApp.crearPeonColorColumna==null)
				throw new NullPointerException("No hay creado peón por color y columna");
			else 
				System.out.println(MainApp.crearPeonColorColumna);
				
		}
				
		private static void mostrarMenu() {
			
			System.out.println("Peon en el tablero de ajedez.");
			System.out.println("-----------------------------");
			System.out.println("1 - Crear un peon por defecto.");
			System.out.println("2 - Crear un peon seleccionando el color.");
			System.out.println("3 - Crear un peon seleccionando el color y su columna inicial.");
			System.out.println("4 - Mostrar el peón. ");
			System.out.println("5 - Salir.");
		}
				
		private static int elegirOpcion() {
			
			int elegirOpcion;
			
			System.out.print("Elegir Opcion : ");
			elegirOpcion=Entrada.entero();
			return elegirOpcion;
		
		}
		
		private static Color elegirColor() {
					
			String elegirColor;
			Color colorSalida;
			
			do {	
				System.out.print("Introduce el color del peón (BLANCO o NEGRO): ");
						
				elegirColor=Entrada.cadena();
				
			} while(!elegirColor.toUpperCase().equals("BLANCO") && !elegirColor.toUpperCase().equals("NEGRO"));
						
					if (elegirColor.equals("BLANCO") || elegirColor.equals("blanco"))
						colorSalida = Color.BLANCO;
					else 
						colorSalida = Color.NEGRO;
					return colorSalida;
						
		}
			
		private static void crearPeonColor() {
			
			peonColor = new Peon(elegirColor());
			System.out.println("Has creado un peón por color.");
			System.out.println(peonColor);
	
		}
		
		private static void crearPeonColorColumna() {
			
			peonColorColumna = new Peon(elegirColor(), elegirColumnaInicial());
			System.out.println("Has creado un peón por color y columna.");
			System.out.println(peonColorColumna);
		}
		
		private static char elegirColumnaInicial() {
			
			char elegirColumnaInicial;
			
			do {
				System.out.print("Introduce la columna inicial (a-h): ");
						
					elegirColumnaInicial=Entrada.caracter();
					
			} while(elegirColumnaInicial<'a' || elegirColumnaInicial>'h');
					
					return elegirColumnaInicial;	
				
		}
}
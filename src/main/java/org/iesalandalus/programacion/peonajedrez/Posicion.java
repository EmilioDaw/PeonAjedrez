package org.iesalandalus.programacion.peonajedrez;

public class Posicion {
	
		//Declaracion de atributos
	
		private int fila;
		private char columna;
		
				
		//Constructor
					
		public Posicion(int fila, char columna) {
			setFila(fila);
			setColumna(columna);
			
		}
		
		//Constructor copia
		
		public Posicion(Posicion p) {
			
			if (p==null)
				throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
			
			setFila(p.getFila());
			setColumna(p.getColumna());
			
		}
		
		//Metodos
		
		protected void setFila(int fila) {
			if (fila<1 || fila>8) 
				throw new IllegalArgumentException("ERROR: Fila no válida.");
			else 
				this.fila=fila;
		}
		
		public int getFila() {
			return fila;
		}

		protected void setColumna(char columna) {
			if (columna<'a' || columna>'h') 
				throw new IllegalArgumentException("ERROR: Columna no válida.");		
			else
				this.columna=columna;
		}
		public char getColumna() {
			return columna;
		}
		@Override
		public boolean equals(Object p) {
			return this.getFila()==((Posicion) p).getFila() && this.getColumna()==((Posicion) p).getColumna();
		}
		@Override
		public int hashCode() {
			return getFila()*getColumna();
		}
		@Override
		public String toString() {
			return "fila="+this.getFila()+", columna="+this.getColumna();
		}
		
}
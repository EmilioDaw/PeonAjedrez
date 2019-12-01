package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

public class Peon {
	
	//Declaracion de atributos
	
	private Posicion posicion;
	private Color color;
	
	
	//Constructor
	
	public Peon() {
		posicion=new Posicion(7,'d');
		color=Color.NEGRO;
	}
	
	public Peon(Color color) {
		
		setColor(color);
		if (color==Color.NEGRO)
			posicion=new Posicion(7,'d');
		else
			posicion=new Posicion(2,'d');
	}
	
	public Peon(Color color, char columna) {
		if (color==null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		
		this.color=color;
		if (color==Color.NEGRO)
			posicion=new Posicion(7,columna);
		else
			posicion=new Posicion(2,columna);
	}
	
	
	//Metodos
	
	private void setColor(Color color) {
		if (color==null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		else
		this.color=color;
		}
		
	public Color getColor() {
		return color;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion==null)
			throw new NullPointerException("ERROR: Movimiento no válido.");
		else
		this.posicion=posicion;
		}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	//Direccion del peón.	
	public void mover(Direccion direccion) throws OperationNotSupportedException {
	
		if (direccion==null)
			throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está¡ permitido.");
		
		if (color==Color.BLANCO) 
		{
				if(direccion==Direccion.IZQUIERDA) 
				{
						if (posicion.getColumna()=='a')
							throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
						else {
							posicion.setColumna((char)(posicion.getColumna()-1));
							posicion.setFila((char)(posicion.getFila()+1));
							}
				}
				else {
							if (posicion.getColumna()=='h')
								throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
							else {
								posicion.setColumna((char)(posicion.getColumna()+1));
								posicion.setFila((char)(posicion.getFila()+1));
								}
					}
		}else {
					if (direccion==Direccion.IZQUIERDA) 
					{
							if(posicion.getColumna()=='a')
								throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					else {
						posicion.setColumna((char)(posicion.getColumna()-1));
						posicion.setFila((char)(posicion.getFila()-1));
						}	
			}else 
				if(posicion.getColumna()=='h')
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				else { 
					posicion.setColumna((char)(posicion.getColumna()+1));
					posicion.setFila((char)(posicion.getFila()-1));
					}
			}
	}
	
	//Avance del peón.
	public void mover(int pasos) throws OperationNotSupportedException {
		
		if (color==Color.BLANCO){
			switch (pasos){
				case 1: if(posicion.getFila()==8)
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				else
					posicion.setFila((char)(posicion.getFila()+1));
				break;
				case 2: if(posicion.getFila()!=2)
					throw new OperationNotSupportedException("ERROR: El peón solo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
				else
					posicion.setFila((char)(posicion.getFila()+2));
				break;
			default: throw new OperationNotSupportedException("ERROR: El peón solo se puede mover 1 o 2 pasos.");
			}
		}
		else 
		{
			switch (pasos) 
			{
				case 1: if (posicion.getFila()==1)
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
					else 
						posicion.setFila((char)(posicion.getFila()-1));
					break;
				case 2: if (posicion.getFila() !=7)
					throw new OperationNotSupportedException("ERROR: El peón solo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
					else 
						posicion.setFila((char)(posicion.getFila()-2));
					break;
				default: throw new OperationNotSupportedException("ERROR: El peón solo se puede mover 1 o 2 pasos.");
			}
		}
	}	
	
	
	@Override
	public boolean equals(Object peonAux) {
		return (this.color == ((Peon) peonAux).getColor() && this.posicion.equals(((Peon) peonAux).getPosicion()));
	}
	@Override
	public int hashCode() {
		int code = 1;
		if (this.getColor() == Color.BLANCO)
			code = 2;
		return code * this.getPosicion().hashCode();
	}
	@Override
	public String toString() {
		return this.getPosicion()+", color="+this.getColor();
	
	}
}
package TDALista;

import Excepciones.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Nodo.*;

/**
 * Clase ElementIterator
 * Implementa la interfaz Iterator
 * @author Comision número 37. Torre Goni Manon / Villarreta Florencia
 * @param <E> tipo de dato del rotulo
 */

public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> lista;
	protected Position <E> cursor; 
	
	/**
	 * Constructor de la clase ElementIterator
	 * @param L Lista a iterar
	 */
	
	public ElementIterator(PositionList<E> L) {
		lista = L; 
		try {
			if (lista.isEmpty()) cursor=null; 
			else cursor=lista.first(); 
		}catch(EmptyListException e) {
			System.out.println("La lista esta vacia");
			}
	}
	
	/**
	 * Retorna verdadero si existe siguiente elemento, falso en caso contrario.
	 * @return Verdadero si existe siguiente elemento, y falso en caso contrario
	 */
	
	public boolean hasNext() { 
		return cursor !=null;
	}
	
	/**
	 * Retorna el siguiente elemento a iterar.
	 * @return siguiente elemento a iterar.
	 * @throws NoSuchElementException si no hay siguiente elemento.
	 */
	
	public E next() throws NoSuchElementException{
		if (cursor == null) {
			throw new NoSuchElementException("Error: No hay siguiente");
			}
		E toReturn = cursor.element();
		try {
		cursor = (cursor == lista.last()) ? null : lista.next(cursor);
		} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {
			System.out.println(e.getMessage());
		}
		return toReturn;
	}
}

package TDALista;

import java.util.Iterator;

import Nodo.*;
import Excepciones.*;

/**
 * Clase DoubleLinkedList
 * Implementa la interfaz PositionList con una lista doblemente enlazada
 * @author 
 * @param <E> tipo de dato del rotulo
 */

public class DoubleLinkedList<E> implements PositionList<E>{
	private DNode<E> cabeza;
	private DNode<E> rabo;
	private int size;
	
	/**
	 * Constructor de la clase DoubleLinkedList.
	 */
	
	public DoubleLinkedList(){ //CENTINELAS
		cabeza = new DNode<E> (null, null, null);
		rabo = new DNode<E>(null, null, cabeza);
		cabeza.setSiguiente(rabo);
		size = 0;
	}
	/**
	 * Consulta la cantidad de elementos de la lista.
	 * @return Cantidad de elementos de la lista.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Consulta si la lista est� vac�a.
	 * @return Verdadero si la lista est� vac�a, falso en caso contrario.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * Devuelve la posici�n del primer elemento de la lista. 
	 * @return Posici�n del primer elemento de la lista.
	 * @throws EmptyListException si la lista est� vac�a.
	 */
	public Position<E> first() throws EmptyListException{
		if (size == 0) { //tmb podria haber probado con cabeza.getSiguiente()==rabo o rabo.getAnterior()==cabeza
			throw new EmptyListException("La lista esta vacia");
		}
		return cabeza.getSiguiente();
	}
	
	/**
	 * Devuelve la posici�n del �ltimo elemento de la lista. 
	 * @return Posici�n del �ltimo elemento de la lista.
	 * @throws EmptyListException si la lista est� vac�a.
	 * 
	 */
	public Position<E> last() throws EmptyListException{
		if (size==0) {
			throw new EmptyListException("La lista esta vacia");
		}
		return rabo.getAnterior();
		
	}
	
	/**
	 * Devuelve la posici�n del elemento siguiente a la posici�n pasada por par�metro.
	 * @param p Posici�n a obtener su elemento siguiente.
	 * @return Posici�n del elemento siguiente a la posici�n pasada por par�metro.
	 * @throws InvalidPositionException si el posici�n pasada por par�metro es inv�lida o la lista est� vac�a.
	 * @throws BoundaryViolationException si la posici�n pasada por par�metro corresponde al �ltimo elemento de la lista.
	 */
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n = checkPosition(p);
		if (n == rabo.getAnterior()) {
			throw new BoundaryViolationException("No se le puede pedir el siguiente al ultimo elemento");
		}
		DNode<E> aux = n.getSiguiente();
		return aux;
	}
	
	/**
	 * Devuelve la posici�n del elemento anterior a la posici�n pasada por par�metro.
	 * @param p Posici�n a obtener su elemento anterior.
	 * @return Posici�n del elemento anterior a la posici�n pasada por par�metro.
	 * @throws InvalidPositionException si la posici�n pasada por par�metro es inv�lida o la lista est� vac�a.
	 * @throws BoundaryViolationException si la posici�n pasada por par�metro corresponde al primer elemento de la lista.
	 */
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n = checkPosition(p);
		if (n == cabeza.getSiguiente()) {
			throw new BoundaryViolationException("No se le puede pedir el previo al primero");
		}
		DNode<E> aux = n.getAnterior();
		return aux;
	}
	
	/**
	 * Inserta un elemento al principio de la lista.
	 * @param element Elemento a insertar al principio de la lista.
	 */
	public void addFirst(E element) {
		DNode<E> aux = new DNode<E>(element);
		aux.setSiguiente(cabeza.getSiguiente());
		cabeza.getSiguiente().setAnterior(aux);
		cabeza.setSiguiente(aux);
		aux.setAnterior(cabeza);
		size++;
	}
	
	/**
	 * Inserta un elemento al final de la lista.
	 * @param element Elemento a insertar al final de la lista.
	 */
	public void addLast(E element) {
		DNode<E> aux = new DNode<E>(element);
		aux.setAnterior(rabo.getAnterior());
		rabo.getAnterior().setSiguiente(aux);
		rabo.setAnterior(aux);
		aux.setSiguiente(rabo);
		size++;
	}
	
	
	private DNode <E> checkPosition(Position<E> p) throws InvalidPositionException{
		DNode <E> retornar;
		if (p == null || size == 0 )
			throw new InvalidPositionException("No es una posicion de la lista o es una lista vacia");
		retornar = (DNode <E>)p;
		return retornar;
	}
	
	/**
	 * Inserta un elemento luego de la posici�n pasada por par�matro.
	 * @param p Posici�n en cuya posici�n siguiente se insertar� el elemento pasado por par�metro.
	 * @param element Elemento a insertar luego de la posici�n pasada como par�metro.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.
	 */
	public void addAfter(Position<E> p, E element) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		DNode<E> nuevo = new DNode<E>(element);
		nuevo.setSiguiente(n.getSiguiente());
		nuevo.setAnterior(n);
		nuevo.getSiguiente().setAnterior(nuevo);
		n.setSiguiente(nuevo);
		size++;
		//ver el dibujito en teoria
	}
	
	/**
	 * Inserta un elemento antes de la posici�n pasada como par�metro.
	 * @param p Posici�n en cuya posici�n anterior se insertar� el elemento pasado por par�metro. 
	 * @param element Elemento a insertar antes de la posici�n pasada como par�metro.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.
	 */
	public void addBefore(Position<E> p, E element) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		DNode<E> nuevo = new DNode<E>(element);
		nuevo.setAnterior(n.getAnterior());
		nuevo.setSiguiente(n);
		nuevo.getAnterior().setSiguiente(nuevo);
		n.setAnterior(nuevo);
		size++;
	}

	/**
	 * Remueve el elemento que se encuentra en la posici�n pasada por par�metro.
	 * @param p Posici�n del elemento a eliminar.
	 * @return element Elemento removido.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.
	 */	
	public E remove(Position<E> p) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		E aux = n.element();
		n.getAnterior().setSiguiente(n.getSiguiente());
		n.getSiguiente().setAnterior(n.getAnterior());
		n.setAnterior(null);
		n.setSiguiente(null);
		size--;
		return aux;
	}

	/**
	
	 * Establece el elemento en la posici�n pasados por par�metro. Reemplaza el elemento que se encontraba anteriormente en esa posici�n y devuelve el elemento anterior.
	 * @param p Posici�n a establecer el elemento pasado por par�metro.
	 * @param element Elemento a establecer en la posici�n pasada por par�metro.
	 * @return Elemento anterior.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.	 
	 */
	public E set(Position<E> p, E element) throws InvalidPositionException{
		DNode<E> n = checkPosition(p);
		E aux = n.element();
		n.setElemento(element);
		return aux;
	}
	
	/**
	 * Devuelve un un iterador de todos los elementos de la lista.
	 * @return Un iterador de todos los elementos de la lista.
	 */

	public Iterator<E> iterator() {
		Iterator<E> it = new ElementIterator<E>(this); 
		return it;
	}
	
	/**
	 * Devuelve una colecci�n iterable de posiciones.
	 * @return Una colecci�n iterable de posiciones.
	 */
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> list = new DoubleLinkedList<Position<E>>(); 
		try {
			if (size!=0) {
				Position<E> pos = first();
				while (pos!=last()) {
					list.addLast(pos);
					pos = next(pos);
				}
				list.addLast(pos);
			}
		}catch(EmptyListException|InvalidPositionException|BoundaryViolationException e) {
			e.getMessage();
		}
		return list;
	}
}
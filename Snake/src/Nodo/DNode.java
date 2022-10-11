package Nodo;



/**
 * Clase NodoDE
 * Implementa la interfaz Position
 * @author Comision número 39. Villarreta Florencia /  Torre Goni Manon
 * @param <E> tipo de dato del rotulo
 */

public class DNode<E> implements Position<E> { 
	private E elemento;
	private DNode <E> siguiente; 
	private DNode <E> anterior; 
	
	/**
	 * Constructor de la clase NodoDE
	 * @param item Elemento que sera almacenado en el nodo
	 */
	
	public DNode(E item) {
		this(item,null, null);
	}

	/**
	 * Constructor de la clase NodoDE
	 * @param item Elemento que sera almacenado en el nodo
	 * @param sig Nodo siguente al nodo actual
	 * @param ant Nodo anterior al nodo actual
	 */
	
	public DNode(E item, DNode<E> sig, DNode<E> ant) {
		elemento = item;
		siguiente = sig;
		anterior = ant;
	}
	
	/**
	 * Asigna un valor al elemento
	 * @param elemento elemento a almacenar en el nodo.
	 */
	
 	public void setElemento(E elemento) {
 	this.elemento = elemento;
	}
 	
	/**
	 * Asigna el nodo siguente al nodo actual.
	 * @param siguiente nodo siguiente al actual.
	 */
 	
	public void setSiguiente(DNode<E> siguiente) {
		this.siguiente= siguiente;
	}
	
	/**
	 * Asigna el nodo anterior al nodo dado
	 * @param anterior nodo anterior al nodo actual.
	 */
	
	public void setAnterior(DNode<E> anterior) {
		this.anterior= anterior;
	}
	
	/**
	 * Retorna el nodo siguiente al actual.
	 * @return El nodo siguente al nodo actual.
	 */
	
	public DNode<E> getSiguiente(){
		return siguiente;
	}
	
	/**
	 * Retorna el nodo anterior al nodo actual.
	 * @return nodo anterior al nodo actual.
	 */
	
	public DNode<E> getAnterior(){
		return anterior;
	}
	
	/**
	 * Retorna el valor del elemento.
	 * @return Valor del elemento
	 */
	
	public E element() {
		return elemento;
	}
}

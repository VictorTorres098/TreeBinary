package arbolesPack;

public class AB<T> {  //arbol binario
	private Nodo<T> raiz;
	
	public class Nodo<T>{
		private T info;
		private Nodo<T> izq;
		private Nodo<T> der;
		
		public Nodo(T info) {
			this.info = info;
		}
		@Override
		public String toString() {
			return info.toString();
		}
	}
	public void agregar(T elem) {
		Nodo<T> nuevo = new Nodo<T>(elem);
		if(raiz == null) raiz = nuevo;
		else
			agregar(raiz, nuevo);
	}
	private void agregar(Nodo<T> padre, Nodo<T> nuevo) {
		if(padre.izq == null) padre.izq = nuevo;
		else
			if(padre.der == null) padre.der = nuevo;
			else
				//decision de implementacion: generar el arbol a derecha
				agregar(padre.der,nuevo);
	}
	public Nodo<T> buscar(T elem){
		return (raiz == null) ? null : buscar(raiz,elem);
	}
	private Nodo<T> buscar(Nodo<T> nodo, T elem){
		if(nodo.info.equals(elem)) return nodo;
		else {
			Nodo<T> izq = null;
			Nodo<T> der = null;
			if(nodo.izq != null)
				izq = buscar(nodo.izq, elem);
			if(nodo.der != null)
				der = buscar(nodo.der, elem);
			//Decision de implementacion: si esta en ambos lados, mostramos el izquierdo primero
			if(izq != null) return izq;
			else return der;
		}
	}
	public int cantNodos() {
		return (raiz == null ) ? 0 : cantNodos(raiz);
	}
	private int cantNodos(Nodo<T> nodo) {
		int cantIzq = (nodo.izq == null) ? 0 : altura(nodo.izq);
		int cantDer = (nodo.der == null) ? 0 : altura(nodo.der);
		return 1 + cantIzq + cantDer;
	}
	public int altura() {
		return (raiz == null) ? 0 : altura(raiz);
	}
	private int altura(Nodo<T> nodo) {
		int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq);
		int altDer = (nodo.der == null) ? 0 : altura(nodo.der);
		return 1 + Math.max(altIzq, altDer);
	}
	//caso base en arboles: dos enfoques
	
	//version1:
	public boolean balanceadoV1() {
		return (raiz == null) ? true : balanceadoV1(raiz);
	}
	private boolean balanceadoV1(Nodo<T> nodo) {
		boolean ret = true;
		int altIzq = 0;
		int altDer = 0;
		if(nodo.izq != null) {
			altIzq = altura(nodo.izq);
			ret = ret && balanceadoV1(nodo.izq);
		}
		if(nodo.der != null) {
			altDer = altura(nodo.der);
			ret = ret && balanceadoV1(nodo.der);
		}
		ret = ret && Math.abs(altIzq - altDer) <= 1;
		return ret;
	}
	//version2:
	public boolean balanceadoV2() {
		return (raiz == null) ? true : balanceadoV2(raiz);
	}
	private boolean balanceadoV2(Nodo<T> nodo) {
		if(nodo == null) return true;
		else {
			int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq);
			int altDer = (nodo.der == null) ? 0 : altura(nodo.der);
			return Math.abs(altIzq - altDer) <= 1 && balanceadoV2(nodo.izq) && balanceadoV2(nodo.der);
		}
	}
	@Override
	public String toString(){
		return (raiz == null) ? "" : toString(raiz);
	}
	private String toString(Nodo<T> nodo){
		String ret = nodo.info.toString();
		if (nodo.izq != null) ret = ret + toString(nodo.izq);
		if (nodo.der != null) ret = ret + toString(nodo.der);
		return ret;
	}
}

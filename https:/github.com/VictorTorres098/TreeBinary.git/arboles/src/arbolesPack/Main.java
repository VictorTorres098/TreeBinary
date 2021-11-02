package arbolesPack;

import arbolesPack.AB.Nodo;

public class Main {

	public static void main(String[] args) {
		AB<Integer> test = new AB<Integer>();
		test.agregar(22);
		test.agregar(23);
		test.agregar(24);
		test.agregar(25);
		test.agregar(26);
		test.agregar(27);
		test.agregar(28);
		test.agregar(29);
		test.agregar(30);
		
		System.out.println(test.buscar(30));
	}

}

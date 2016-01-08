package com.gmm.foo.lambda;

import java.util.function.Consumer;

public class ExpresionesLambda {

	public static void main(String[] args) {

		Consumer<String> consumidor = (x) -> System.out.println(x);
		consumidor.accept("hola");

	}

}

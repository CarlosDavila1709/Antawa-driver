package store.antawa.backoffice.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PruebaStream {

	public static void streamComp() {
		String texto="nombre:pedro,nombre:gema,nombre:ana";

		Stream<String> bloques= Pattern.compile(",").splitAsStream(texto);
		
		bloques.map(cadena->cadena.substring(7, cadena.length())).
		forEach(System.out::println);
		
	}
	public static List<Empleados> getEmpleados(){
		List<Empleados> list = new ArrayList<Empleados>();
		Empleados em0 = new Empleados("34223dfdf4234","Jose Mon",20);
		Empleados em1 = new Empleados("3422324dfsf34","Martha",30);
		Empleados em2 = new Empleados("87867fdfd666f","Julio Mili",40);
		Empleados em3 = new Empleados("234dsfhdsghff","Pepe Mujica",20);
		list.add(em0);
		list.add(em3);
		list.add(em2);
		list.add(em1);
		return list;
	}
	
	public static void streamSimple() {

		List<Empleados> empleados = getEmpleados();
		
		empleados.stream()
				.filter(x -> x.getNombres().equals("Systems"))
				.forEach(System.out::println)
				;
		
	}
	
	public static void main(String[] args) {
		streamComp();

	}

}

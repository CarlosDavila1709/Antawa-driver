package store.antawa.backoffice.test;

public class Empleados {

	private String uid;
	private String nombres;
	private int edad;
	
	public Empleados() {
		
	}
	public Empleados(String uid, String nombres, int edad) {
		this.uid = uid;
		this.nombres = nombres;
		this.edad = edad;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}

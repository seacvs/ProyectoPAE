package proyecto;

public class Cliente {
	int id,id_plan;
	String name;
	String lastname;
	String mail;
	String fechaNacimiento;
	String telefono;
	String plan;
	
	
	public Cliente() {
		super();
	}

	public Cliente(int id, int id_plan, String name, String lastname, String mail, String fechaNacimiento,
			String telefono, String plan) {
		super();
		this.id = id;
		this.id_plan = id_plan;
		this.name = name;
		this.lastname = lastname;
		this.mail = mail;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.plan = plan;
	}
	
	
	


}

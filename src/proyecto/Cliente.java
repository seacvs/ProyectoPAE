package proyecto;

import javafx.beans.property.SimpleStringProperty;

public class Cliente {//Clase cliente la cual se usa para llenar la tabla de clientes desde la BD

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty lastname;
    private SimpleStringProperty estatus;

    private SimpleStringProperty mail;
    private SimpleStringProperty fechaNacimiento;
    private SimpleStringProperty telefono;
    private SimpleStringProperty plan;
    private SimpleStringProperty sexo;

    private SimpleStringProperty fechaInicio;
    private SimpleStringProperty fechaFin;
    private SimpleStringProperty hora;

    public Cliente() {
        super();
    }

    public Cliente(String id, String name, String lastname, String estatus, String mail, String fechaNacimiento,
                   String telefono, String plan, String sexo, String fechaInicio, String fechaFin, String hora) {
        super();
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.estatus = new SimpleStringProperty(estatus);

        this.mail = new SimpleStringProperty(mail);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
        this.telefono = new SimpleStringProperty(telefono);
        this.plan = new SimpleStringProperty(plan);
        this.sexo = new SimpleStringProperty(sexo);

        this.fechaInicio = new SimpleStringProperty(fechaInicio);
        this.fechaFin = new SimpleStringProperty(fechaFin);
        this.hora = new SimpleStringProperty(hora);
    }

    public Cliente(String id, String name, String lastname, String estatus, String mail, String fechaNacimiento,
                   String telefono, String sexo, String fechaInicio, String fechaFin, String hora) {
        super();
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.estatus = new SimpleStringProperty(estatus);

        this.mail = new SimpleStringProperty(mail);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
        this.telefono = new SimpleStringProperty(telefono);
        this.sexo = new SimpleStringProperty(sexo);

        this.fechaInicio = new SimpleStringProperty(fechaInicio);
        this.fechaFin = new SimpleStringProperty(fechaFin);
        this.hora = new SimpleStringProperty(hora);
    }


    public Cliente(String id, String lastname, String name, String estatus,String plan, String sexo) {
        super();
        this.id = new SimpleStringProperty(id);
        this.lastname = new SimpleStringProperty(lastname);
        this.name = new SimpleStringProperty(name);
        this.estatus = new SimpleStringProperty(estatus);
        this.plan = new SimpleStringProperty(plan);
        this.sexo = new SimpleStringProperty(sexo);

    }
    
    public Cliente(String name, String lastname,String plan, String mail, String fechaNacimiento,
			String telefono,String fechaInicio, String hora) {
		super();
		this.name = new SimpleStringProperty(name);
		this.lastname = new SimpleStringProperty(lastname);
		this.mail = new SimpleStringProperty(mail);
		this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
		this.telefono = new SimpleStringProperty(telefono);
		this.fechaInicio = new SimpleStringProperty(fechaInicio);
		this.hora = new SimpleStringProperty(hora);
	}
    
    public String getEstatus() {
        return estatus.get();
    }

    public void setEstatus(String estatus) {
        this.estatus.set(estatus);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }


    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getMail() {
        return mail.get();
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);;
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);;
    }

    public String getPlan() {
        return plan.get();
    }

    public void setPlan(String plan) {
        this.plan.get();
    }

    public String getSexo() {
        return sexo.get();
    }

    public void setSexo(String sexo) {
        this.sexo.set(sexo);;
    }

    public String getFechaInicio() {
        return fechaInicio.get();
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio.set(fechaInicio);
    }

    public String getFechaFin() {
        return fechaFin.get();
    }

    public SimpleStringProperty fechaFinProperty() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin.set(fechaFin);
    }

    public String getHora() {
        return hora.get();
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }
}
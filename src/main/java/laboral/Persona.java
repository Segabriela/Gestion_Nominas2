package laboral;

public abstract class Persona {
    public String nombre;
    public String dni;
    public char sexo;

    public Persona(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public char getSexo(){
        return sexo;

    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void imprime(){
    System.out.println ( "Nombre:"+ nombre  + ", Sexo:" + sexo
        );
}
}
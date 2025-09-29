package laboral;

public class Empleado extends Persona {
    private int categoria;
    public int anyo;

    // contructor todos los datos
    public Empleado(String nombre, String dni, char sexo, int categoria, int anyo) throws DatosNoCorrectosException {
        super ( nombre, dni, sexo );
        setCategoria ( categoria );
        if (anyo < 0){
        throw new DatosNoCorrectosException("Los años no pueden ser negativos");
        }
        this.anyo = anyo;

    } //constructor empleado nombre, sexo y dni

    public Empleado(String nombre, String dni, char sexo) {
        super ( nombre, dni, sexo );
        this.categoria = 1;
        this.anyo = 0;

    }
    public void setCategoria(int categoria) throws DatosNoCorrectosException {
       if (categoria < 1 || categoria > 10){
           throw new DatosNoCorrectosException("La categoria insertada no es correcta");
        }
       this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void incrAyo(){
        this.anyo++;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public void imprime() {
        System.out.println ( "Nombre:" + nombre
                + ", Dni:" + dni
                + ", Sexo:" + sexo
                + ", Categoria:"
                + categoria
                + ", Años:" + anyo
        );
    }
}

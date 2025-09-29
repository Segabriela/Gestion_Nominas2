package laboral;

public class CalcularNominas {
    //Aquí imprime el empleado
    public void escribe(Empleado e) {
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("DNI: " + e.getDni());
        System.out.println("Sexo: " + e.getSexo());
        System.out.println("Categoria: " + e.getCategoria());
        System.out.println("Años: " + e.anyo);
    }
    public void escribe(Empleado e, Nomina n) {
        escribe(e);
        System.out.println("Sueldo: " + n.sueldo(e));
}}
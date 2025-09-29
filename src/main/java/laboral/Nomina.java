package laboral;

public class Nomina {
    private static final int SUELDO_BASE[] = {
            50000, 70000, 90000, 110000, 130000,
            150000, 170000, 190000, 210000, 230000
    };
    private static final int PLUS_ANTIGUEDAD = 5000;

    public int sueldo(Empleado e) {
        int base = SUELDO_BASE[e.getCategoria() - 1];
        return base + (PLUS_ANTIGUEDAD * e.getAnyo());
    }
}

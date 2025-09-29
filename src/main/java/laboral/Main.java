package laboral;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Nomina nomina = new Nomina();

            // 🔹 Leemos empleados desde la BD
            List<Empleado> empleados = GestorBD.leerEmpleadosBD();

            System.out.println("Empleados en la base de datos:");
            for (Empleado e : empleados) {
                e.imprime();

                // 🔹 Guardamos su sueldo en la tabla nominas
                GestorBD.guardarNomina(e, nomina);
            }

            System.out.println("Nóminas generadas y guardadas correctamente en la base de datos.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

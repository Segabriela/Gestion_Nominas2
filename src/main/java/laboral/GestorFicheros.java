package laboral;

import java.io.*;
import java.util.*;

public class GestorFicheros {

    // Leer empleados desde empleados.txt
    public static List<Empleado> leerEmpleadosTxt(String nombreFichero) throws IOException, DatosNoCorrectosException {
        List<Empleado> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length != 5) continue; // saltar líneas inválidas

                String nombre = datos[0]. trim();
                String dni = datos[1];
                char sexo = datos[2].charAt(0);
                int categoria = Integer.parseInt(datos[3]);
                int anyos = Integer.parseInt(datos[4]);

                lista.add(new Empleado(nombre, dni, sexo, categoria, anyos));
            }
        }
        return lista;
    }

    // Escribir salarios.dat (binario)
    public static void escribirSalariosDat(List<Empleado> empleados, Nomina nomina, String nombreFichero) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreFichero))) {
            for (Empleado e : empleados) {
                dos.writeUTF(e.getDni());
                dos.writeInt(nomina.sueldo(e));
            }
        }
    }

    // Escribir sueldos.txt (texto)
    public static void escribirSueldosTxt(List<Empleado> empleados, Nomina nomina, String nombreFichero) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {
            for (Empleado e : empleados) {
                pw.println(e.getDni() + ";" + nomina.sueldo(e));
            }
        }
    }
}

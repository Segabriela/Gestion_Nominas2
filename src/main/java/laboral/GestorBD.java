package laboral;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {

    private static final String URL = "jdbc:mysql://localhost:3306/Gestion_nominas";
    private static final String USER = "root";   // cámbialo si usas otro usuario
    private static final String PASSWORD = "usuario"; // cámbialo si tu clave es distinta

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 🔹 Leer empleados desde la tabla empleados
    public static List<Empleado> leerEmpleadosBD() throws SQLException, DatosNoCorrectosException {
        List<Empleado> lista = new ArrayList<>();

        String sql = "SELECT nombre, dni, sexo, categoria, anyos FROM empleados";
        try (Connection con = conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                char sexo = rs.getString("sexo").charAt(0);
                int categoria = rs.getInt("categoria");
                int anyos = rs.getInt("anyos");

                Empleado e = new Empleado(nombre, dni, sexo, categoria, anyos);
                lista.add(e);
            }
        }
        return lista;
    }

    // 🔹 Guardar nómina en la tabla nominas
    public static void guardarNomina(Empleado e, Nomina nomina) throws SQLException {
        double sueldo = nomina.sueldo(e);

        String sql = "INSERT INTO nominas (dni, salario) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE salario = VALUES(salario)";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.dni);
            ps.setDouble(2, sueldo);
            ps.executeUpdate();
        }
    }
}

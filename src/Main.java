import java.sql.*;

// Escribir la libreira;  // importar la libreria
public class Main {
    public static void main(String[] args) {
        // Declarar las Variables de conexión
        String usuario="root";
        String contra="1234";
        String url="jdbc:mysql://localhost:3306/universidad";
         // 1. Load Driver (Optional for newer JDBC versions)
        Connection cnx;
        Statement st;
        ResultSet rs;

        // 1. Load Driver (Optional for newer JDBC versions)
        try { // Manejo de Errores Try catch
            // 2. Establecer la conexión e Imprimir
            cnx = DriverManager.getConnection(url, usuario, contra);
            System.out.println("Conectado correctamente.");
            // 3. Create Statement
            st=cnx.createStatement();
            // 4. Execute Query
            //CRUD - INSERT - SELECT - UPDATE - DELETE
            // INSERT
            String sqlInsert = ("INSERT INTO estudiantes (nombre, correo) VALUES ('Pepito', 'pepito@gmail.com')");
            st.executeUpdate (sqlInsert);
            System.out.println("Estudiante ingresado correctamente.");
            // UPDATE
            st.executeUpdate("UPDATE estudiantes SET nombre='NombreActualizado' WHERE id=3");
            System.out.println("Estudiante actualizado.");
            // DELET
            st.executeUpdate("DELETE FROM estudiantes WHERE id=3");
            System.out.println("Estudiante eliminado.");
            // SELECT
            rs = st.executeQuery("SELECT * FROM estudiantes");
            // 5. Process Results
            if(rs.next()){
                do{
                    System.out.println(
                        rs.getInt("id")+" : "+
                        rs.getString("nombre")+ " - "+
                        rs.getString("correo"));
                }while(rs.next());
            }
            // 6. Close resources
            // Cerrar el Resultado de la Consulta
            rs.close();
            // Cerra el statement
            st.close();
            // Cerrar la conexion a la base de datos e Imprimir
            cnx.close();
            System.out.println("Conexion cerrada.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}


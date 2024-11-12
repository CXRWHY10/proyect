package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection connexion = null;
    public static Connection getConnexion() throws SQLException {
        if (connexion == null) {
            try {
                connexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexion exitosa a la base de datos");
            } catch (SQLException e) {
                System.err.println("Error al conectar base datos" + e.getMessage());
                throw e;
            }
        }
        return connexion;
    }
    public static void CerrarConexion() throws SQLException{
        if (connexion != null){
            try{
                connexion.close();
                System.out.println("conexion cerrada");
            }catch (SQLException e){
                System.out.println("Error al cerrar la conexion");
                throw e;
            }
        }
    }
}

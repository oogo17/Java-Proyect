
package utilidades;
import conexiones.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class pruebas {
    static Conexion obj;
    public static void main(String[] args) {
        Usuarios.nombre="administrador";
      
        obj=new Conexion();
        obj.conectarMySQL();
        String [] contenidos={"2382","2","Marzo","2023"};
        try {
            obj.insertar(4,contenidos);
            JOptionPane.showMessageDialog(null,"Se insertaron con exito 1 filas");
            obj.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

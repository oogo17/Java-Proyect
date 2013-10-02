package conexiones;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilidades.Tablas;
import utilidades.Usuarios;

public class Conexion {
Connection conexion; //Variable para instanciar el objeto de la clase Connection para la conexion
Statement sentencia; //Variable para instanciar el objeto de la clase Statement para manejar las consultas
ResultSet resultado; //Variable para instanciar el objeto de la clase Resulset para manejar el resultado de las consultas
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Se registra el driver, que manejara las conexiones a la BD
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    /*Este metodo se encarga de realizar la conexion con el manejador de BD en este caso MySQL, dependiendo del usuario que se logge se le asigna un usuario de MySQL*/
    public void conectarMySQL() {

        try {

            if (Usuarios.nombre.equals("administrador")) {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/papeleria_angel", "root", "");//Se establece la conexion con la BD especificada, asi como el usuario
            } else {
                //contraseña en mysql de usuario:userangel
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/papeleria_angel", "usr_papeleria", "userangel");//Se establece la conexion con la BD especificada, asi como el usuario
            }
            sentencia=conexion.createStatement();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al conectar con la Base de Datos", "Error", 0);

        }

    }
    /*
     * Metodo encargado de Insertar Valores en una Tabla X perteneciente a la Base de Datos
     * Recibe como argumentos, un numero que esta asociado al nombre de la Tabla
     * y un arreglo tipo String que contiene todos los valores que se insertaran en la nueva Fila
     * Este metodo es utilizado para la insercion de datos en cualquier tabla
     */
    public void insertar(int NombreTabla,String [] Valores) throws SQLException{//Este metodo Arroja una Excepcion de SQL por lo que cualquier otro metodo o clase que lo implemente debe capturar dicha Excepcion
        
        String sentenciaSQL="";
        switch(NombreTabla){
            case 1:
                sentenciaSQL="INSERT INTO "+Tablas.Nombre_Tablas[NombreTabla-1]+" VALUES ('"+Valores[0]+"','"+Valores[1]+"','"+Valores[2]+"','"+Valores[3]+"','"+Valores[4]+"','"+Valores[5]+"');";
               break;
           case 2:
               sentenciaSQL="INSERT INTO "+Tablas.Nombre_Tablas[NombreTabla-1]+" VALUES ('"+Valores[0]+"','"+Valores[1]+"','"+Valores[2]+"','"+Valores[3]+"','"+Valores[4]+"','"+Valores[5]+"');";
               break;
           case 3:
               sentenciaSQL="INSERT INTO "+Tablas.Nombre_Tablas[NombreTabla-1]+" VALUES ('"+Valores[0]+"','"+Valores[1]+"','"+Valores[2]+"','"+Valores[3]+"');";
               break;
           case 4:
               sentenciaSQL="INSERT INTO "+Tablas.Nombre_Tablas[NombreTabla-1]+" VALUES ('"+Valores[0]+"','"+Valores[1]+"','"+Valores[2]+"','"+Valores[3]+"','"+Valores[4]+"');";
               break;
           case 5:
               sentenciaSQL="INSERT INTO "+Tablas.Nombre_Tablas[NombreTabla-1]+"  VALUES ('"+Valores[0]+"','"+Valores[1]+"','"+Valores[2]+"','"+Valores[3]+"');";
               break;
           case 6:
              sentenciaSQL="INSERT INTO "+Tablas.Nombre_Tablas[NombreTabla-1]+"  VALUES ('"+Valores[0]+"','"+Valores[1]+"','"+Valores[2]+"','"+Valores[3]+"','"+Valores[4]+"','"+Valores[5]+"','"+Valores[6]+"','"+Valores[7]+"','"+Valores[8]+"','"+Valores[9]+"','"+Valores[10]+"','"+Valores[11]+"');";
               break;
           case 7:
               sentenciaSQL="INSERT INTO "+Tablas.Nombre_Tablas[NombreTabla-1]+"  VALUES ('"+Valores[0]+"','"+Valores[1]+"','"+Valores[2]+"','"+Valores[3]+"');";
               break;
        }
        sentencia.execute(sentenciaSQL);
       
              
    }
    
    /**
     * Metodo eliminar este metodo se encarga de borrar un registro de la base de datos
     * Recive como parametros un numero que indica a que tabla se refiere y el nombre del algun elemento del registro quse se desea eliminar
     * 
     */
     public void eliminar(int NombreTabla, String elemento) throws SQLException{//Este metodo Arroja una Excepcion de SQL por lo que cualquier otro metodo o clase que lo implemente debe capturar dicha Excepcion
         String sentenciaSQL="";
         switch (NombreTabla){
             case 1:
                 sentenciaSQL="DELETE from "+Tablas.Nombre_Tablas[NombreTabla-1]+" where Clave_A = '"+elemento+"'";
                 break;
             case 2:
                  sentenciaSQL="DELETE from "+Tablas.Nombre_Tablas[NombreTabla-1]+" where Folio_C = '"+elemento+"'";
                 break;
             case 3:
                  sentenciaSQL="DELETE from "+Tablas.Nombre_Tablas[NombreTabla-1]+" where Folio_C = '"+elemento+"'";
                 break;
             case 4:
                  sentenciaSQL="DELETE from "+Tablas.Nombre_Tablas[NombreTabla-1]+" where Folio_V = '"+elemento+"'";
                 break;
             case 5:
                  sentenciaSQL="DELETE from "+Tablas.Nombre_Tablas[NombreTabla-1]+" where Folio_V = '"+elemento+"'";
                 break;
             case 6:
                  sentenciaSQL="DELETE from "+Tablas.Nombre_Tablas[NombreTabla-1]+" where ID_Pro = '"+elemento+"'";
                 break;
              case 7:
                  sentenciaSQL="DELETE from "+Tablas.Nombre_Tablas[NombreTabla-1]+" where Folio_C = '"+elemento+"'";
                 break;
         }
         sentencia.executeUpdate(sentenciaSQL);

     }
    
     
     /*
      Este metodo se encarga de hacer modificaciones a un registro en la Base de datos
      * REcibe como parametros un nuemero q indica la tabla q se utilizara
      * Un arreglo con los valores a modificar 
      * y una variable llamada elemento que es el ID del registro q se desea modificar
      
      */
     public void modificar(int NombreTabla, String [] Valores, String elemento) throws SQLException{//Este metodo Arroja una Excepcion de SQL por lo que cualquier otro metodo o clase que lo implemente debe capturar dicha Excepcion
     String sentenciaSQL="";
     String Encabezados[]=Tablas.devuelveEncabezados(NombreTabla);
     
        switch(NombreTabla){
            case 1:
                sentenciaSQL="UPDATE "+Tablas.Nombre_Tablas[NombreTabla-1]+" SET "+Encabezados[0]+" ='"+Valores[0]+"',"+Encabezados[1]+" = '"+Valores[1]+"',"+Encabezados[2]+" = '"+Valores[2]+"', "+Encabezados[3]+" = '"+Valores[3]+"',"+Encabezados[4]+" = '"+Valores[4]+"',"+Encabezados[5]+" = '"+Valores[5]+"' WHERE "+Encabezados[0]+" = "+elemento+";";
               break; 
           case 2:
               sentenciaSQL="UPDATE "+Tablas.Nombre_Tablas[NombreTabla-1]+" SET "+Encabezados[0]+" = '"+Valores[0]+"',"+Encabezados[1]+" = '"+Valores[1]+"', "+Encabezados[2]+" = '"+Valores[2]+"', "+Encabezados[3]+" = '"+Valores[3]+"',"+Encabezados[4]+" = '"+Valores[4]+"',"+Encabezados[5]+" = '"+Valores[5]+"' WHERE "+Encabezados[0]+" = "+elemento+";";
               break;
           case 3:
                sentenciaSQL="UPDATE "+Tablas.Nombre_Tablas[NombreTabla-1]+" SET "+Encabezados[0]+" = '"+Valores[0]+"',"+Encabezados[1]+" = '"+Valores[1]+"', "+Encabezados[2]+" = '"+Valores[2]+"', "+Encabezados[3]+" = '"+Valores[3]+"' WHERE "+Encabezados[0]+" = "+elemento+";";
               break;
           case 4:
               sentenciaSQL="UPDATE "+Tablas.Nombre_Tablas[NombreTabla-1]+" SET "+Encabezados[0]+" = '"+Valores[0]+"',"+Encabezados[1]+" = '"+Valores[1]+"', "+Encabezados[2]+" = '"+Valores[2]+"', "+Encabezados[3]+" = '"+Valores[3]+"' WHERE "+Encabezados[0]+" = "+elemento+";";
               break;
           case 5:
               sentenciaSQL="UPDATE "+Tablas.Nombre_Tablas[NombreTabla-1]+" SET "+Encabezados[0]+" = '"+Valores[0]+"',"+Encabezados[1]+" = '"+Valores[1]+"', "+Encabezados[2]+" = '"+Valores[2]+"', "+Encabezados[3]+" = '"+Valores[3]+"' WHERE "+Encabezados[0]+" = "+elemento+";";
               break;
           case 6:
              sentenciaSQL="UPDATE "+Tablas.Nombre_Tablas[NombreTabla-1]+" SET "+Encabezados[0]+" ='"+Valores[0]+"',"+Encabezados[1]+" = '"+Valores[1]+"',"+Encabezados[2]+" = '"+Valores[2]+"', "+Encabezados[3]+" = '"+Valores[3]+"',"+Encabezados[4]+" = '"+Valores[4]+"',"+Encabezados[5]+" = '"+Valores[5]+"',"+Encabezados[6]+" = '"+Valores[6]+"',"+Encabezados[7]+" = '"+Valores[7]+"',"+Encabezados[8]+" = '"+Valores[8]+"',"+Encabezados[9]+" = '"+Valores[9]+"',"+Encabezados[10]+" = '"+Valores[10]+"',"+Encabezados[11]+" = '"+Valores[11]+"' WHERE "+Encabezados[0]+" = "+elemento+";";
               break;
            case 7:
              sentenciaSQL="UPDATE "+Tablas.Nombre_Tablas[NombreTabla-1]+" SET "+Encabezados[0]+" ='"+Valores[0]+"',"+Encabezados[1]+" = '"+Valores[1]+"',"+Encabezados[2]+" = '"+Valores[2]+"', "+Encabezados[3]+" = '"+Valores[3]+"' WHERE "+Encabezados[0]+" = "+elemento+";";
               break;
        }
        sentencia.execute(sentenciaSQL); 

     }
     
     /*
      Este metodo se encarga de devolver los valores dentro de una consulta en MYSQL
      * Para utilizar este metodo se requiere declarar una variable tipo ResulSet la cual almacenara el resultado de la busqueda
      * y se debera utilizar un ciclo para obtener el contenido del ResultSet mediante el metodo next() y LOS metodos getStrin(NUMERO ENTERO QUE REPRESENTA EL NUMERO DE LA COLUMNA )
      *                                                                                                               getInt(),getDouble,getFloat(), segun lo requieran
      */                                                                                                                
    public ResultSet consultar(int NombreTabla, String columnas, String ElementoCoincidencia, String ElementoBusqueda) throws SQLException {//Este metodo Arroja una Excepcion de SQL por lo que cualquier otro metodo o clase que lo implemente debe capturar dicha Excepcion
     
        String sentenciaSQL = "SELECT " + columnas + " FROM " + Tablas.Nombre_Tablas[NombreTabla - 1] + "  WHERE " + ElementoCoincidencia + " LIKE '%" + ElementoBusqueda + "%'";
        resultado = sentencia.executeQuery(sentenciaSQL);
    
       
        return resultado;

        
    }
    
         /*
      Este metodo se encarga de devolver los valores dentro de una consulta en MYSQL
      * Para utilizar este metodo se requiere declarar una variable tipo ResulSet la cual almacenara el resultado de la busqueda
      * y se debera utilizar un ciclo para obtener el contenido del ResultSet mediante el metodo next() y LOS metodos getStrin(NUMERO ENTERO QUE REPRESENTA EL NUMERO DE LA COLUMNA )
      *                                                                                                               getInt(),getDouble,getFloat(), segun lo requieran
      */                                                                                                                
    public ResultSet consultar(int NombreTabla, String columnas, String ElementoCoincidencia, String ElementoBusqueda,int elemento2) throws SQLException {//Este metodo Arroja una Excepcion de SQL por lo que cualquier otro metodo o clase que lo implemente debe capturar dicha Excepcion
     
        String sentenciaSQL = "SELECT " + columnas + " FROM " + Tablas.Nombre_Tablas[NombreTabla - 1] + "  WHERE " + ElementoCoincidencia + " = '" + ElementoBusqueda + "'";
        resultado = sentencia.executeQuery(sentenciaSQL);
       
       
        return resultado;

        
    }
    
         /*
      Este metodo se encarga de devolver los valores que no se repiten en una columna en una tabla 
      * Para utilizar este metodo se requiere declarar una variable tipo ResulSet la cual almacenara el resultado de la busqueda
      * y se debera utilizar un ciclo para obtener el contenido del ResultSet mediante el metodo next() y LOS metodos getStrin(NUMERO ENTERO QUE REPRESENTA EL NUMERO DE LA COLUMNA )
      *                                                                                                               getInt(),getDouble,getFloat(), segun lo requieran
      */                                                                                                                
    public ResultSet consultar(int NombreTabla, String columnas) throws SQLException {//Este metodo Arroja una Excepcion de SQL por lo que cualquier otro metodo o clase que lo implemente debe capturar dicha Excepcion
     
        String sentenciaSQL = "SELECT DISTINCT " + columnas + " FROM " + Tablas.Nombre_Tablas[NombreTabla - 1] ;
        resultado = sentencia.executeQuery(sentenciaSQL);
  
       
        return resultado;

        
    }
    /*
     Este metodo se encarga de devolver todos los registros de una tabla en especifico
     *Para utilizar este metodo se requiere declarar una variable tipo ResulSet la cual almacenara el resultado de la busqueda
     *  y se debera utilizar un ciclo para obtener el contenido del ResultSet mediante el metodo next() y LOS metodos getStrin(NUMERO ENTERO QUE REPRESENTA EL NUMERO DE LA COLUMNA )
      * Los parametors que recibe son                                                                                                              getInt(),getDouble,getFloat(), segun lo requieran
     * int NombreTabla: este valor hacer referencia a la poscion en un arreglo que contiene el nombre de cada una de las tablas de la base de datos
     */
    public ResultSet consultar(int NombreTabla) throws SQLException{
        resultado = sentencia.executeQuery("SELECT * FROM "+Tablas.Nombre_Tablas[NombreTabla-1]);
    
        return resultado;
    }
    /*
     * Este metodo se encarga de cerrar la conexion y la sentencia, debe ser invocado cada vez que se salga de algun modulo que implemente los metodos de esta clase
     * para asegurarnos que las conexiones se cierren correctamente
     */
    public void cerrarConexion(){
        try {
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al Cerrar las conexiones con el manejador MySQL");
        }
    
    }
    
   
    
    public void conectarMySQL2(){
    
    }  
    
}

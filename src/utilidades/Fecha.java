
package utilidades;
import java.util.Calendar;
public class Fecha {
   static Calendar fecha=Calendar.getInstance();
    public static String getDia(){
        return  Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
    }
    
    public static String getMes(){
        String mes="";
         
         switch (fecha.get(Calendar.MONTH)+1) {
            case 1:
                 mes="Enero";
                break;
            case 2:
                mes="Febrero";
                break;
            case 3:
                mes="Marzo";
                break;
            case 4:
                mes="Abril";
                break;
            case 5:
                mes="Mayo";
                break;
            case 6:
                mes="Junio";
                break;
            case 7: 
                mes="Julio";
                break;
            case 8:
                mes="Agosto";
                break;
            case 9:
                mes="Septiembre";
                break;
            case 10:
                mes="Octubre";
                break;
            case 11:
                mes="Noviembre";
                break;
            case 12:
                mes="Diciembre";
                break;
             }
         return mes;
    }
    
    public static String getAño(){
        return Integer.toString(fecha.get(Calendar.YEAR));
    }
}

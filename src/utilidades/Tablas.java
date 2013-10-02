
package utilidades;

public class Tablas {
    public static String Nombre_Tablas[]={"articulos","enc_compras","det_compras","enc_ventas","det_ventas","proveedores","cuentas_pagar"};
    //El campo Tipo_A debe ser cambiado a como dijo la maestra
    // 1
    public static String articulos[]={"Clave_A","Nombre_A","Tipo_A","Existencia","Costo_Compra","Costo_Venta"};
    // 2
    public static String enc_compras[]={"Folio_C","ID_Pro","Dia_C","Mes_C","Año_C","Total_Compra"};
    // 3
    public static String det_compras[]={"Folio_C","Clave_A","Cantidad_A","Total_C"};
    // 4
    public static String enc_ventas[]={"Folio_V","Dia_V","Mes_V","Año_V"};
    //5
    public static String det_ventas[]={"Folio_V","Clave_A","Cantidad_A","Total_A"};
    //6
    public static String proveedores[]={"ID_Pro","Nom_Pro","TelP_Pro","TelCel_Pro","Calle_Pro","NI_Pro","NE_Pro","Colonia_Pro","Ciudad_Pro","CP_Pro","Email_Pro","Web_Pro"};                   
    //7
    public static String cuentas_pagar[]={"Folio_C","Fecha_C","Proveedor","Total"};
    /*
     * Este metodo es utilizado para obtener los encabezados de una tabla en especifico
     * Recibe como argumento el numero asociado a la tabla, tal y como se describe en la parte de arriba
     */
    public static String [] devuelveEncabezados(int numTabla){
        String [] aux={};
       switch(numTabla){
           case 1:
               aux=articulos;
               break;
           case 2:
               aux=enc_compras;
               break;
           case 3:
               aux=det_compras;
               break;
           case 4:
               aux=enc_ventas;
               break;
           case 5:
               aux=det_ventas;
               break;
           case 6:
               aux=proveedores;
               break;
           case 7:
               aux=cuentas_pagar;
               break;
       }
       return aux;
    }
}

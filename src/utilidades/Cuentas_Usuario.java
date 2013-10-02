
package utilidades;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cuentas_Usuario {
    
    static LineNumberReader ArchivoEntrada;
    static PrintWriter ArchivoSalida;

    /*
     Este metodo se encarga de encriptar el nombre de usuario y la contraseña para despues guardarlo en un archivo .pswd
     */
    public static boolean encriptarDatos(String usr,String pass){
        byte usr1[];        //
        byte pass1[];       //Arreglos de tipo byte usados para obtener los valores numericos de cada letra perteneciente al nombre de usuario y contraseña
        byte usr2[];        //  
        byte pass2[];       //
        int control=0,posicion=0;;     //Variable auxiliar para determinar que valor se asignara en el nuevo arreglo tipo byte          
        usr1=usr.getBytes();    //Obtener el valor en tipo byte de cada una de las letras y almacenarlo en un arreglo byte
        pass1=pass.getBytes();
        usr2=new byte[usr1.length+10];
        pass2=new byte[pass1.length+10];
        boolean res=false;
        boolean existe=buscarUsuario(usr, pass);
        if(existe==false){
        for (int i = 0; i < usr2.length; i++) {
            
            if (control<=4) {
                usr2[i]=(byte)(Math.round(Math.random() * (127-33))+ 33) ;  //Este ciclo se encarga de generar el segundo arreglo de bytes
                control+=1;                                                 //generarndo valores aleatorios en las primeras 5 y ultimas 5 pociciones
            }                                                               //del arreglo y los valores del arreglo original sufren un pekeño cambio   
            else{                                                           //al cambiar su valor en +4 o -14 segun su pocicion
                if((posicion%2)!=0){
                usr2[i]=(byte) (usr1[posicion]-14);   
                }
                else
                 usr2[i]=(byte) (usr1[posicion]+3);   
                posicion+=1;
                if(posicion==usr1.length){
                control=0;
                }
            }
           
        }
         control=0;
            posicion=0;
         for (int i = 0; i < pass2.length; i++) {
            
            if (control<=4) {
                pass2[i]=(byte)(Math.round(Math.random() * (127-33))+ 33) ;
                control+=1;
            }
            else{
                if((posicion%2)!=0){
                pass2[i]=(byte) (pass1[posicion]-14);   
                posicion+=1;
                }
                else{
                  
                 pass2[i]=(byte) (pass1[posicion]+3);   
                posicion+=1;
                }
                if(posicion==pass1.length){
                control=0;
                }
            }
        }
         try {
          
             ArchivoSalida=new PrintWriter(new FileWriter("cuentas.pwd",true));   //Generamos el archivo donde se guardaran las contraseñas 
             ArchivoSalida.println(new String(usr2)+" "+new String(pass2));        //Escribe el usuario y contraseña encriptados dentro del archivo
             ArchivoSalida.flush();
             ArchivoSalida.close();
             res=false;
             
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error al escribir en el archivo");
        }
        }
        else{
        res=true;
         JOptionPane.showMessageDialog(null, "Este Usuario ya existe","Error",2);  
        }
     

        return res;
    }
    
    public static  boolean buscarUsuario(String usr,String pass){
        String linea;
        String datos[];
        String usrpass[];
        boolean verificacion=false;
        try {
            
            ArchivoEntrada= new LineNumberReader(new FileReader("cuentas.pwd"));
            linea=ArchivoEntrada.readLine();
            while(linea!=null){
                datos=linea.split(" ");   
                usrpass=desencripta(datos[0],datos[1]);
//                System.out.println(usrpass[0]+" "+usrpass[1]);
                if(usrpass[0].equals(usr)&&usrpass[1].equals(pass))
                {   verificacion=true;
                    break;
                }
                else{
                    verificacion=false;
                linea=ArchivoEntrada.readLine();
                }
            }
            
            ArchivoEntrada.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cuentas_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException e){
        
        }
        
        return verificacion;
    
    }
    
    public static String [] desencripta(String usr,String pass){
        int control=0,posicion=0;
        String datos[]= new String[2];
        byte usr1[]=usr.getBytes();
        byte pass1[]=pass.getBytes();
        byte usr2[] =new byte[usr1.length-10];
        byte pass2[] =new byte[pass1.length-10];
        
           for (int i = 0; i < usr1.length; i++) {
            
            if (control<=4) {
               
                control+=1;
            }
            else{
                if((posicion%2)!=0){
                usr2[posicion]=(byte) (usr1[i]+14);
                posicion+=1;
                }
                else{
                 usr2[posicion]=(byte) (usr1[i]-3);   
                posicion+=1;
                }
                if(posicion==usr2.length){
                control=0;
                }
            }
        }
           control=0;
           posicion=0;
           for (int i = 0; i < pass1.length; i++) {
            
            if (control<=4) {
               
                control+=1;
            }
            else{
                if((posicion%2)!=0){
                pass2[posicion]=(byte) (pass1[i]+14); 
                 posicion+=1;
                }
                else{
                 pass2[posicion]=(byte) (pass1[i]-3);   
                posicion+=1;
                }
                if(posicion==pass2.length){
                control=0;
                }
            }
        }
        datos[0]=new String (usr2);
        datos[1]=new String (pass2);
        return datos;
    
    }
}

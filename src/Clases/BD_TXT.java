//Esta clase sera para guardar los objetos en listas y creart bitacoras 
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class BD_TXT {
    public static int indicebuscado=-1; //<--- Este cambiara para saber el indice a buscar 
    public static int index=0; //<--incrementa +1
    public static ArrayList<Usuario> UsuariosDB=new ArrayList();//<-- aqui se guardara cada instancia usuario guardada 
    public static ArrayList<Login> LoginDB=new ArrayList();//<-- aqui se guardara cada instancia login guardada 
    
    //--->manejo de bitacora
    //--->manejo de incidentes
    
    public BD_TXT() {
    }
  
    
    public void addUsuariosDB(Usuario usuario) {
        UsuariosDB.add(usuario);
    }
    
    public void addLoginDB(Usuario usuario) {
        UsuariosDB.add(usuario);
    } 
    //Metodo Personalizado Buscar Usuario
    
    public int buscarUsuario(String Usuario){
        int index=-1;
        for (int i=0;i<LoginDB.size();i++){
            if (LoginDB.get(i).getUsuario().equals(Usuario)){
                return i;
             }
          }
        return index;
    }
    
       public int buscarNombre(String Nombre){
        int index=-1;
        for (int i=0;i<LoginDB.size();i++){
            if (UsuariosDB.get(i).getNombre().equals(Nombre)){
                return i;
             }
          }
        return index;
    }
    
// Crear txt para bitacora Incidentes y escribir
       public void bitacoraTXT(int tipoError){
           Date fecha=new Date();
           String errorRegistrar ="";
           
           switch (tipoError){
               //<---------------errores de login
               case 1:
                   errorRegistrar="Intento de ingresar al login con usuario inexistente  || Fecha y Hora: "+fecha;
               break;
                case 2:
                   errorRegistrar="Contraseña erronea para Usuario  "+UsuariosDB.get(indicebuscado).getUsuario()+" Nombre de Usuario: "+UsuariosDB.get(indicebuscado).getNombre()+" || Fecha y Hora: "+fecha;
               break;
        
               //<-------------errores al ingresar un usuario incorrecto
                case 3:
                   errorRegistrar="Intento fallido de ingresar usuario con espacio vacio  || Fecha y Hora: "+fecha;
                 break;                 
                case 4:
                   errorRegistrar="Intento fallido de ingresar usuario, No hay suficientes digitos en el numero de identidad  || Fecha y Hora: "+fecha;
                 break;
                case 5:
                  errorRegistrar="intento de ingresar un monto negativo al ingresar cuenta  || Fecha y Hora: "+fecha;
                break;
                //<-------------errores al iingresar transacciones incorrectas
                case 6:
                  errorRegistrar="El usuario "+UsuariosDB.get(indicebuscado).getUsuario()+" Nombre de Usuario: "+UsuariosDB.get(indicebuscado).getNombre()+ " Trato de realizar un un retiro mayor a su saldo  || Fecha y Hora: "+fecha;
                break;          
                case 7:
                  errorRegistrar="El usuario "+UsuariosDB.get(indicebuscado).getUsuario()+" Nombre de Usuario: "+UsuariosDB.get(indicebuscado).getNombre()+ " Trato de realizar un una transferencia a un usuario inexistente || Fecha y Hora: "+fecha;
                break;   
                case 8:
                  errorRegistrar="El usuario "+UsuariosDB.get(indicebuscado).getUsuario()+" Nombre de Usuario: "+UsuariosDB.get(indicebuscado).getNombre()+ " Intento realizar una gestion ingresando un espacio Vacio  || Fecha y Hora: "+fecha;
                break;    
                //<------------------------dolares Y euros 
                case 9:
                  errorRegistrar="Error al ingresar Monto en dolares al ingresar usuario   || Fecha y Hora: "+fecha;
                break;    
                case 10:
                  errorRegistrar="Error al ingresar Monto en euros al ingresar usuario   || Fecha y Hora: "+fecha;
                break;    
                case 11:
                  errorRegistrar="El usuario "+UsuariosDB.get(indicebuscado).getUsuario()+" Nombre de Usuario: "+UsuariosDB.get(indicebuscado).getNombre()+ " Intento realizar Compra/vento de Divisa ingresando un espacio Vacio  || Fecha y Hora: "+fecha;
                break;    
                case 12: 
                    errorRegistrar="El usuario "+UsuariosDB.get(indicebuscado).getUsuario()+" Nombre de Usuario: "+UsuariosDB.get(indicebuscado).getNombre()+ " Trato de realizar un Cambio de divisas con fondos insuficientes || Fecha y Hora: "+fecha;
                 break;
                case 13: 
                    errorRegistrar="El usuario "+UsuariosDB.get(indicebuscado).getUsuario()+" Nombre de Usuario: "+UsuariosDB.get(indicebuscado).getNombre()+ " ingreso un espacio vacio cuando trato de hacer un cambio de divisas || Fecha y Hora: "+fecha;
                 break;
                
                
           }
           //<-------------------------------------------ingresar infdormacion a bitacora
         File archivo;
         archivo = new File("BitacoraDeErrores.txt");
        
                try
                {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
                    escritor.write(errorRegistrar);
                    escritor.newLine();
                    escritor.close();
                
                }catch (IOException e){
                    e.printStackTrace();
                }
           
       }
       
       
  // Crear txt para bitacora transacciones  
    public void bitacoraTransaccionTXT(int opcion, String Nombre, double Monto ,  String PersonaInvolucrada){
           Date fecha=new Date();
           String errorRegistrar ="";
           
           switch (opcion){
               //<---------------Deposito
               case 1:
                   errorRegistrar="Deposito a: "+Nombre +"|| Valor de LPS "+ String.valueOf(Monto)+ " || Fecha y Hora: "+fecha;
               break;
               //<---------------Retiro
                case 2:
                   errorRegistrar="Retiro a: "+Nombre +"||Valor de LPS -"+ String.valueOf(Monto)+ " || Fecha y Hora: "+fecha;
               break;
                //<---------------transferencia
                case 3:
                   errorRegistrar="Transferencia desde : "+Nombre +" ||Valor de LPS "+ String.valueOf(Monto)+ " a la cuenta "+PersonaInvolucrada+" || Fecha y Hora: "+fecha;
                 break;           
                //<----------------------------------internacionel
                //<---dolares
                case 4:
                   errorRegistrar="Cambio de divisa por parte de: "+Nombre +" ||Dolares agregados "+ String.valueOf(Monto)+fecha;
                break;
                case 5:
                   errorRegistrar="Cambio de divisa por parte de: "+Nombre +" ||Lempiras Debitados "+ String.valueOf(Monto)+fecha;
                break;
                //<----Euros

           }
           //<-------------------------------------------ingresar infdormacion a bitacora
         File archivo;
         archivo = new File("BitacoraDeTransacciones.txt");
        
                try
                {
                    BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
                    escritor.write(errorRegistrar);
                    escritor.newLine();
                    escritor.close();
                
                }catch (IOException e){
                    e.printStackTrace();
                }
           
       }
       
       
       
       
}

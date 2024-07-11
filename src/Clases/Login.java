//Esta clase se usa solo para  validaciones en login
package Clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends ClasePadreCuenta {
    private String Contrasena;
    
    //constructor
    public Login(String Contrasena, int index, String Usuario) {
        super(index, Usuario);
        this.Contrasena = Contrasena;
    }

    public Login() {
    }
   
    
    //Getters and setters
//    public String getContrasena() {return Contrasena;}
    public void setContrasena(String Contrasena) {
        this.Contrasena = encriptar(Contrasena);
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    //Metodo Personalizado
            //Metodos Personalizado incriptar Sha
            private String encriptar(String texto) {
                String hashTexto = ""; // Guarda el texto
                hashTexto = SHA256(texto);
                return hashTexto;
            }
            private String SHA256(String contrasena) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    byte[] hash = md.digest(contrasena.getBytes());
                    StringBuilder hexString = new StringBuilder();
                    for (byte b : hash) {
                        hexString.append(String.format("%02x", b));
                    }
                    return hexString.toString();
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }
            //Validar 
            public boolean validarContrasena(String contrasena) {
                String hashContrasena="";
                boolean bandera =false;
                hashContrasena=SHA256(contrasena);

                if (this.Contrasena.equals(hashContrasena)){
                    bandera=true;
                }
                return bandera;
            }
            //
}

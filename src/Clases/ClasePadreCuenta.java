//No se usa la clase , solo para heredar atributos
package Clases;

public class ClasePadreCuenta {
    //atributos
    protected int index; //este es para identificar la cuenta
    protected String Usuario;
    protected String Nombre ;
    protected String Apellido;
    protected String NumeroDeIdentificacion;
    protected int edad;

  //constructors
    public ClasePadreCuenta(int index, String Usuario, String Nombre, String Apellido, String NumeroDeIdentificacion, int edad) {
        this.index = index;
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.NumeroDeIdentificacion = NumeroDeIdentificacion;
        this.edad = edad;
    }
    public ClasePadreCuenta() {
    }
    public ClasePadreCuenta(int index, String Usuario) {
        this.index = index;
        this.Usuario = Usuario;
    }//<---constructor solo para Login
    
    
//    getter and setters
    public int getIndex() {return index;}
    public void setIndex(int index) {this.index = index;}
    public String getNombre() {return Nombre;}
    public void setNombre(String Nombre) {this.Nombre = Nombre;}
    public String getApellido() {return Apellido;}
    public void setApellido(String Apellido) {this.Apellido = Apellido;}
    public String getNumeroDeIdentificacion() {return NumeroDeIdentificacion;}
    public void setNumeroDeIdentificacion(String NumeroDeIdentificacion) {this.NumeroDeIdentificacion = NumeroDeIdentificacion;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

}



package Clases;
public class Usuario extends ClasePadreCuenta {
    private int Fila=0;
    private double MontoEnCuenta ;
    private String [][]Registrostransaccion= new String [30][4]; //Columnas: Cuenta actual, Cuanta involucrada, Moito ,Tipo de transaccion;
    private String Sucursal;
    
    private double MontoEnDolares;
    private double MontoEnEuros;
    
    //constructores <----no incluye Registrostransaccion por que no tendria sentido ingresar todos los registros 
    public Usuario(double MontoEnCuenta, String Sucursal, int index, String Usuario, String Nombre, String Apellido, String NumeroDeIdentificacion, int edad,double MontoEnDolares, double MontoEnEuros) {
        super(index, Usuario, Nombre, Apellido, NumeroDeIdentificacion, edad);
        this.MontoEnCuenta = MontoEnCuenta;
        this.Sucursal = Sucursal;
        
        this.MontoEnDolares=MontoEnDolares;
        this.MontoEnEuros=MontoEnEuros;
    }
    public Usuario() {
    }
    
    //personalizado
    public void addRegistrostransaccion(String Cuentaactual, String Cuantainvolucrada, double Monto ,String Tipodetransaccion){
        this.Registrostransaccion[this.Fila][0]=Cuentaactual;
        this.Registrostransaccion[this.Fila][1]=Cuantainvolucrada;
        this.Registrostransaccion[this.Fila][2]=String.valueOf(Monto);
        this.Registrostransaccion[this.Fila][3]=Tipodetransaccion;
        Fila++;
    }//<-------agrega la transaccion
    
    public void retiro(double montoretiro){
        this.MontoEnCuenta=this.MontoEnCuenta-montoretiro;
    }
    
    public void deposito(double montoretiro){
        this.MontoEnCuenta=this.MontoEnCuenta+montoretiro;
    }
    

    //Getter and setter
    public double getMontoEnCuenta() {
        return MontoEnCuenta;
    }
    public void setMontoEnCuenta(double MontoEnCuenta) {
        this.MontoEnCuenta = MontoEnCuenta;
    }
    public String[][] getRegistrostransaccion() {
        return Registrostransaccion;
    }
    public void setRegistrostransaccion(String[][] Registrostransaccion) {
        this.Registrostransaccion = Registrostransaccion;
    }
    public String getSucursal() {
        return Sucursal;
    }
    public void setSucursal(String Sucursal) {
        this.Sucursal = Sucursal;
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
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public String getNumeroDeIdentificacion() {
        return NumeroDeIdentificacion;
    }
    public void setNumeroDeIdentificacion(String NumeroDeIdentificacion) {
        this.NumeroDeIdentificacion = NumeroDeIdentificacion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Dolares y Euros
    public double getMontoEnDolares() {
        return MontoEnDolares;
    }

    public void setMontoEnDolares(double MontoEnDolares) {
        this.MontoEnDolares = MontoEnDolares;
    }

    public double getMontoEnEuros() {
        return MontoEnEuros;
    }

    public void setMontoEnEuros(double MontoEnEuros) {
        this.MontoEnEuros = MontoEnEuros;
    }
    
    
}

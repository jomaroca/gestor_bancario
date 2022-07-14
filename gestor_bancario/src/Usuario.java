
public class Usuario {
	String nombre;
    String dni;
    int edad;
 
    public Usuario() { 
        this.nombre="";
        this.dni="";
        this.edad=0;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public void setEdad(int edad) {
        this.edad = edad;
    }
     
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public boolean setDNI(String dni){
         
        if(dni.matches("^[0-9]{8}[a-zA-Z]$")
                || dni.matches("^[0-9]{8}[-][a-zA-Z]$")){
            this.dni=dni;
            return true;
        }
        else{
            return false;
        }      
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public String getDni() {
        return dni;
    }
 
    public int getEdad() {
        return edad;
    }
 
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ".\n" +
                "DNI: " + this.dni + ".\n" +
                "Edad: " + this.edad + ".";
    }
}

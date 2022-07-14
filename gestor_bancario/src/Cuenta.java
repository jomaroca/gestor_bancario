import java.util.*;

public class Cuenta {

	private double saldo;
    private Usuario usuarioCuenta;
    private List<Gasto> gastos;
    private List<Ingreso>ingresos;
 
    public Cuenta(Usuario usuarioCuenta) {
        this.usuarioCuenta=usuarioCuenta;
        this.saldo=0;
        this.gastos=new ArrayList<Gasto>();
        this.ingresos=new ArrayList<Ingreso>();
    }
 
    public void setUsuarioCuenta(Usuario usuarioCuenta) {
        this.usuarioCuenta = usuarioCuenta;
    }
 
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getSaldo() {
        return saldo;
    }
  
    public Usuario getUsuarioCuenta() {
        return usuarioCuenta;
    }
    
    public List<Gasto> getGastos() {
        return gastos;
    }
   
    public List<Ingreso> getIngresos() {
        return ingresos;
    }
    
    public double addIngresos(String description, double cantidad){
       
        Ingreso nuevoIngreso = new Ingreso(cantidad,description);
        this.ingresos.add(nuevoIngreso);
        this.saldo=this.saldo+cantidad;
        return saldo;
    }
     
    public double addGastos(String description, double cantidad){
         
        try{
            this.saldo = this.saldo-cantidad;
             
            if(this.getSaldo()<0){
                throw new GastoException();
            }
        }catch(GastoException e){
            return -1;
        }
        Gasto nuevoGasto=new Gasto(cantidad,description);
        gastos.add(nuevoGasto);
        return saldo;
    }
     
    @Override
    public String toString(){
        return "Hola " + this.usuarioCuenta.getNombre() + ", el saldo de tu "
                + "cuenta es " + this.saldo;
    }
}

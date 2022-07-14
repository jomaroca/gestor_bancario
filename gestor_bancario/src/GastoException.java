
public class GastoException extends Exception {

    private String error="";
    public GastoException() {
        this.error="No se puede agregar el gasto ya que el saldo es menor que "
                + "el importe del gasto, o su saldo es cero euros.";
    }
     
    @Override
    public String getMessage(){
        return error;
    }    
}
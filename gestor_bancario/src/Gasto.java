
public class Gasto extends Dinero {
	
	public Gasto(double gasto, String description) {
        this.dinero=gasto;
        this.description=description;
    }
 
    @Override
    public String toString() {
        return "Gasto en concepto de " + this.description
                + ". Importe total: " + this.dinero ;
    }  
}
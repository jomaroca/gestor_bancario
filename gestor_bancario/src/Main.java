import java.util.Scanner;

public class Main {

    private static final Scanner lectura = new Scanner(System.in);
 
    private static String opcion = "";
 
    private static byte numeroOpcion= -1;
 
    private static Usuario nuevoUsuario = new Usuario();
 
    private static String nombreUsuario="";
 
    private static String edadUsu="";
  
    private static byte edadUsuario=-1;
 
    private static String dniUsuario="";
 
    private static boolean usuarioCreado=false;
 
    private static Cuenta nuevaCuenta = null;
  
    private static String importe="";
 
    private static double importeTotal=0;
  
    private static String descripcion="";
 
    private static void mostrarMenu(){
        
        do{
        System.out.println("Realiza una nueva acción");	
        System.out.println("1 Introduce un nuevo gasto");
        System.out.println("2 Introduce un nuevo ingreso");
        System.out.println("3 Mostrar gastos");
        System.out.println("4 Mostrar ingresos");
        System.out.println("5 Mostrar saldo");
        System.out.println("0 Salir");
        
        try{
        
            

            opcion = lectura.nextLine();
      
            numeroOpcion = Byte.parseByte(opcion);
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("La opción elegida debe ser un número "
                    + "entre 0 y 5");
        }
        }while(numeroOpcion<0 && numeroOpcion>5);
    }
   
    private static void pedirDatosUsuario(){
        usuarioCreado=false;
       
        do{
            System.out.println("Introduce el nombre de usuario");
            nombreUsuario=lectura.nextLine().toUpperCase();
        }while(nombreUsuario.isEmpty());
        nuevoUsuario.setNombre(nombreUsuario);
      
        do{
            System.out.println("Introduce la edad del usuario");
            edadUsu=lectura.nextLine();
          
            try{
                edadUsuario = Byte.parseByte(edadUsu);
                nuevoUsuario.setEdad(edadUsuario);
            }catch(NumberFormatException e){
                System.out.println("La edad debe numérica y mayor que cero");
            }
        }while(edadUsu.isEmpty() || edadUsuario<=0);
        
    
        do{
            System.out.println("Introduce el DNI del usuario");
            dniUsuario=lectura.nextLine().toUpperCase();
        
            if(nuevoUsuario.setDNI(dniUsuario)){
                nuevoUsuario.setDNI(dniUsuario);
            }
            else{
                System.out.println("El DNI introducido no es correcto."
                        + "Vuelva a introducir el DNI");
            }
        }while(dniUsuario.isEmpty() || nuevoUsuario.setDNI(dniUsuario)==false);
     
        usuarioCreado=true;
    }
   
    private static void introducirIngresos(){
     
        importe="";
        descripcion="";
        importeTotal=0;
     
        do{
            System.out.print("Introduce el concepto del ingreso: ");
            descripcion = lectura.nextLine();
            
        }while(descripcion.isEmpty());
      
        do{
            System.out.print("Introduce el importe del ingreso: ");
            importe = lectura.nextLine();
            
            try{
                importeTotal=Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println("El importe del ingreso debe ser numérico +"
                        + e.getMessage());
            }
        }while(importe.isEmpty());
       
        nuevaCuenta.addIngresos(descripcion, importeTotal);
      
        System.out.println("Ingreso registrado correctamente");
    }
  
    private static void introducirGastos(){
     
        importe="";
        descripcion="";
        importeTotal=0;
        
        do{
            System.out.print("Introduce el concepto del gasto: ");
            descripcion = lectura.nextLine();
            
        }while(descripcion.isEmpty());
      
        do{
            System.out.print("Introduce el importe del gasto: ");
            importe = lectura.nextLine();
            
            try{
                importeTotal=Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println("El importe del ingreso debe ser numérico +"
                        + e.getMessage());
            } 
        }while(importe.isEmpty());
   
        if(nuevaCuenta.getSaldo()<importeTotal || nuevaCuenta.getSaldo()==0){
    
            System.out.println("Debes realizar primero un ingreso para "
                    + "registrar un gasto");
        }
        else{
      
            nuevaCuenta.addGastos(descripcion, importeTotal);

            System.out.println("Gasto registrado correctamente.");  
        }
    }

    private static void mostrarGastos(){
      
       if(!nuevaCuenta.getGastos().isEmpty()){
          
           for(int x=0;x<nuevaCuenta.getGastos().size();x++){
               System.out.println(nuevaCuenta.getGastos().get(x).toString());
           }
       }
       else{
           System.out.println("No existen gastos en esta cuenta.");
       }
    }
   
    private static void mostrarIngresos(){
    
       if(!nuevaCuenta.getIngresos().isEmpty()){
          
           for(int x=0;x<nuevaCuenta.getIngresos().size();x++){
               System.out.println(nuevaCuenta.getIngresos().get(x).toString());
           }
       }
       else{
           System.out.println("No existen gastos en esta cuenta.");
       }
    }
   
    public static void main(String[] args) {
     
        do{
           pedirDatosUsuario();
       }while(usuarioCreado=false);
     
        System.out.println("Datos del nuevo usuario:");
        System.out.println(nuevoUsuario.toString());
      
        nuevaCuenta=new Cuenta(nuevoUsuario);
     
        do{ 
            
            mostrarMenu();

            switch(numeroOpcion){

                case 0:
                    System.out.println("Fin del programa. "
                            + "Gracias por utilizar la aplicación.");
                    break;

                case 1:
                    introducirGastos();
                    break;

                case 2:
                    introducirIngresos();
                    break;

                case 3:
                    mostrarGastos();
                    break;

                case 4:
                        mostrarIngresos();
                    break;

                case 5:
                    System.out.println(nuevaCuenta.toString());
                    break;

                default:

                    System.out.println("Introduce el valor correcto");
                    break;
            }

        }while(numeroOpcion !=0);
     
        lectura.close();
    }
}

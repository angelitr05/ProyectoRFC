package RFC;
import java.util.Scanner;
public class principal {
    public static void main(String[] args) {
        //Programa para identificar RFC
        Scanner leer=new Scanner(System.in);
        Metodos ob=new Metodos();
        int tb=0;
        //ingreso de RFC
        System.out.print("Ingrese RFC:");
        String rfc=leer.nextLine();
        String trfc[]=rfc.toUpperCase().split("");
        if(trfc.length==13){
            for (int i = 0; i < trfc.length; i++) {
                if(trfc[i].equals(" ")){
                    tb++;
                }
            }
            if(tb==0){
                //Verificación de las primeras 4 letras del RFC
                ob.VerificacionLetras(trfc);
                System.out.println(rfc.toUpperCase());
            }else{
                System.out.println("\033[43mLo siento tu RFC cuenta con "+tb+" espacio en blanco");
                System.out.println("\033[43m*****Porfavor ingresa la cadena sin espacios*****");
            }
        }else{
            System.out.println("\033[43mTú RFC no cumple con los 13 caracteres requeridos");
             for (int i = 0; i < trfc.length; i++) {
                if(trfc[i].equals(" ")){
                    tb++;
                }
            }
            if(tb>0){
                System.out.println("\033[43mCuenta con "+tb+" espacio en blanco");
                System.out.println("\033[43m*****Porfavor ingresa la cadena sin espacios*****");
            }
        }
    }
    
}

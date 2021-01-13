package RFC;
import java.util.Scanner;
public class principal {
    public static void main(String[] args) {
        //Programa que simula lo que hace la Expresiones regulares para identificar RFC de 13 caracteres de una persona fisica
        Scanner leer=new Scanner(System.in);
        //objeto creado 
        Metodos ob=new Metodos();
        //Validador de longitud del rfc
        int tb=0;
        //ingreso de RFC
        System.out.print("Ingrese RFC:");
        //lee el rfc
        String rfc=leer.nextLine();
        //aqui separamos la cadena por caracter como lo haria una ER
        //también colocamos la cadena en mayuscula por si el usuario la ingreso en minuscula
        String trfc[]=rfc.toUpperCase().split("");
        //si el la longitud de caracteres de la cadena que es el RFC es de 13 entrara al if 
        if(trfc.length==13){
            //en este for buscara si no hay un espacio en la cadena que lo este contando como un caracter
            for (int i = 0; i < trfc.length; i++) {
                if(trfc[i].equals(" ")){
                    tb++;
                }
            }
            //si la cadena cuenta con 13 caracteres sin ningun espacio entre ello pasara a validar cada caracter este en su pocision correcta
            if(tb==0){
                //Primero mandaremos el RFC separado en caracteres a un metod que validara las primeras letras
                //Verificación de las primeras 4 letras del RFC
                ob.VerificacionLetras(trfc);
                //imprime el rfc en mayuscula
                System.out.println(rfc.toUpperCase());
            }else{
                //imprime un error de que se encuentra un espacio en blanco en el RFC
                System.out.println("\033[43mLo siento tu RFC cuenta con "+tb+" espacio en blanco");
                System.out.println("\033[43m*****Porfavor ingresa la cadena sin espacios*****");
            }
        //Si el RFC no cumple con los 13 caracteres requeridos    
        }else{
            //imprime un error de que la cadena no cumple con la longitud de caracteres
            System.out.println("\033[43mTú RFC no cumple con los 13 caracteres requeridos");
            //verifica si no hay un espacio en blanco en el RFC
             for (int i = 0; i < trfc.length; i++) {
                if(trfc[i].equals(" ")){
                    tb++;
                }
            }
            if(tb>0){
                //Si hay un espacio en blanco imprimira un error
                System.out.println("\033[43mCuenta con "+tb+" espacio en blanco");
                System.out.println("\033[43m*****Porfavor ingresa la cadena sin espacios*****");
            }
        }
    }
    
}

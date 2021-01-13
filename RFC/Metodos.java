package RFC;
//la clase de metodos donde se verificara el rfc
public class Metodos {
//En este metodo se verificara que los primeros cuatro caracteres sean letra de la A-Z
    public void VerificacionLetras(String rfc[]) {
        int vl = 0;
        //letras con las que comparara los primeros 4 caracteres
        String abecedari = "ABCDEFGHIJKLNMÑOPQRSTUVWXYZ";
        String tabc[] = abecedari.split("");
        //En este for recorrera las letras del abecedario comparando si el primer caracter del RFC es igual a una de ellas
        for (int i = 0; i < tabc.length; i++) {
            //si una de las letras es igual al primer caracter se terminara el for y pasara a validar el seguiente caracter
            if (rfc[0].equals(tabc[i])) {
                i = 26;
                //este valor va aumentando para que vaya sucecivamente la validación de caracteres
                vl++;
            }
        }
        //if el primer caracter del RFC es igual al de una letra entonces entrara al if
        if (vl != 0) {
            //hara el mismo proceso de validación y mientras sea igual pasara al siguiente caracter del rfc
            for (int i = 0; i < tabc.length; i++) {
                if (rfc[1].equals(tabc[i])) {
                    i = 26;
                    vl++;
                }
            }
            if (vl != 1) {
                for (int i = 0; i < tabc.length; i++) {
                    if (rfc[2].equals(tabc[i])) {
                        i = 26;
                        vl++;
                    }
                }
                if (vl != 2) {
                    for (int i = 0; i < tabc.length; i++) {
                        if (rfc[3].equals(tabc[i])) {
                            i = 26;
                            vl++;
                        }
                    }
                    //en este if entra porque ya se validaron los primeros cuatro caracteres del RFC y eso quiere decir que son correctos
                    if (vl != 3) {
                        //Aqui le envia los caracteres del rfc para que siga con la validación
                        //Verificar Año
                        verificarAno(rfc);
                    } else {
                        System.out.println("\033[41mEl RFC no es valido");
                    }
                } else {
                    System.out.println("\033[41mEl RFC no es valido");
                }
            } else {
                //Si el caracter no es igual se termina el programa y desde aqui marca que ya no es valido
                System.out.println("\033[41mEl RFC no es valido");
            }
        //si la primera letra del RFC no es igual entonces se terminara el metodo y el RFC no es valido
        } else {
            System.out.println("\033[41mEl RFC no es valido");
        }
    }
    //Validación del año es el mismo proceso que validar los primero 4 caracteres pero aqui se validara los siguientes caracteres que sigue con numeros
    public void verificarAno(String rfc[]) {
        int vn = 0;
        String numeros = "1234567890";
        String tnum[] = numeros.split("");
        for (int i = 0; i < tnum.length; i++) {
            if (rfc[4].equals(tnum[i])) {
                i = 9;
                vn++;
            }
        }
        if (vn != 0) {
            for (int i = 0; i < tnum.length; i++) {
                if (rfc[5].equals(tnum[i])) {
                    i = 9;
                    vn++;
                }
            }
            if (vn != 1) {
                //silos caracteres fueron correctos validara los siguientes que esos representan el Mes
                //Verificador de Mes
                verificarMes(rfc);
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
        } else {
            System.out.println("\033[41mEl RFC no es valido");
        }
    }
    //Verifica el mes con los siguiente caracteres que siguen
    public void verificarMes(String rfc[]) {
        int vn = 0;
        String uno = "1", cero = "0";
        String numeros = "123456789";
        String numeritos = "012";
        String tnum[] = numeros.split("");
        String tnm[] = numeritos.split("");
        //si el caracter es igual a un 0 comparara el siguiente con un numero del 1 al 9
        if (rfc[6].equals(cero)) {
            for (int i = 0; i < tnum.length; i++) {
                if (rfc[7].equals(tnum[i])) {
                    i = tnum.length;
                    vn++;
                }
            }
            if (vn != 0) {
                //Verificar día
                verificarDia(rfc);
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
        //si el caracter es igual a un 1 comparara el siguiente con un numero del 0 al 2
        } else if (rfc[6].equals(uno)) {
            for (int i = 0; i < tnm.length; i++) {
                if (rfc[7].equals(tnm[i])) {
                    i = tnm.length;
                    vn++;
                }
            }
            if (vn != 0) {
                //Verificar día
                verificarDia(rfc);
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
        } else {
            System.out.println("\033[41mEl RFC no es valido");
        }
    }
//verifica el dia con los siguientes caracteres que siguen
    public void verificarDia(String rfc[]) {
        int vn = 0;
        String cero = "0", uno = "1", dos = "2", tres = "3";
        String numeros = "123456789";
        String numeritos = "0123456789";
        String tnum[] = numeros.split("");
        String tnm[] = numeritos.split("");
        //si el caracter es igual a un cero comparara el siguiente con un numero del 1 al 9
        if (rfc[8].equals(cero)) {
            for (int i = 0; i < tnum.length; i++) {
                if (rfc[9].equals(tnum[i])) {
                    i = tnum.length;
                    vn++;
                }
            }
            if (vn != 0) {
                //Verificar homoclave
                homoclave(rfc);
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
            //si el caracter es igual a un 1 o 2 comparara el siguiente con un numero del 0 al 9
        } else if (rfc[8].equals(uno) || rfc[8].equals(dos)) {
            for (int i = 0; i < tnm.length; i++) {
                if (rfc[9].equals(tnm[i])) {
                    i = tnm.length;
                    vn++;
                }
            }
            if (vn != 0) {
                //Verificar homoclave
                homoclave(rfc);
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
            //si el caracter es igual a un 3 comparara el siguiente con 0 o 1
        } else if (rfc[8].equals(tres)) {
            if (rfc[9].equals(cero)) {
                //Verificar homoclave
                homoclave(rfc);
            } else if (rfc[9].equals(uno)) {
                //Verificar homoclave
                homoclave(rfc);
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
        } else {
            System.out.println("\033[41mEl RFC no es valido");
        }

    }
//verifica la homoclave la cual es una convinación de letras y numeros
    public void homoclave(String rfc[]) {
        int nh = 0;
        String numabc = "ABCDEFGHIJKLNMÑOPQRSTUVWXYZ1234567890";
        String na[] = numabc.split("");
        for (int i = 0; i < na.length; i++) {
            if (rfc[10].equals(na[i])) {
                i = na.length - 1;
                nh++;
            }
        }
        if (nh != 0) {
            for (int i = 0; i < na.length; i++) {
                if (rfc[11].equals(na[i])) {
                    i = na.length - 1;
                    nh++;
                }
            }
            if (nh != 1) {
                for (int i = 0; i < na.length; i++) {
                    if (rfc[12].equals(na[i])) {
                        i = na.length - 1;
                        nh++;
                    }
                }
                if (nh != 2) {
                    //Si llega hasta aqui es por que le RFC es correcto entonces imprime que el RFC fue aceptado
                    System.out.println("\033[42mRFC Aceptada");
                } else {
                    System.out.println("\033[41mEl RFC no es valido");
                }
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
        } else {
            System.out.println("\033[41mEl RFC no es valido");
        }
    }
}

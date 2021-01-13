package RFC;

public class Metodos {

    public void VerificacionLetras(String rfc[]) {
        int vl = 0;
        String abecedari = "ABCDEFGHIJKLNMÑOPQRSTUVWXYZ";
        String tabc[] = abecedari.split("");
        for (int i = 0; i < tabc.length; i++) {
            if (rfc[0].equals(tabc[i])) {
                i = 26;
                vl++;
            }
        }
        if (vl != 0) {
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
                    if (vl != 3) {
                        //Verificar Año
                        verificarAno(rfc);
                    } else {
                        System.out.println("\033[41mEl RFC no es valido");
                    }
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
                //Verificador de Mes
                verificarMes(rfc);
            } else {
                System.out.println("\033[41mEl RFC no es valido");
            }
        } else {
            System.out.println("\033[41mEl RFC no es valido");
        }
    }

    public void verificarMes(String rfc[]) {
        int vn = 0;
        String uno = "1", cero = "0";
        String numeros = "123456789";
        String numeritos = "012";
        String tnum[] = numeros.split("");
        String tnm[] = numeritos.split("");
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

    public void verificarDia(String rfc[]) {
        int vn = 0;
        String cero = "0", uno = "1", dos = "2", tres = "3";
        String numeros = "123456789";
        String numeritos = "0123456789";
        String tnum[] = numeros.split("");
        String tnm[] = numeritos.split("");
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

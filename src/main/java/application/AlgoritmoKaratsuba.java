

package application;

import java.util.Scanner;


public class AlgoritmoKaratsuba {

    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        int op;
        do{
        System.out.println("Digite 1 para outra operação ou 0 para finalizar programa");
        op = s.nextInt();
        s.nextLine();
        if(op == 1){
           numbers();
        }else if(op !=0){
            System.out.println("Opção inválida. digite 0 ou 1");
        }
        }while(op != 0);
        System.out.println("Programa finalizado");
        s.close();
    }
    
    public static void numbers(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um numero grande");
            String x = s.nextLine();
            
            System.out.println("Digite o segundo numero grande");
            String y = s.nextLine();
            
            x = trimZeros(x);
            y = trimZeros(y);
            
            String resultado = karatsuba(x, y);
            System.out.println(resultado);
    }
    
    private static String trimZeros(String s) {
        return s.replaceFirst("^0+(?!$)", "");
    }
    
    public static String karatsuba(String x, String y){ //Dividirá quantas vezes necessário até ser apenas um unico numero
        if (x.length() == 1 && y.length() == 1) { 
            int xi = x.charAt(0) - '0'; //transofrma para inteiro
            int yi = y.charAt(0) - '0';
            return String.valueOf(xi * yi); //retorna a multiplicação
        }
        
        int n = Math.max(x.length(), y.length());
        if (n % 2 != 0) n++; //Faz com que o numero de maior comprimento seja ajustado para ser par
   
        x = padLeft(x, n);
        y = padLeft(y, n);
        int m = n/2;
        /** Ex: x = 123456 - length = 6
        *      y = 9876 - length = 4
        *      ao passar no padLeft y retornará 009876
        */     
        
        String a = x.substring(0,m);
        String b = x.substring(m);
        String c = y.substring(0,m);
        String d = y.substring(m);
        
        String ac = karatsuba(a, c);
        String bd = karatsuba(b, d);
        
        String abPlus = stringAdd(a, b);
        String cdPlus = stringAdd(c, d);
        
        String abcd = karatsuba(abPlus, cdPlus);
        
        // Z1 = (A+B)(C+D) - AC - BD
        String adPlusBc = stringSubtract(stringSubtract(abcd, ac), bd);

        // Final = AC * 10^(2*m) + (AD+BC) * 10^m + BD
        String acShift = shiftLeft(ac, 2 * m);
        String adbcShift = shiftLeft(adPlusBc, m);

        return trimZeros(stringAdd(stringAdd(acShift, adbcShift), bd)); 
    }
    
    private static String padLeft(String s, int n) {   //Enquanto o tamanho da string for menor que a maior string, incremente zeros na frente
        while (s.length() < n) s = "0" + s;
        return s;
    }
    private static String stringAdd(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int i = a.length() - 1, j = b.length() - 1; //Referencia para os ultimos numeros

        while (i >= 0 || j >= 0 || c != 0) { // enquanto tiver numero ou carry
            int x = (i >= 0 ? a.charAt(i--) - '0' : 0); // Converte para numero subtraindo por  '0', se não, considerar 0;
            int y = (j >= 0 ? b.charAt(j--) - '0' : 0);
            int sum = x + y + c;
            sb.append(sum % 10); //append o resto da divisão
            c = sum / 10; //c recebe o valor de um possivel acrecimo decimal, ex 7 + 8 = 15, append o 5 e guardao 1
        }

        return sb.reverse().toString(); // foi montado de tras pra frente, aqui inverte para o resultado concreto
    }
    private static String stringSubtract(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int borrow = 0;
        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0) {
            int x = a.charAt(i) - '0';
            int y = (j >= 0 ? b.charAt(j) - '0' : 0);
            int sub = x - y - borrow;

            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            sb.append(sub);
            i--; j--;
        }

        return trimZeros(sb.reverse().toString());
    }
    private static String shiftLeft(String s, int k) {
        return s + "0".repeat(k);
    }
    
}

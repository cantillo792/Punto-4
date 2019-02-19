
package punto4;
import java.util.Scanner;

public class PerfectPrimeFactors {
  
    public static void main(String[] args)
    {
        System.out.print("Introduzca el límite superior: ");
        Scanner in = new Scanner(System.in);
        if ( ! in.hasNextInt()) {
            System.out.println("El límite superior no es válido. Inténtalo de nuevo.");
            return;
        }
        int LimSup = in.nextInt();
        
        PerfectPrimeFactors jfg = new PerfectPrimeFactors();
        
        System.out.println(jfg.isProductOfPrimeFactors(30));
        System.out.println(jfg.isProductOfPrimeFactors(20));
        
        jfg.ImprimirFactoresPrimos(LimSup);
    }
    
   
    
    private boolean isProductOfPrimeFactors(int posInt)
    {
        int prod = 1;
        for (int i = 2; i < posInt; i++) {
            prod *= EsPrimo(i) && (posInt%i == 0) ? i : 1;
        }
        return (prod == posInt);
    }
    
     private boolean EsPrimo(int posInt)
    {
        for (int i = 2; i <= Math.sqrt(posInt); i++)
        {
            if (posInt%i != 0) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    private void ImprimirFactoresPrimos(int LimSup)
    {
        System.out.println("Estos números son iguales al producto de factores primos: ");
        
        int contProdPrimeFactors = 0;
        for (int i = 1; i <= LimSup; i++) {
            if (! isProductOfPrimeFactors(i)) {
                continue;
            }
            System.out.printf("%1$d ", i);
            contProdPrimeFactors++;
        }
        System.out.printf("\n[%1$d Numeros encontrados:  (%2$.2f%%)]\n"
                , contProdPrimeFactors, ((double) 100 * contProdPrimeFactors/LimSup));
    }
}
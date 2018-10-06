
import java.util.*;

public class Tortugasa {
    static Scanner entrada =  new Scanner (System.in);
    public static void main(String[] args)
    {
        
        int t;
        System.out.println("ingrese la cantidad de tortugas: ");
        
        t = entrada.nextInt();
        if(t <= 0){
            System.out.println("Cantidad nula");
        } else {
        int[] array = new int [t];
        int[] pesados = new int [t];
        int[] fuerzas = new int [t];
        
        for(int i=0; i<array.length; i++){
            System.out.println(" Ingrese datos: ");
            int peso = entrada.nextInt();
            int fuerza = entrada.nextInt();
            
            pesados [i] = peso;
            fuerzas [i] = fuerza; 
            array[i] = fuerzas[i] - pesados[i];
        }           
        for(int j=0; j<array.length; j++){
            int cont = 0;
            int a = Mayor(array,0,array[0]);
            if (pesados[j]<Mayor(array,0,array[0])){     
                if (a>0){
                    int b = a - array[j];
                }
                cont++;
            }
            System.out.println(cont);
        }
        }    
    }
         
    
        
    
 
    static int Mayor(int[] array, int n, int mayor)
    {
        if (n == array.length)
            return mayor;
 
        if (array[n] > mayor)
            mayor = array[n];
 
        return Mayor(array, ++n, mayor);
    }
}
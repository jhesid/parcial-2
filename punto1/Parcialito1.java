package parcialito1;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Parcialito1 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Queue<elefante> cola=new LinkedList();
    Queue<elefante> aprobados=new LinkedList();
    //se lee la linea
    String line=sc.nextLine();
    elefante el=new elefante(0,0,0);
    int contador=0;
    //ciclo de elefantes papurris
    while(true){
        //verificamos que la linea no este vacia papurris
        if (line.isEmpty()) {
            break;
        }
        //contador que nos da la pocicion 
        contador++;
        //convertimos lo que nos dieron a un array con el peso y ci
        String[] elefantes=line.split(" ");
        //convertimos los strings a ints
        int peso=convertir(elefantes[0]);
        int ci=convertir(elefantes[1]);
        //añadimos elefantes a la lista papurris
        //y verificamos si hay un elefante mas grande
        if(el.compared(peso)==true){
        el.cambioElefante(peso, ci, contador);
        }
        
        cola.add(new elefante(peso, ci, contador));
        line=sc.nextLine();
    }
    if(contador!=0){
    //se comprueba cuales cumplen
    cumplen(el,cola,aprobados);
    //se empieza a ordenar istsa wea
    elefante[] izi= new elefante[aprobados.size()];
        for (int i = 0; i < izi.length; i++) {
            izi[i]=aprobados.poll();
        }
            orden(izi,0,izi);
            
            for (int j = 0; j < izi.length; j++) {
                System.out.println(izi[j].getPos());
            }
        
    }
    }
    /*--------------------------------------------------------------------
                        aqui deberia de ordenar
    ----------------------------------------------------------------------*/
    
    //el que verifica cuales cumplen con recursividad
    static void cumplen(elefante comparador,Queue<elefante>lista,
                        Queue<elefante>aprobados){
        if (lista.isEmpty()) {
          
        }else{
            elefante a=lista.poll();
            if (comparador.comparedint(a.getInteligencia())==true) {
                aprobados.add(a);
                cumplen(comparador,lista,aprobados);
            }
            if (comparador.comparedint(a.getInteligencia())==false) {
                cumplen(comparador,lista,aprobados);                
            }
        }
    }
    //bubblesort porque tengo que entregar algo YOLO
    
   static void orden(elefante[] array,int n,elefante[] nomod){
       if(n==array.length-1){
      
       }
       else{
    burbuja b=Mayor(nomod,n,array[n]);
   array[b.pocicion]=array[n];
   array[n]=b.getA();
   orden(array,++n);
       }
   }
   
   
    static burbuja Mayor(elefante []array,int n,elefante mayor){
        burbuja burb;    
        if (n==array.length-1) {
            return new burbuja(mayor,n);
        }
        if (array[n].inteligencia>mayor.inteligencia) {
            mayor=array[n];
        }
        return Mayor(array,++n,mayor);
    }
    
   static int convertir(String valor){
   int value= Integer.parseInt(valor);
   return value;
   }
}
class burbuja{
public elefante a;
public int pocicion;

    public burbuja(elefante a, int pocicion) {
        this.a = a;
        this.pocicion = pocicion;
    }


    public int getPocicion() {
        return pocicion;
    }

    public void setPocicion(int pocicion) {
        this.pocicion = pocicion;
    }

    public void setA(elefante a) {
        this.a = a;
    }

    public  elefante getA() {
        return a;
    }
    
    


}
class elefante{
public int peso;
public int inteligencia;
public int pos;

    public elefante(int peso, int tamaño, int pos) {
        this.peso = peso;
        this.inteligencia = tamaño;
        this.pos = pos;
    }
    public void cambioElefante(int peso, int tamaño, int pos) {
        this.peso = peso;
        this.inteligencia = tamaño;
        this.pos = pos;
    }
    public boolean compared(int peso){
        boolean a;
        if (this.peso<peso) {
            a= true;
        }else{
         a=false;
        }
        return a;
    }
    public boolean comparedint (int peso){
        boolean a;
        if (this.inteligencia<peso) {
            a= true;
        }else{
         a=false;
        }
        return a;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getPos() {
        return pos;
    }
    
    
    
}

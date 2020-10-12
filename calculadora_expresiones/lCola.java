
package com.mycompany.calculadora.de.expresiones;


public class lCola{
    cola inicio=null;
    cola fin=null;
    
    public  void add (char dato) {
	cola nuevo = new cola();
        nuevo.dato=dato;
	if(inicio == null) {
		inicio=nuevo;
		fin=nuevo;
            }else {
		nuevo.siguiente=inicio;
		inicio.anterior=nuevo;
		inicio=nuevo;
		}
	}   
      
    public void recorre(){
        cola aux = fin;
        while(aux!=null){
            System.out.print(aux.dato+" ");
            //System.out.println(aux.dat);
            aux=aux.anterior;
        }
    }    
}
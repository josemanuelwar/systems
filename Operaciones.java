/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trasporte;

/**
 *
 * @author josemanuel
 */
public class Operaciones {
   
        protected float Subcosto;
        protected float subprosentage; 
        protected float total;
        protected float aux;
         
    public float costo(float distancia, float volumen, float peso, boolean redondo){
        
        if (redondo == false)
        {
            Subcosto = (distancia*volumen*10);
            
            if(peso > 40){
                subprosentage = (Subcosto*20)/100;
                total = Subcosto+subprosentage;
            }else{
                total=Subcosto;
            }
        }else
         {
           Subcosto = (distancia*volumen*10);
           subprosentage = (Subcosto*10)/100;   
                aux=Subcosto-subprosentage;
   
            if(peso > 40){
                subprosentage = (Subcosto*20)/100;
                total = aux+subprosentage;
            }else{
                 total=aux;
                  }
           
        }
        
        return  total;
    }
}

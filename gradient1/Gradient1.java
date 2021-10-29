//Gerardo Demian Mora Hernandez
//Hands-on 8: Gradient-based Agent
//Simulacion
//21/10/21
package gradient1;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
public class Gradient1 extends Agent{
    @Override
    public void setup(){
     System.out.println("Agente ejecutando");
            
     //valores designados
        int x[]={23,26,30,34,43,48,52,57,58};
        int y[]={651,762,856,1063,1190,1298,1421,1440,1518};
        int n=9;
        double b0=0,b1=0,alpha=0.003,error = 0;
        
        //Llamado de los metodos
        beta0 beta0 = new beta0();
        beta1 beta1 = new beta1();
        error err = new error();
        
        
        //Declaración del Error
         error = err.error1(x, y, b0, b1);
         double error2=error;//El error2 funciona para guardar el valor anterior antes de modificarse
                             //Este hace que el ciclo se detenga en algun momento y evite infinito
         
         double b0res=0,b1res=0;
         
         //Obtiene el nuevo valor de las dos betas
         while(error<=error2){
             b0res=b0; b1res=b1;
             
              b0 = b0-(alpha*(beta0.Cero(n, x, y, b0, b1)));
              b1 = b1-(alpha*(beta1.Uno(n, x, y, b0, b1)));
              error2=error;
              error = err.error1(x, y, b0, b1);
              System.out.println("Error "+error);            
        }
         
         //Mostrara valores de las betas
         System.out.println("B0: "+b0+"  B1:"+b1);
         
         addBehaviour(new MyOneshotBehaviour());
         System.out.println("Agente Eliminado");
        
        
    }
        
    private class MyOneshotBehaviour extends OneShotBehaviour {

        @Override
        public void action() {
            
        }
        
         @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}
        
        
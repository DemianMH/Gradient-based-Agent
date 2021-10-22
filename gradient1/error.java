//Metodo Para sacar valor del error con la formula
package gradient1;
public class error {
    public double error1(int x[],int y[],double b0,double b1){
    double error=0,n=9;
    for(int i=0;i<n;i++){
        error += Math.pow((y[i]-(b0+(b1*x[i]))),2);
    }
        error= error/n;
       return error; 
}
    
}

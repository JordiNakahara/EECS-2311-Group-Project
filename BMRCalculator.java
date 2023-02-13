public class BMRCalculator{

    double BMR;
  
    public static double BMRCalc(char gender, int weight, int height, int age){
        if(gender == 'M'){
            BMR = ((10*weight)+(6.25*height)-(5*age)+5);
        }
        else if (gender == 'F'){
            BMR = ((10*weight)+(6.25*height)-(5*age)+161);
        }
        return BMR;
    }
    
    public double getBMR(){
           return this.BMR;
    }
    
}

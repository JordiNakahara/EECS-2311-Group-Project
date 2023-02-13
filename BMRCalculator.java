public class BMRCalculator{

    double BMR;
  
    public static double BMRCalc(User user){
        if(user.gender == 'M'){
            user.BMR = ((10*user.weight)+(6.25*user.height)-(5*user.age)+5);
        }
        else if (user.gender == 'F'){
            user.BMR = ((10*user.weight)+(6.25*user.height)-(5*user.age)+161);
        }
        return BMR;
    }
    
    public double getBMR(){
        return this.BMR;
    }
    
}

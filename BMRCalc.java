public class BMRCalc {

    double BMR;
  
    public double BMRCalc(User user){
        if(user.gender == M){
            BMR = ((10*user.weight)+(6.25*user.height)-(5*user.age)+5);
        }
        else if (user.gender == F){
            BMR = ((10*user.weight)+(6.25*user.height)-(5*user.age)+161);
        }
        return BMR;
    }
    
}

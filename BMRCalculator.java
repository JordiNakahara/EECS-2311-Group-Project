public class BMRCalculator{
  
    public static double BMRCalc(User user){
        if(user.getGender() == 'M'){
            user.BMR = ((10*user.getWeight())+(6.25*user.getHeight())-(5*user.getAge())+5);
        }
        else if (user.getGender() == 'F'){
            user.BMR = ((10*user.getWeight())+(6.25*user.getHeight())-(5*user.getAge())+161);
        }
        return user.BMR;
    }
        
}

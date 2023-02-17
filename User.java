
// This must be in the same package as the BMRCalc class right? that way it can use the BMR calc method 

public class User {

    private String firstName;
    private String lastName;
    private char gender;
    private double weight;
    private double height;
    private int age;
    public double BMR;
    
    public User(){
        this.firstName = "";
        this.lastName = "";
        this.gender = 0;
        this.weight = 0;
        this.height = 0;
        this.age = 0;
        this.BMR = 0;
    }

    public User (String firstName, String lastName, char gender, double weight, double height, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        setBMR(this);       
    }

    public void setFName(String fName){
        this.firstName = fName;
    }

    public String getFName(){
        return this.firstName;
    }

    public void setLName(String lName){
        this.lastName = lName;
    }

    public String getLName(){
        return this.lastName;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public char getGender(){
        return this.gender;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
    
    public double getBMR(){
        return this.BMR;    
    }
    
    public void setBMR(User user){
        this.BMR = BMRCalculator.BMRCalc(user);
    }
    
}

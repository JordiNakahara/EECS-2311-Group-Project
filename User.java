
// This must be in the same package as the BMRCalc class right? that way it can use the BMR calc method 

public class User {

    private String firstName;
    private String lastName;
    private char gender;
    private int weight;
    private int height;
    private int age;
    private double BMR;

    public User (String firstName, String lastName, char gender, int weight, int height, int age){
        this.firstName = setFName(firstName);
        this.lastName = setLName(lastName);
        this.gender = setGender(gender);
        this.weight = setWeight(weight);
        this.height = setHeight(height);
        this.age = setAge(age);
        this.BMR = BMRCalc(this.gender, this.weight, this.height, this.age);
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

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return this.height;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
    
}

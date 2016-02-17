
public class Dog extends Mammal
{
    int age;
    int weight;

    public Dog()
    {

    }

    public Dog(int age, int weight){
        this.age = age;
        this.weight = weight;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void testMethod(){
        System.out.println("you are printing from the Dog subclass");
    }

    public void methodRunner(){
        super.testMethod();
    }
}



public class AnimalRunner
{
    public static void main(String[] args){
        Dog davidsDog = new Dog(5, 10);
        Dog marysDog = new Dog(5, 10);
        Dog marthasDog = new Dog();
        marthasDog = marysDog;
        // note that == works for instance variables within an object
        System.out.println("check values equal: " + (marthasDog.age == davidsDog.age));
        // Try == for objects
        System.out.println("check objects equal == " + (marysDog == marthasDog));
        System.out.println("check different ojects equal == " + (marysDog == davidsDog));
        // we need the .equals to compare objects to each other
        System.out.println("check objects equal: " + marthasDog.equals(marysDog));
        /* although their values are the same, davidsDog is not equal to marysDog
         * it is like the analogy of two people having similar pairs of shoes.
         */
        System.out.println("check objects equal: " + davidsDog.equals(marysDog));
        // Try out whether super can look up 2 levels
        davidsDog.methodRunner();
    }
}

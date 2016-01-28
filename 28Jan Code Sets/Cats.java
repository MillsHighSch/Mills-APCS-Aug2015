public class Cats{
    String name = "Fluffy";
    String breed = "Alley";
    double weight = 20;

    public Cats(){
        weight = 50;
    }
    
    public Cats(String type){
        breed = type;
        weight = 10;
        breed = "lazagna";
    }

    public String toString(){
        return ("name = " + name + "; breed = " + breed + "; weight = " + weight);
    }
}
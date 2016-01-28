public class ThisTrial
{
   int x;
   public void AddNums(int x, int y){
       x += y;
       System.out.println("x " + x);
       System.out.println("x " + this.x);
    }
}

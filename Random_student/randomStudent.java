
/**
 * Write a description of class randomStudent here.
 * Method to select a student name at random
 * 
 * @author Steve Lamont
 * @version 4 Aug 2015
 */

import java.awt.Graphics;

public class randomStudent
{
    public static void main(String[] args) {
        String[] peoples = {"Bob","Jill","Tom","Brandon"}; // enter student names here.
        
        int choice = (int)(Math.random() * peoples.length);
        System.out.println(peoples[choice]);
    }
    // TODO ... write large display of answer
    public void displayName (String student){
        Graphics g = new Graphics (
    }
    
    public void paint(Graphics g)
{
   g.drawString("abc", 25, 25);
}
}


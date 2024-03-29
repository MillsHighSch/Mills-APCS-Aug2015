import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    /** Assignment Exercise 3
     * Method to set the red & green to 0 
     */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** Assignment Exercise 4
     * New Method negate -- to switch all values to negative 
     */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255-pixelObj.getRed());
                pixelObj.setGreen(255-pixelObj.getGreen());
                pixelObj.setBlue(255-pixelObj.getBlue());
            }
        }
    }

    /** Assignment Exercise 5
     * New Method grayscale. Set all RGB to average for gray scale picture
     */
    public void grayscale()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int ave = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
                pixelObj.setRed(ave);
                pixelObj.setGreen(ave);
                pixelObj.setBlue(ave);
            }
        }
    }

    /** Assignment Exercise 6
     * New method fixUnderwater to make the fish more visible
     * Assume we want to emphasize blue
     */
    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                if((pixelObj.getBlue()/pixelObj.getGreen())< .9){
                    int ave = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
                    pixelObj.setRed(ave);
                    pixelObj.setGreen(ave);
                    pixelObj.setBlue(ave);
                }  
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /**Exercise 1 page 15
     * Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from right to left */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = width-1; col > width / 2; col--)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Exercise 2, page 15
     * Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from top to bottom */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
        for (int col = 0; col < width; col++)
        {
            for (int row = 0; row < height / 2; row++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[height - row - 1][col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Exercise 3, page 16
     * Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from bottom to top */
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
        for (int col = 0; col < width; col++)
        {
            for (int row = height-1; row > height / 2; row--)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[height - row - 1][col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Exercise 4, page 16
     * Method that mirrors the picture around a 
     * diagonal mirror in the center of the picture
     * from bottom-left to top-right */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel initPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
        if (width > height) width = height; // avoiding going beyond bottom
        for (int col = 0; col < width; col++)
        {
            for (int row = col; row < height; row++)
            {
                initPixel = pixels[row][col];
                topPixel = pixels [col][row];
                topPixel.setColor(initPixel.getColor());
            }
        } 
    }

    /**Exercise 2, Page 18 
     * Mirror arms on snowman to make 4 arms 
     */
    public void mirrorArms()
    {
        Pixel sourcePixel = null;
        Pixel newPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // Mirror left arm
        // loop through the rows
        for (int row = 173; row < 198; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 239; col < 295; col++)
            {

                sourcePixel = pixels[row][col];      
                newPixel = pixels[row + 17]                       
                [238 + 170 - col];
                newPixel.setColor(sourcePixel.getColor());
            }
        }
        // Mirror right arm
        // loop through the rows
        for (int row = 190; row > 159; row--)
        {
            // loop from 13 to just before the mirror point
            for (int col = 169; col > 105; col--)
            {

                sourcePixel = pixels[row][col];      
                newPixel = pixels[row + 30]                       
                [170 + 238 - col];
                newPixel.setColor(sourcePixel.getColor());
            }
        }
    }

    /**Exercise 3, Page 18 
     * Mirror seagull 
     */
    public void mirrorGull()
    {
        Pixel sourcePixel = null;
        Pixel newPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 235; row < 321; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 235; col < 349; col++)
            {

                sourcePixel = pixels[row][col];      
                newPixel = pixels[row + 16]                       
                [col + 182];
                newPixel.setColor(sourcePixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }
        System.out.println(count);
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /**Exercise 1, page 20 
     * copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * Specify what portion of fromPic to copy
     * @param fromPic the picture to copy from
     * @param fromRow1 the row to start copying from
     * @param fromRow2 the row to stop copying from
     * @param fromCol1 the column to start copying from
     * @param fromCol2 the column to stop copying from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int fromRow1, int fromRow2, int fromCol1, int fromCol2,
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = fromRow1, toRow = startRow; 
        fromRow < (fromRow2 + 1) &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = fromCol1, toCol = startCol; 
            fromCol < (fromCol2 + 1) &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /**Exercise 2, page 21 
     * Method to create a collage of several pictures */
    public void myCollage()
    {
        Picture moto1 = new Picture("blueMotorcycle.jpg");
        Picture moto2 = new Picture("redMotorcycle.jpg");
        this.copy(moto1,0,0);
        this.copy(moto2,0,640);
        Picture motoNoBlue = new Picture(moto1);
        motoNoBlue.zeroBlue();
        this.copy(motoNoBlue,480,0);
        Picture negRed = new Picture(moto2);
        negRed.negate();
        this.copy(negRed,480,640);
        this.write("StevesCollage.jpg");
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }
    
    /**Exercise 1, page 22 
     * Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection2 (int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        // first check pixels along each row
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
        // second check for pixels along each column
        for (int col = 0; col < pixels[0].length; col++)
        {
            for (int row = 0; 
            row < pixels.length-1; row++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row+1][col];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this

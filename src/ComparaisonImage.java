import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ComparaisonImage {
    public static void main(String[] args){
        BufferedImage img1= null;
        BufferedImage img2 = null;
        try{
            File fileA = new File("D:\\viard\\Desktop\\Photos\\unknown.png");
            File fileB = new File("D:\\viard\\Desktop\\Photos\\unknown.png");

            img1 = ImageIO.read(fileA);
            img2 = ImageIO.read(fileB);


        } catch (Exception e) {
            e.printStackTrace();
        }
        int width1 = img1.getWidth();
        int width2 = img2.getWidth();
        int height1 = img1.getHeight();
        int height2 = img2.getHeight();

        if((width1 !=width2) || (height1!=height2)){
            System.out.println("Error");
        }
        long difference = 0;
        for (int y = 0; y< height1; y++){
            for (int x = 0; x< width1;x++){
                int rgbA = img1.getRGB(x,y);
                int rgbB = img2.getRGB(x,y);
                int redA = (rgbA >> 16) & 0xff;
                int greenA = (rgbA >> 8) & 0xff;
                int blueA = (rgbA) & 0xff;
                int redB = (rgbB >> 16) & 0xff;
                int greenB = (rgbB >> 8) & 0xff;
                int blueB = (rgbB) & 0xff;
                difference += Math.abs(redA - redB);
                difference += Math.abs(greenA - greenB);
                difference += Math.abs(blueA - blueB);

            }
        }
        // Total number of red pixels = width * height
        // Total number of blue pixels = width * height
        // Total number of green pixels = width * height
        // So total number of pixels = width * height * 3
        double total_pixels = width1 * height1 * 3;

        // Normalizing the value of different pixels
        // for accuracy(average pixels per color
        // component)
        double avg_different_pixels = difference /
                total_pixels;

        // There are 255 values of pixels in total
        double percentage = (avg_different_pixels /
                255) * 100;

        System.out.println("Difference Percentage-->" +
                percentage);
    }
}




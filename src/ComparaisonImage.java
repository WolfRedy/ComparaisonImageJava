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
            }
        }


    }
}

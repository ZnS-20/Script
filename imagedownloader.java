//A jpg downloader


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.*;

public class imagedownloader
{
	public static void main(String []args)throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Url = ");
        String input = br.readLine();
        System.out.println();
        System.out.print("Enter the Image name = ");
        String name = br.readLine();
	    BufferedImage image = null;
	    try
	    {
	       URL url=new URL(input);
	       image=ImageIO.read(url);
	       ImageIO.write(image,"jpg",new File("/home/mohammad/xkcd/"+name)); //set the location you want the image to be downloaded.
	    }
	    catch(IOException e)
	   {
	       e.printStackTrace();
       }
    }
    
}


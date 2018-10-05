import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;  
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;


public class xkcd_downloader
{  
   public static void main( String[] args ) throws IOException
    {
       	Scanner sc=new Scanner(System.in);
        System.out.print("Enter the page no you want to start the download from : ");
        int s=sc.nextInt();
        System.out.print("Enter the page number you want to stop : ");
        int n=sc.nextInt();
        String src = "" , link="";
        for(int i=s; i<=n ; i++)
        {
            Document doc = Jsoup.connect("https://xkcd.com/"+i).timeout(10*10000).get();  
            Elements images = doc.select("img[src~=(?i)\\.(jpe?g)]");  
            for (Element image : images)
           {  
                src=image.attr("src");
                if(!"//imgs.xkcd.com/s/a899e84.jpg".equals(src))
                {
                	link = "https:".concat(src);
                }
            }
            BufferedImage img = null;
	        try
	        {
	          URL url=new URL(link);
	          img=ImageIO.read(url);
	          ImageIO.write(img,"jpg",new File("/home/mohammad/xkcd/"+i));
	        }
	        catch(IOException e)
	        {
	          e.printStackTrace();
            }
            System.out.println("Image "+i+" Downloaded");
        } 
    }
}     

import java.io.*;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
public class UrlConnection {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The URL: ");
        String url = input.nextLine();
        accessWeb(url);
    }
    private static void accessWeb(String url)
    {
        BufferedReader bufferedReader = null;
        try
        {
            URL MyUrl= new URL(url);
            URLConnection urlConnection = MyUrl.openConnection();
            InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
            bufferedReader = new BufferedReader(isr);
            String line;
            PrintWriter writer = new PrintWriter("url.html");
            while ((line = bufferedReader.readLine())!= null)
            {
                writer.print(line+"\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Url is invalid");
            e.printStackTrace();
            System.exit(1);
        }
        finally
        {
            System.out.println("Close Connection...");
            try
            {
                bufferedReader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

}

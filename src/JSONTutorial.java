import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONTutorial
{
    public static void main(String[] args)
    {
        JSONObject obj = null;
        try {
            //Passing a URL linking to a JSON object
            obj = parseJSON(new URL("https://api.twitch.tv/kraken/channels/gjb93"));
        }
        catch(MalformedURLException e)
        {
            System.out.println("URL exception");
            e.printStackTrace();
        }

        //Printing out the Twitch Stream title stored under the "status" name
        System.out.println(obj.getString("status"));
    }

    public static JSONObject parseJSON(URL url)
    {
        //Initialising a BufferedReader for reading in the URL stream
        BufferedReader reader = null;

        try {
            //Setting the input stream to be the data available at the given url
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        }
        catch(IOException e)
        {
            System.out.println("IO exception occurred when creating the URL reader");
            e.printStackTrace();
        }

        String line;
        String str = "";


        try {
            //Reading the file line by line and appending each line to the str variable
            while ((line = reader.readLine()) != null)
            {
                str += line;
            }
        }
        catch(IOException e)
        {
            System.out.println("IO exception occurred when reading from the URL");
            e.printStackTrace();
        }

        //Returning the str value as a JSON object
        return new JSONObject(str);
    }
}

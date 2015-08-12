package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TaskList
{
    public static ArrayList<String> list;

    public TaskList()
    {

    }

    public static void getTasks()
    {
        list = new ArrayList<>();
        String currLine = new String();
        String name = new String();
        int lineNumber = 0;

        try
        {
            Process p = Runtime.getRuntime().exec("cmd /c tasklist");

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while((currLine = reader.readLine()) != null)
            {
                name = "";

                // entering the name string
                for (int i = 0; i < 35; i++)
                {
                    // name range
                    if(i < 25 && lineNumber > 2)
                    {
                        if(currLine.charAt(i) != ' ') // if it is not space, to only read the characters
                            name += currLine.charAt(i);
                    }
                }

                list.add(name);
                lineNumber++;
            }

        }
        catch(IOException e) {}
    }

    public ArrayList<String> getList()
    {
        return list;
    }
}

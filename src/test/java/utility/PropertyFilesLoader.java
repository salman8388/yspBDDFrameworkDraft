package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilesLoader {

    /*
     * This method will get the key value from properties  file
     * @its overloaded method
     * It will get the data from project level we need to pass specific folder path
     * */
    public static String getProperty(String key,String folderLocation) throws IOException
    {
        Properties prop=new Properties();
        String path=System.getProperty("user.dir")+folderLocation;
        File baseFileLocation=new File(path);

        for(File file:baseFileLocation.listFiles())
        {
            if(file.getName().endsWith(".properties"))
            {
                try {
                    FileInputStream inputFile = new FileInputStream(file);
                    prop.load(inputFile);
                }catch (IOException e)
                {
                    e.printStackTrace();
                    System.err.println("Error : "+e);
                }

            }
        }
        return prop.getProperty(key);
    }
    /*
     * This method will get the key value from properties  file
     * it will get the data from single folder, because file path hot coded
     * */
    public static String GetProperty(String key) throws IOException
    {
        Properties prop=new Properties();
        String path=System.getProperty("user.dir")+"/src/test/resources/testDataFiles";
        File baseFileLocation=new File(path);

        for(File file:baseFileLocation.listFiles())
        {
            if(file.getName().endsWith(".properties"))
            {
                try {
                    FileInputStream inputFile = new FileInputStream(file);
                    prop.load(inputFile);
                }catch (IOException e)
                {
                    e.printStackTrace();
                    System.err.println("Error : "+e);
                }

            }
        }
        return prop.getProperty(key);
    }

    public String getProperty(String key)
    {
        Properties prop=new Properties();
        String path=System.getProperty("user.dir")+"/src/test/resources/testDataFiles";
        File baseFileLocation=new File(path);

        for(File file:baseFileLocation.listFiles())
        {
            if(file.getName().endsWith(".properties"))
            {
                try {
                    FileInputStream inputFile = new FileInputStream(file);
                    prop.load(inputFile);
                }catch (IOException e)
                {
                    e.printStackTrace();
                    System.err.println("Error : "+e);
                }

            }
        }
        return prop.getProperty(key);
    }


}

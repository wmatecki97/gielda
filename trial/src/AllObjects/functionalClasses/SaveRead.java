package AllObjects.functionalClasses;

import java.io.*;
import java.util.List;

public class SaveRead {


    private static String getPath(AllInstancess instance){
        return instance.getClass().getSimpleName()+ ".txt";
    }

    public static void save(List<AllInstancess> instance){

        FileWriter fw = null;
        if(!instance.isEmpty())
        {
            String path = getPath(instance.get(0));    //opening file to write
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                System.out.println("blad otwarcia pliku");
            }

            String output;
            BufferedWriter bw = new BufferedWriter(fw);  //writing to a file

            for(AllInstancess object: instance)
            {
                output = object.getOutputString();  //getting output string

                try {
                    bw.write(output);
                    bw.newLine();
                } catch (IOException e) {
                    System.out.println("blad podczas zapisywania do pliku");
                }


            }
            try {                                       //closing file
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("blad podczas zamykania pliku");
            }

        }
    }

    public static void read(List<AllInstancess> outputList, AllInstancess instance){

        FileReader fr = null;


        String path = getPath(instance);
        File f = new File(path);
        if(f.exists() && !f.isDirectory())
        {
            try {                                           //opening file to read
                fr = new FileReader(path);
            } catch (IOException e) {
                System.out.println("blad otwarcia pliku");
            }
            String line;
            try{
                BufferedReader br = new BufferedReader(fr);

                while((line = br.readLine()) != null){              // reading whole file
                    AllInstancess temp = instance.setValues(line);  // sending read line to a right class function which returns an object of this class
                    outputList.add(temp);
                }
            }
            catch (IOException e){
                System.out.println("blad zapisu do pliku");
            }
        }
    }


}

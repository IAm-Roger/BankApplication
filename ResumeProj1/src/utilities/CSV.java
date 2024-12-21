package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    //function will read data from a .CSV file and return it as a list
    public static List<String[]> read(String file) throws FileNotFoundException {
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((dataRow = br.readLine()) != null)
            {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }

        }
        catch (FileNotFoundException e) {System.out.println("NO PROPER FILE FOUND"); throw new RuntimeException(e);}
        catch (IOException e) { System.out.println("CAN NOT READ FILE/CORRUPTED FILE"); throw new RuntimeException(e);}

        return data;
    }
}

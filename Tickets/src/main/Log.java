package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class Log {

    private static Log log;

    public static Log Log() {
        if(log == null) {
            log = new Log();
            return log;
        }
        return log;
    }


    public void addToLog(String filePath, String action) throws IOException {

        PrintWriter printWriter = null;

        try{
            FileWriter fw = new FileWriter(filePath,true);

            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            printWriter = new PrintWriter(bufferedWriter);

            Timestamp time = new Timestamp(System.currentTimeMillis());
            printWriter.println(action + "," + time);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                printWriter.flush();
                printWriter.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }



    }
}

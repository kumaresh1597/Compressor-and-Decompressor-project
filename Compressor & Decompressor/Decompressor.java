import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

//Creating a decompressor class with method fuction which decompress the file for us
public class Decompressor {
    public static void method(File file) throws IOException{

        // Getting the parent path of the file and storing it in string variable
        String filePath = file.getParent();
        
        // Creating the file input stream with the file which reads the file
        FileInputStream fis = new FileInputStream(file);

        //Creating a GZIP input stream is used to read the compressed file to byte array
        GZIPInputStream gzip = new GZIPInputStream(fis);

        // creating a File output stream which writes and decompress the file and output the file in the same folder from where we are getting the file
        FileOutputStream fos = new FileOutputStream(filePath+"/decompressed");

        byte[] buffer = new byte[1024];
        int len;

        while((len = gzip.read(buffer))!= -1){
          fos.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
}

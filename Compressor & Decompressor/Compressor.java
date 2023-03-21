import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

//Creating a compressor class with method fuction which compress the file for us
public class Compressor {

    public static void method(File file) throws IOException{
        // Getting the parent path of the file and storing it in string variable
        String filePath = file.getParent();

        // Creating the file input stream with the file which reads the file to bytes
        FileInputStream fis = new FileInputStream(file);
        // creating a File output stream which writes and output the file in the same folder from where we are getting the file
        FileOutputStream fos = new FileOutputStream(filePath+"/compressed.gz");
        //Compressing the file to Zip file so GZIP output stream is used which writes the input bytes to compressed zip file
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        //Creating a byte array to store the bytes of the input file
        byte[] buffer = new byte[1024];
        int len; // which stores the len of the array

        //loop run till the complete byte array is converted to Zip using GZIP output stream
        while((len = fis.read(buffer))!= -1){
          gzip.write(buffer,0,len);
        }

        //closing the class
        gzip.close();
        fos.close();
        fis.close();
    }
    
}

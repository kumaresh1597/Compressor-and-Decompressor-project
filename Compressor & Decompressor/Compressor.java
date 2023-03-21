import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {

    public static void method(File file) throws IOException{

        String filePath = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(filePath+"/compressed.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;

        while((len = fis.read(buffer))!= -1){
          gzip.write(buffer);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    
}

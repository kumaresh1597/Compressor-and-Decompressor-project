import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) throws IOException{

        String filePath = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(filePath+"/decompressed");

        byte[] buffer = new byte[1024];
        int len;

        while((len = gzip.read(buffer))!= -1){
          fos.write(buffer);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
}

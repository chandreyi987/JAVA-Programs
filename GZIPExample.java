import java.util.*;
import java.io.*;
import java.util.zip.*;

public class GZIPExample {
    public static void createFile(String filePath) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filePath));
        writer.println("This is a sample file for compression.");
        writer.close();
    }

    public static void compressFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath + ".gz");
        GZIPOutputStream gos = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            gos.write(buffer, 0, length);
        }

        fis.close();
        gos.finish();
        gos.close();
        fos.close();
    }

    public static void decompressFile(String gzipFilePath, String newFilePath) throws IOException {
        FileInputStream fis = new FileInputStream(gzipFilePath);
        GZIPInputStream gis = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(newFilePath);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = gis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }

        gis.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) {
        String filePath = "example.txt";
        try {
            createFile(filePath);
            System.out.println("File created.");
            compressFile(filePath);
            System.out.println("File compressed.");
            decompressFile(filePath + ".gz", "decompressed_example.txt");
            System.out.println("File decompressed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

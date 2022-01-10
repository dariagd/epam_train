import java.io.*;
import java.nio.charset.StandardCharsets;

public class IO {
    public static void main(String[] args) throws IOException {

        // try without resources
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = new FileOutputStream("input.txt");
            bufferedOutputStream = new BufferedOutputStream(outputStream, 100);
            for(byte b : "Hello, World".getBytes(StandardCharsets.UTF_8)){
                bufferedOutputStream.write(b);
            }
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert outputStream != null;
            outputStream.close();
        }


        // try with resources
        try(OutputStream outputStream1 = new FileOutputStream("new_input.txt");
            BufferedOutputStream bufferedOutputStream1 = new BufferedOutputStream(outputStream1, 100)) {
            for(byte b : "Hello, Dasha".getBytes(StandardCharsets.UTF_8)){
                bufferedOutputStream1.write(b);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

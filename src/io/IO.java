package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IO {
    public static void main(String[] args) throws IOException {

        // try without resources
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream;
        try {
            outputStream = new FileOutputStream("input.txt");
            bufferedOutputStream = new BufferedOutputStream(outputStream, 100);
            for(byte b : "Hello, World".getBytes(StandardCharsets.UTF_8)){
                bufferedOutputStream.write(b);
            }
            bufferedOutputStream.flush(); // flush() or close() in finally block
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert outputStream != null;
            outputStream.close();
//            bufferedOutputStream.close(); // закрывается вместе с outputStream
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

        final String textFileName = "text.txt";

        // запись в файл
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(textFileName, true)))){
            printWriter.println("-----line.----");
        } catch (final IOException ioe){
            ioe.printStackTrace();
        }
        // чтение из файла
        try (FileInputStream fileInputStream = new FileInputStream(textFileName);
                Reader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)){
            while(reader.ready()){
                System.out.print((char)reader.read());
            }
        } catch (final IOException ioe){
            ioe.printStackTrace();
        }

        // запись в файл с помощью sout
        try (PrintStream logsWriter = new PrintStream("logs.txt")){
            System.setOut(logsWriter);
            System.out.println("Hello!");
        } catch (final IOException ioe){
            ioe.printStackTrace();
        }
    }
}

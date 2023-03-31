package copyFide;

import javafx.concurrent.Service;

import java.io.*;
import java.util.Scanner;

public class CopyFide {

    private static void copyFileUsingStream (File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os  = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0){
                os.write(buffer, 0, length);
            }
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("Nhập đường dẫn fide:");
        String sourcePath = in.nextLine();
        System.out.printf("Nhập đường dẫn fide tới:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
//            copyFileUsingJava7Files(sourceFile, destFile);
            copyFileUsingStream(sourceFile, destFile);
            System.out.printf("Sao chép thành công ");
        } catch (IOException ioe) {
            System.out.printf("Không tìm thấy fide cần sao chép ");
            System.out.printf(ioe.getMessage());
        }
    }


}

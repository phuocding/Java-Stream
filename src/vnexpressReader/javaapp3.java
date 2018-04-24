/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnexpressReader;

import java.io.*;
import java.net.*;
import java.nio.file.*;

/**
 *
 * @author TingFu
 */
public class javaapp3 {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL oracle = new URL("https://vnexpress.net");
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()))) {
            StringBuilder strB = new StringBuilder();
            String inputLine;
            File newFile = new File("./src/savePage/index.html");
            while ((inputLine = in.readLine()) != null) {
                strB.append(inputLine);
                strB.append("\n");
            }
            System.out.println(strB.toString());
            
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            FileWriter fw = new FileWriter(newFile.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(strB.toString());
            bw.close();            
        }
    }
}

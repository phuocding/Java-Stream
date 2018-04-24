/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vnexpressReader;

import java.io.*;
import java.net.*;

/**
 *
 * @author TingFu
 */
public class javaapp3 {

    public static void main(String[] args) throws MalformedURLException, IOException {
        try {
            URL oracle = new URL("https://vnexpress.net");
            StringBuilder strB = new StringBuilder();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()))) {
                String inputLine;
                File newFile = new File("./src/savePage/index.html");
                while ((inputLine = in.readLine()) != null) {
                    strB.append(inputLine);
                    strB.append("\n");
                }
            }

            String directoryName = "./src/savePage";
            File directory = new File(directoryName);
            if (!directory.exists()) {
                directory.mkdir();
            }

            File[] listOfFiles = directory.listFiles();
            int count = 0;
            for (File f : listOfFiles) {
                String strCount = f.getName().replace(".html", "").replace("index", "");
                try {
                    int currrentNumber = Integer.parseInt(strCount);
                    if (currrentNumber > count) {
                        count = currrentNumber;
                    }
                } catch (NumberFormatException e) {
                }
            }
            String fileName = "index" + (count + 1) + ".html";
            File file = new File(directoryName + "/" + fileName);

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(strB.toString());
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

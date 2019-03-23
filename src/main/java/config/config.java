package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class config {
    public final static HashMap<String, String> configMap = new HashMap<>();

    static {
        try {
            ReadLineOfFile(configMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     */
    public static void ReadLineOfFile(HashMap<String, String> configMap) throws IOException {
        String dir = config.class.getResource("message.config").getFile();
        File f = new File(dir);
        String s;
        if (!f.isDirectory()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String name = f.getName();
                while ((s = br.readLine()) != null) {
                    String[] strings = s.split("=");
                    if (strings.length != 2) {
                        System.out.println("---------parse error----------");
                        continue;
                    }
                    configMap.put(strings[0], strings[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

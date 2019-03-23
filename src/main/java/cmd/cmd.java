package cmd;

import config.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class cmd {
    //    public static void main(String[] args) {
    //        String command = "tf get \\$\\/projectX美术产品\\/产品\\/项目管理\\/每周修改表";
    //        System.out.println(
    //                cmd.exec(
    //                        command,
    //                        null,
    //                        new File("C:\\Program Files (x86)\\Microsoft Visual Studio
    // 10.0\\Common7\\IDE")));
    //    }
    public static void main(String[] args) throws InterruptedException {
//        boolean Arrays {true, true, false, false, true};
        Arrays.asList(true, true, false, false, true);
        System.out.println((int) Arrays.stream(Arrays.asList(true, true, false, false, true).toArray()).filter(has -> (boolean) has).count());
    }

    enum god {
        a, b, c;
    }

    LocalDate toLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        return instant.atZone(zoneId).toLocalDate();
    }

    public static StringBuffer exec(String command, String[] envp, File dir) {
        String line = null;
        StringBuffer sb = new StringBuffer();
        Runtime runtime = Runtime.getRuntime();
        String cmdDir = config.configMap.get("cmdDir");
        try {
            Process process = runtime.exec(command, envp, dir);
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return sb;
    }
}

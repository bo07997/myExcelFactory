package vsmodel;

import cmd.cmd;
import config.config;

import java.io.File;

public class VSService {
    public static StringBuffer getResource() {
        String traceRemote = config.configMap.get("traceRemote");
        String envPath = config.configMap.get("tfDir");
        String[] Strings = traceRemote.split("\\|");
        System.out.println(new File(envPath).isDirectory());
        StringBuffer stringBuffer = new StringBuffer();
        for (String p : Strings) {
            stringBuffer.append(cmd.exec(" tf get " + p, null, new File(envPath)));
        }
        return stringBuffer;
    }
}

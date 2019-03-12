package controller;

import com.bt.poon.excelfactory.convert.ConvertHandler;
import com.bt.poon.excelfactory.helper.ExcelFactoryLogger;

import java.io.File;

public class excelModelController {
    private static void execute(String fileName) {
        try {
            File file = (new File(fileName)).getParentFile();
            String dir = file == null ? null : file.getAbsolutePath();
            String oldDir = System.getProperty("user.dir");
            if (dir != null) {
                System.setProperty("user.dir", dir);
                ConvertHandler.convert(fileName);
            }

            if (oldDir != null) {
                System.setProperty("user.dir", oldDir);
            }
        } catch (Throwable var4) {
            ExcelFactoryLogger.logger.error("execute error", var4);
        }

    }
}

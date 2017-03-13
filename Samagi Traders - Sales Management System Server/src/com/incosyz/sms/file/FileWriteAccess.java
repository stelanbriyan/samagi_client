    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Date : Nov 15, 2015 Time : 1:23:35 AM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class FileWriteAccess {

    public boolean writeFile(String fileName, byte[] buffer) throws FileNotFoundException, IOException {
        String filePath = "./src/com/incosyz/sms/file/IMG/" + fileName;
        OutputStream os = new FileOutputStream(filePath);
        os.write(buffer);
        os.flush();
        os.close();
        return true;
    }

    public byte[] getFile(String fileName) throws FileNotFoundException, IOException {
        String filePath = "./src/com/incosyz/sms/file/IMG/" + fileName;;
        File file = new File(filePath);
        if (file.isFile()) {
            InputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            return buffer;
        }
        return null;
    }

    public byte[] getBackupFile(String fileName) throws FileNotFoundException, IOException {
        String filePath = "./src/com/incosyz/sms/file/backup/" + fileName;;
        File file = new File(filePath);
        if (file.isFile()) {
            InputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            return buffer;
        }
        return null;
    }
}

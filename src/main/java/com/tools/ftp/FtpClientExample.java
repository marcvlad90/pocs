package com.tools.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class FtpClientExample {

    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect("ftp.dlptest.com", 21);
            ftpClient.login("dlpuser", "rNrKYTX9g7z3RgJRmxWuGHbeu");
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File LocalFile = new File("src/test/resources/xml/camt053Copy.xml").getAbsoluteFile();

            String remoteFile = "camt053Copy.xml";
            InputStream inputStream = new FileInputStream(LocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(remoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded using FTP successfully.");
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();

        } finally {

            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}

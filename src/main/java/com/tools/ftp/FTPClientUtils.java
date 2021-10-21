package com.tools.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPClientUtils {

    public static FTPClient getConnectedFTPClient(String host, int port, String user, String password) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("ftp.dlptest.com", 21);
            ftpClient.login("dlpuser", "rNrKYTX9g7z3RgJRmxWuGHbeu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ftpClient.enterLocalPassiveMode();
        return ftpClient;
    }

    public static void uploadFileOnFTPClient(FTPClient ftpClient, String filePath, String fileName) {
        try {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File LocalFile = new File(filePath + fileName).getAbsoluteFile();

            String remoteFile = fileName;
            InputStream inputStream = new FileInputStream(LocalFile);

            System.out.println("Start uploading file");
            boolean done = ftpClient.storeFile(remoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The file was uploaded using FTP successfully.");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    public static void disconnectFromFTPClient(FTPClient ftpClient) {
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


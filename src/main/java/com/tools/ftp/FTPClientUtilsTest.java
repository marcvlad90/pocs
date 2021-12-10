package com.tools.ftp;

import org.apache.commons.net.ftp.FTPClient;

public class FTPClientUtilsTest {

    public static void main(String[] args) {
        FTPClient ftpClient = FTPClientUtils.getConnectedFTPClient("ftp.dlptest.com", 21, "dlpuser", "rNrKYTX9g7z3RgJRmxWuGHbeu");
        FTPClientUtils.uploadFileOnFTPClient(ftpClient, "src/test/resources/xml/", "camt053.xml");
        FTPClientUtils.uploadFileOnFTPClient(ftpClient, "src/test/resources/xml/", "camt053Copy.xml");
        FTPClientUtils.downloadFileFromFTPClient(ftpClient, "src/test/resources/xml/", "camt053Copy.xml");
        FTPClientUtils.disconnectFromFTPClient(ftpClient);
    }
}

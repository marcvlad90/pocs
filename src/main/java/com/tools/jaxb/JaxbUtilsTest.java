package com.tools.jaxb;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import com.tools.jaxb.iso.std.iso._20022.tech.xsd.camt_053_001.Document;

public class JaxbUtilsTest {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Document document = JaxbUtils.convertXmlToObject("camt053.xml", Document.class);
        System.out.println("Original xml msgId field value: " + document.getBkToCstmrStmt().getGrpHdr().getMsgId());
        document.getBkToCstmrStmt().getGrpHdr().setMsgId("qwerty123");
        JaxbUtils.convertObjectToXml(document, "camt053Copy.xml");
        Document document2 = JaxbUtils.convertXmlToObject("camt053Copy.xml", Document.class);
        System.out.println("New xml msgId field value: " + document2.getBkToCstmrStmt().getGrpHdr().getMsgId());
    }

}

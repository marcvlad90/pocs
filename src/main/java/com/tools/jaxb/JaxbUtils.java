package com.tools.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtils {
    public static void convertObjectToXml(Object object, String fileName) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/xml/" + fileName);
            marshaller.marshal(object, fileOutputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception while marshalling: %s", e.getMessage()));
        }
    }

    public static <T> T convertXmlToObject(String fileName, Class<T> clazz) {
        try {
            File file = new File("src/test/resources/xml/" + fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            @SuppressWarnings("unchecked")
            T obj = (T)JAXBIntrospector.getValue(jaxbUnmarshaller.unmarshal(file));
            return obj;
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception while Unmarshaller: %s", e.getMessage()));
        }
    }
}

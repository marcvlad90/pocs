//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.09.29 at 11:11:55 AM EEST 
//


package com.tools.jaxb.iso.std.iso._20022.tech.xsd.camt_053_001;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OnLineCapability1Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OnLineCapability1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OFLN"/>
 *     &lt;enumeration value="ONLN"/>
 *     &lt;enumeration value="SMON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OnLineCapability1Code")
@XmlEnum
public enum OnLineCapability1Code {

    OFLN,
    ONLN,
    SMON;

    public String value() {
        return name();
    }

    public static OnLineCapability1Code fromValue(String v) {
        return valueOf(v);
    }

}

package com.ryan.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="SumRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class SumRequest {

    // The key is XmlAccessType. The XmlElement is optional
    // the only reason you mark the fields is that you want to customize the name
    @XmlElement(name="num1")
    private int num1;

    @XmlElement(name="num2")
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}

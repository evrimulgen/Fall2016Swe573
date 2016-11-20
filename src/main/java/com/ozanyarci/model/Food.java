package com.ozanyarci.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "item")
@XmlAccessorType (XmlAccessType.FIELD)
public class Food 
{
    private String group;
    private String name;
    private String ndbno;
     
    public String getGroup() {
		return group;
	}
 
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNdbno() {
		return ndbno;
	}
 
	public void setNdbno(String ndbno) {
		this.ndbno = ndbno;
	}
}

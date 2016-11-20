package com.ozanyarci.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "list")
@XmlAccessorType (XmlAccessType.FIELD)
public class AllFoods 
{
    @XmlElement(name = "item")
    private List<Food> foods = null;
 
    public List<Food> getFoods() {
        return foods;
    }
 
    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}

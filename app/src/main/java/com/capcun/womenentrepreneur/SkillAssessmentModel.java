package com.capcun.womenentrepreneur;

public class SkillAssessmentModel {

    String name,desc,day_left,price;

    public SkillAssessmentModel(String name, String desc, String day_left, String price) {
        this.name = name;
        this.desc = desc;
        this.day_left = day_left;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDay_left() {
        return day_left;
    }

    public void setDay_left(String day_left) {
        this.day_left = day_left;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

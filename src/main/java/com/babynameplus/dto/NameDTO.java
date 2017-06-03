package com.babynameplus.dto;

/**
 * Created by spio10 on 2017-06-03.
 */
public class NameDTO {

    private String name;
    private String sex;
    private String origin;
    private String description;
    private String nameday;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameday() {
        return nameday;
    }

    public void setNameday(String nameday) {
        this.nameday = nameday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public NameDTO() {
    }
}

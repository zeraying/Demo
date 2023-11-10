package JDBC;

import java.sql.Blob;
import java.util.Objects;

/**
 * @author pzy
 * @create 2023-10-29-21:28
 * @function
 */
public class testClass {
    private int id;
    private String name;
    private String sex;
    private Blob picture;

    public testClass() {
    }

    public testClass(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public testClass(int id, String name, String sex, Blob picture) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof testClass testClass)) return false;
        return id == testClass.id && picture == testClass.picture && Objects.equals(name, testClass.name) && Objects.equals(sex, testClass.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, picture);
    }

    @Override
    public String toString() {
        return "testClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", picture=" + picture +
                '}';
    }
}

package models;

import java.util.Objects;

public class News {
    private int id;
    private String headline;
    private String content;
    private  int departmentid;

    public News( String headline,String content, int departmentid) {
        this.headline = headline;
        this.content = content;
        this.departmentid = departmentid;
    }

    public int getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
//equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                departmentid == news.departmentid &&
                headline.equals(news.headline) &&
                content.equals(news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, headline, content, departmentid);
    }
}

package bean;

import java.io.Serializable;

public class CommentBean implements Serializable {
    private int id;
    private String name;
    private int imgsrc;
    private String comment;
    private static final long serialVersionUID = 2L;

    public CommentBean(int id, String name , int imgsrc , String comment){
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.imgsrc = imgsrc;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public int getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(int imgsrc) {
        this.imgsrc = imgsrc;
    }
}
package bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ProductBean implements Serializable {
    private int id;
    private String netid;
    private String name;
    private String cast;
    private String des;
    private int imgsrc;
    private String netimgsrc;
    private static final long serialVersionUID = 1L;

    public ProductBean(String vname, String vcast, int vimgsrc){
        this.name = vname;
        this.cast = vcast;
        this.imgsrc = vimgsrc;

    }

    public ProductBean(String vname, String vcast,int vimgsrc ,String des){
        this.name = vname;
        this.cast = vcast;
        this.imgsrc = vimgsrc;
        this.des = des;
    }

    public ProductBean(int id,String vname, String vcast,String netimgsrc){
        this.id = id;
        this.name = vname;
        this.cast = vcast;
        this.netimgsrc = netimgsrc;
    }

    public ProductBean(String sJson){
        System.out.print(sJson);
        String[] arrayString = sJson.split(",");
        String netid = arrayString[0].substring(arrayString[0].indexOf("'")+1, arrayString[0].lastIndexOf("'"));
        String name = arrayString[1].substring(arrayString[1].indexOf("'")+1, arrayString[1].lastIndexOf("'"));
        String cast = arrayString[2].substring(arrayString[2].indexOf("'")+1, arrayString[2].lastIndexOf("'"));
        String netimgsrc = arrayString[3].substring(arrayString[3].indexOf("'")+1, arrayString[3].lastIndexOf("'"));
        this.netid = netid;
        this.name = name;
        this.cast = cast;
        this.netimgsrc = netimgsrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(int imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}


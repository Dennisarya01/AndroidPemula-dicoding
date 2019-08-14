package com.dicoding.traditionalfoodindonesian.model;

public class Food {

    private String nameFood;
    private String photoFood;
    private String author;
    private String id;
    private String bahanMakanan;
    private String bumbuMakanan;
    private String pelengkap;
    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getPhotoFood() {
        return photoFood;
    }

    public void setPhotoFood(String photoFood) {
        this.photoFood = photoFood;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBahanMakanan() {
        return bahanMakanan;
    }

    public void setBahanMakanan(String bahanMakanan) {
        this.bahanMakanan = bahanMakanan;
    }

    public String getBumbuMakanan() {
        return bumbuMakanan;
    }

    public void setBumbuMakanan(String bumbuMakanan) {
        this.bumbuMakanan = bumbuMakanan;
    }

    public String getPelengkap() {
        return pelengkap;
    }

    public void setPelengkap(String pelengkap) {
        this.pelengkap = pelengkap;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

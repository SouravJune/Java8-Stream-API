package com.souravjune.author_book;

public class Author {

    private String authorName;
    private String authorEmailId;
    private int age;
    private char gender;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmailId() {
        return authorEmailId;
    }

    public void setAuthorEmailId(String authorEmailId) {
        this.authorEmailId = authorEmailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Author(String authorName, String authorEmailId, int age, char gender) {
        this.authorName = authorName;
        this.authorEmailId = authorEmailId;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", authorEmailId='" + authorEmailId + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

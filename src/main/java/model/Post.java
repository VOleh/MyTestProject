package model;

import java.util.List;

public class Post {
    private String author;
    private String comments;
    private String photo;
    private String created;

    public Post() {
    }


    public Post(String author, String comments, String created) {
        this.author = author;
        this.comments = comments;
        this.created = created;
    }

    public Post(String author, String comments, String photo, String created) {
        this.author = author;
        this.comments = comments;
        this.photo = photo;
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", comments='" + comments + '\'' +
                ", photo=" + photo +
                ", created='" + created + '\'' +
                '}';
    }
}

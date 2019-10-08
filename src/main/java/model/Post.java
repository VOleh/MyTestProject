package model;

import java.util.List;

public class Post {
    private User author;
    private String comments;
    private List<String> photo;
    private String created;

    public Post() {
    }

    public Post(User author, String comments, String created) {
        this.author = author;
        this.comments = comments;
        this.created = created;
    }

    public Post(User author, String comments, List<String> photo, String created) {
        this.author = author;
        this.comments = comments;
        this.photo = photo;
        this.created = created;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
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

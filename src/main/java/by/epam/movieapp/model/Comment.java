package by.epam.movieapp.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Olga Shahray
 */
public class Comment {
    private int id;
    private User user;
    private Film film;
    private int mark;
    private String comment;
    private LocalDateTime dateComment = LocalDateTime.now();
    private CommentStatus status;

    public Comment() {
    }

    public Comment(User user, Film film, int mark, String comment, LocalDateTime dateComment, CommentStatus status) {
        this.user = user;
        this.film = film;
        this.mark = mark;
        this.comment = comment;
        this.dateComment = dateComment;
        this.status = status;
    }

    public Comment(int id, int mark, String comment, LocalDateTime dateComment, CommentStatus status) {
        this.id = id;
        this.mark = mark;
        this.comment = comment;
        this.dateComment = dateComment;
        this.status = status;
    }

    public Comment(int id, int mark, String comment, CommentStatus status) {
        this.id = id;
        this.mark = mark;
        this.comment = comment;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateComment() {
        return dateComment;
    }

    public void setDateComment(LocalDateTime dateComment) {
        this.dateComment = dateComment;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        Comment otherComment = (Comment) o;
        return id == otherComment.id &&
                mark == otherComment.mark &&
                Objects.equals(user, otherComment.user) &&
                Objects.equals(film, otherComment.film) &&
                Objects.equals(comment, otherComment.comment) &&
                Objects.equals(dateComment, otherComment.dateComment) &&
                status == otherComment.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, film, mark, comment, dateComment, status);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", mark=" + mark +
                ", comment='" + comment + '\'' +
                ", dateComment=" + dateComment +
                ", status=" + status +
                '}';
    }

    public boolean isNew() {
        return id == 0;
    }
}

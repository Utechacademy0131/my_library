package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "books")
@NamedQueries({
    @NamedQuery(
            name = "getAllBooks",
            query = "SELECT b FROM Book AS b ORDER BY b.id DESC"
            ),
    @NamedQuery(
            name = "getBooksCount",
            query = "SELECT COUNT(b) FROM Book AS b"
            ),
})
@Entity
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_date", nullable = false)
    private Date book_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "writer_date", length = 255,  nullable = false)
    private Date writer_date;

    @Column(name = "publisher_date", length = 255, nullable = false)
    private Date publisher_date;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBook_date() {
        return book_date;
    }

    public void setBook_date(Date book_date) {
        this.book_date = book_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getWriter_date() {
        return writer_date;
    }

    public void setWriter_date(Date writer_date) {
        this.writer_date = writer_date;
    }

    public Date getPublisher_date() {
        return publisher_date;
    }

    public void setPublisher_date(Date publisher_date) {
        this.publisher_date = publisher_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
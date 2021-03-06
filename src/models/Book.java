package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    @NamedQuery(
            name = "getMyAllBooks",
            query = "SELECT b FROM Book AS b WHERE b.admin = :admin ORDER BY b.id DESC"
            ),
    @NamedQuery(
            name = "getMyBooksCount",
            query = "SELECT COUNT(b) FROM Book AS b WHERE b.admin = :admin"
            ),
    @NamedQuery(
            name = "getSearchBooks",
            query = "SELECT b FROM Book AS b WHERE b.title LIKE :keyword"
            ),
    @NamedQuery(
            name = "getSearchBooksCount",
            query = "SELECT COUNT(b) FROM Book AS b WHERE b.title LIKE :keyword"
            ),

})
@Entity
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "admin_name", nullable = false)
    private Admin admin;

    @Column(name = "book_date", nullable = false)
    private Date book_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "writer", length = 255,  nullable = false)
    private String writer;

    @Column(name = "publisher", length = 255, nullable = false)
    private String publisher;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "book_flag", nullable = false)
    private Integer book_flag;

    public Integer getBook_flag() {
        return book_flag;
    }

    public void setBook_flag(Integer book_flag) {
        this.book_flag = book_flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
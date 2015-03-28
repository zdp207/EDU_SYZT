package com.syzton.sunread.model.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.syzton.sunread.model.bookshelf.BookInShelf;
import com.syzton.sunread.model.common.AbstractEntity;
import com.syzton.sunread.util.DateSerializer;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jerry zhang
 */
@Entity
@Table(name="book")
@JsonIgnoreProperties(value = { "reviews","categories","booksInShelf"})
public class Book extends AbstractEntity{

    public static final int MAX_LENGTH_DESCRIPTION = 500;
    public static final int MAX_LENGTH_NAME = 50;
    public static final int MAX_LENGTH_ISBN = 16;
    public static final int MAX_LENGTH_AUTHOR = 10;
    public static final int MAX_LENGTH_PUBLISHER = 50;

    public static final int DEFAULT_POINT = 5;
    public static final int DEFAULT_COIN = 5;
    private static final String DEFAULT_PICTURE_URL = "ftp://default_book_picture" ;


    @Column(nullable = true, length = MAX_LENGTH_DESCRIPTION)
    private String description;

    @JsonSerialize(using = DateSerializer.class)
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;

    @JsonSerialize(using = DateSerializer.class)
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime publicationDate;

    @Column(name="name",nullable = false,length = MAX_LENGTH_NAME)
    private String name;

    @Column(name ="isbn",unique = true,nullable = false,length = MAX_LENGTH_ISBN)
    private String isbn;


    @Column(nullable = false,length = MAX_LENGTH_AUTHOR)
    private String author;

    @Column(nullable = false,length = MAX_LENGTH_PUBLISHER)
    private String publisher;

    private int pageCount;

    private int wordCount;

    private int point = DEFAULT_POINT;

    private int coin = DEFAULT_COIN;

    private String pictureUrl = DEFAULT_PICTURE_URL;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    private BookExtra extra;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private Set<Review> reviews = new HashSet<>() ;

    @OneToMany( cascade = {CascadeType.MERGE,CascadeType.REFRESH},mappedBy = "book")
    @Basic(fetch = FetchType.EAGER)
    private Set<BookInShelf> booksInShelf = new HashSet<BookInShelf>();

    public Book() {

    }
    
    public Set<BookInShelf> getBooksInShelf(){    	
    	return booksInShelf;
    }

    public String getDescription() {
        return description;
    }

    public DateTime getModificationTime() {
        return modificationTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setModificationTime(DateTime modificationTime) {
        this.modificationTime = modificationTime;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public BookExtra getExtra() {
        return extra;
    }

    public void setExtra(BookExtra extra) {
        this.extra = extra;
    }

    public DateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(DateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    @PrePersist
    public void prePersist() {
        super.prePersist();
        DateTime now = DateTime.now();
        modificationTime = now;

    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = DateTime.now();
    }


}

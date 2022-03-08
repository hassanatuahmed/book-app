package com.example.books;//package com.example.books;




import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class SampleResponse{
    private String status;
    private String copyright;
    private float num_results;
    private String last_modified;
    Results results;


    // Getter Methods

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public float getNum_results() {
        return num_results;
    }

    public String getLast_modified() {
        return last_modified;
    }



    // Setter Methods

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setNum_results(float num_results) {
        this.num_results = num_results;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
  class Results {
    private String list_name;
    private String list_name_encoded;
    private String bestsellers_date;
    private String published_date;
    private String published_date_description;
    private String next_published_date;
    private String previous_published_date;
    private String display_name;
    private float normal_list_ends_at;
    private String updated;
    private List<Books> books = new ArrayList<>();

      public List<Books> getBooks() {
          return books;
      }

      public void setBooks(List<Books> books) {
          this.books = books;
      }

      //    ArrayList< Object > books = new ArrayList < Object > ();
      Books BooksObject;

      public Books getBooksObject() {
          return BooksObject;
      }

      public void setBooksObject(Books booksObject) {
          BooksObject = booksObject;
      }
// Getter Methods

    public String getList_name() {
        return list_name;
    }

    public String getList_name_encoded() {
        return list_name_encoded;
    }

    public String getBestsellers_date() {
        return bestsellers_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getPublished_date_description() {
        return published_date_description;
    }

    public String getNext_published_date() {
        return next_published_date;
    }

    public String getPrevious_published_date() {
        return previous_published_date;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public float getNormal_list_ends_at() {
        return normal_list_ends_at;
    }

    public String getUpdated() {
        return updated;
    }

    // Setter Methods

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public void setList_name_encoded(String list_name_encoded) {
        this.list_name_encoded = list_name_encoded;
    }

    public void setBestsellers_date(String bestsellers_date) {
        this.bestsellers_date = bestsellers_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public void setPublished_date_description(String published_date_description) {
        this.published_date_description = published_date_description;
    }

    public void setNext_published_date(String next_published_date) {
        this.next_published_date = next_published_date;
    }

    public void setPrevious_published_date(String previous_published_date) {
        this.previous_published_date = previous_published_date;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setNormal_list_ends_at(float normal_list_ends_at) {
        this.normal_list_ends_at = normal_list_ends_at;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}

class Books{
    private String title;
    private String author;
    private String publisher;
    private String description;
    private String price;
    private String book_image;

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
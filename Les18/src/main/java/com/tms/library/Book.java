package com.tms.library;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString

public class Book{
    private int id;
    private String name;
    private List<Author> authors;
    private String genre;
    private String isbn;


}

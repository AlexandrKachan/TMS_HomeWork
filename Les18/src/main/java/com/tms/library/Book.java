package com.tms.library;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString

public class Book{
    private int id;
    private String name;
    private int author;
    private String isbn;


}

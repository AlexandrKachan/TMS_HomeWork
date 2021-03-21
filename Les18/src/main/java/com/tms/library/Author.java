package com.tms.library;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Author {
    private int id;
    private String first_name;
    private String last_name;

}

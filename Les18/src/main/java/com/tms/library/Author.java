package com.tms.library;

import lombok.Builder;
import lombok.Data;


@Data

@Builder



public class Author {


    private Integer id;
    private String firstName;
    private String lastName;

}

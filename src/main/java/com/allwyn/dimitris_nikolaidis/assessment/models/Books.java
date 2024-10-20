package com.allwyn.dimitris_nikolaidis.assessment.models;

import lombok.AllArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
public class Books implements Serializable {


    private int id;
    private String title;
    private String description;
    private int pageCount;
    private String excerpt;
    private String publishDate;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"title\":\"" + title + '\"' +
                ", \"description\":\"" + description + '\"' +
                ", \"pageCount\":" + pageCount +
                ", \"excerpt\":\"" + excerpt + '\"' +
                ", \"publishDate\":\"" + publishDate + '\"' +
                '}';
    }
}

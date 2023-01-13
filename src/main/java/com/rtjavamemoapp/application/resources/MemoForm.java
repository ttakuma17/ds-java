package com.rtjavamemoapp.application.resources;

import lombok.Data;

@Data
public class MemoForm {

    private int id;
    private String title;
    private String description;
    private String category;
    private String date;
    private int mark_div;
    
}

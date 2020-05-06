package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class FilmItem{
    private int id;
    private String name;
    private String type;
}

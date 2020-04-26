package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmItem;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmManager {

    private FilmItem[] films = new FilmItem[0];
    private int lengthOfFilms = 10;

    public FilmManager(int lengthOfFilms) {
        this.lengthOfFilms = lengthOfFilms;
    }
    public void FilmAdd(FilmItem film) {
        int length = films.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmItem[] getAll() {
        if (lengthOfFilms > films.length) {
            lengthOfFilms = films.length;
        }
        FilmItem[] result = new FilmItem[lengthOfFilms];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
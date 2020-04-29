package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmItem;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmRepository {

    private FilmItem[] films = new FilmItem[0];

    public FilmItem[] findAll() {
        return films;
    }

    public FilmItem findById(int id) {
        int length = 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem film : films) {
            if (film.getId() == id) {
                tmp[index] = film;
                index++;
            }
            films = tmp;
        }
        return null;
    }

    public void save(FilmItem film) {
        int length = films.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        FilmItem[] tmp = new FilmItem[length];
        int index = 0;
        for (FilmItem film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
            index++;
        }
    }

    films =tmp;

    }

    public void removeAll() {
        films = new FilmItem[0];
    }
}
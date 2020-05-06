package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.FilmManager;

class FilmManagerDefaultTest {
    FilmManager manager;
    FilmItem first = new FilmItem(1, "Бладшот", "боевик");
    FilmItem second = new FilmItem(2, "Вперёд", "мультфильм");
    FilmItem third = new FilmItem(3, "Отель Белград", "комедия");
    FilmItem fourth = new FilmItem(4, "Джентельмены", "боевик");
    FilmItem fifth = new FilmItem(5, "Человек-невидимка", "ужасы");
    FilmItem sixth = new FilmItem(6, "Тролли", "мультфильм");
    FilmItem seventh = new FilmItem(7, "1+1", "драма");
    FilmItem eighth = new FilmItem(8, "Легенда", "триллер");
    FilmItem ninth = new FilmItem(9, "Волк с Уолл-Стрит", "драма");
    FilmItem tenth = new FilmItem(10, "Брат 2", "драма");
    FilmItem eleventh = new FilmItem(11, "Малифисента", "фэнтези");

    @BeforeEach
    void setup() {
        manager = new FilmManager();

    }

    @Test
    void shouldDisplayLastTenIfTen() {
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayLastTenIfMore() {
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayLastOneIfOne() {
        manager.filmAdd(first);
        FilmItem[] expected = new FilmItem[]{first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotDisplayFilmsIfNoFilms() {
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
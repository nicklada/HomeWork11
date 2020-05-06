package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerAskedIrrelevantTest {
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

    @Test
    void shouldDisplayTenAsByDefaultIfZero() {
        manager = new FilmManager(0);
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
    void shouldDisplayTenAsByDefaultIfLessZero() {
        manager = new FilmManager(-1);
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
    void shouldDisplayLastOneAsByDefaultIfZero() {
        manager = new FilmManager(0);
        manager.filmAdd(first);
        FilmItem[] expected = new FilmItem[]{first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldDisplayOneAsByDefaultIfLessZero() {
        manager = new FilmManager(-1);
        manager.filmAdd(first);
        FilmItem[] expected = new FilmItem[]{first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
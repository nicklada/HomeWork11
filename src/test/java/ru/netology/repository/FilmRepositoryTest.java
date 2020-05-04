package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    FilmRepository repository = new FilmRepository();
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


    @Test
    void shouldSave() {
        repository.save(first);
        FilmItem[] expected = new FilmItem[]{first};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturn() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        FilmItem[] expected = new FilmItem[]{first, second, third, fourth, fifth};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmpty() {
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        int idToFind = 2;
        repository.findById(idToFind);
        FilmItem[] expected = new FilmItem[]{second};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldReturnNullIfNotExists() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        int idToFind = 5;
        FilmItem[] returned = new FilmItem[]{null};
        repository.findById(idToFind);
        FilmItem[] expected = new FilmItem[]{null};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove =1;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(idToRemove);
        FilmItem[] actual = repository.findAll();
        FilmItem[] expected = new FilmItem[]{second,third};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(idToRemove);
        FilmItem[] expected = new FilmItem[]{first, second,third};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeAll();
        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}

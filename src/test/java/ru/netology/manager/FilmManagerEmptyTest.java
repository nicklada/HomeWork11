package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmManagerEmptyTest {
    @Mock
    FilmRepository repository;
    FilmManager manager = new FilmManager(repository,0);
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
        manager = new FilmManager(repository,0);
    }

    @Test
    void shouldAdd() {
        doReturn(new FilmItem[]{first}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{first};
        FilmItem[] actual = manager.getSaved();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();

    }

    @Test
    void shouldNotDisplayFilmsIfNoFilms() {
        doReturn(new FilmItem[]{}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldNotDisplayFilmsIfFilms() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth,tenth}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}

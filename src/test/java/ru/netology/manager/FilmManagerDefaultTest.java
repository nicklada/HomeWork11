package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

@ExtendWith(MockitoExtension.class)
class FilmManagerDefaultTest {
    @Mock
    FilmRepository repository;
    @InjectMocks
    FilmManager manager = new FilmManager(repository);
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
        manager = new FilmManager(repository);
    }

    @Test
    void shouldDisplayLastTenIfTen() {
        FilmItem[] returned = new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldDisplayLastTenIfMore() {
        FilmItem[] returned = new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldDisplayLastOneIfOne() {
        FilmItem[] returned = new FilmItem[]{first};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldNotDisplayFilmsIfNoFilms() {
        FilmItem[] returned = new FilmItem[]{};
        doReturn(returned).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository, times(1)).findAll();
    }
}


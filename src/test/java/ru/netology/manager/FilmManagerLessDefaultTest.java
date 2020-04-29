package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.manager.FilmManager;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FilmManagerManagerLessDefaultTest {
    @Mock
    FilmRepository repository;
    FilmManager manager = new FilmManager(repository,5);
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
        manager = new FilmManager(repository,5);
        manager.FilmAdd(first);
        manager.FilmAdd(second);
        manager.FilmAdd(third);

    }

    @Test
    void shouldDisplayLastFiveIfFive() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldDisplayLastFiveIfMore() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh};
        FilmItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldDisplayLastThreeIfThree() {
        doReturn(new FilmItem[]{first, second, third}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{third, second, first};
        FilmItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}
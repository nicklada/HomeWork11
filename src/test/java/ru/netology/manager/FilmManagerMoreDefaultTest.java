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
class FilmManagerMoreDefaultTest {
    @Mock
    FilmRepository repository;
    FilmManager manager = new FilmManager(repository,11);
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
    FilmItem twelfth = new FilmItem(12, "Джуманджи", "приключения");

    @BeforeEach
    void setup() {
        manager = new FilmManager(repository,11);
        manager.FilmAdd(first);
        manager.FilmAdd(second);
        manager.FilmAdd(third);
        manager.FilmAdd(fourth);
        manager.FilmAdd(fifth);
        manager.FilmAdd(sixth);
        manager.FilmAdd(seventh);
        manager.FilmAdd(eighth);
        manager.FilmAdd(ninth);

    }

    @Test
    void shouldDisplayLastElevenIfEleven() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        FilmItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldDisplayLastElevenIfMore() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        FilmItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldDisplayLastNine() {
        doReturn(new FilmItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth}).when(repository).findAll();

        FilmItem[] expected = new FilmItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second,first};
        FilmItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}
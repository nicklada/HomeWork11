package ru.netology.manager;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

public class FilmManager {

    private FilmRepository repository;
    private int defaultlengthOfFilms = 10;
    private int lengthOfFilms;

    public FilmManager(FilmRepository repository) {
        this.repository = repository;
    }

    public FilmManager(FilmRepository repository, int lengthOfFilms) {
        this.repository = repository;
        this.lengthOfFilms = lengthOfFilms;
    }

    public void filmAdd(FilmItem film) {
        repository.save(film);
    }

    public FilmItem[] getAll() {
        FilmItem [] filmsInRepo = repository.findAll();
        int askedFilms = filmsInRepo.length;

        if (lengthOfFilms <= 0) {
            if (defaultlengthOfFilms < filmsInRepo.length) {
                askedFilms = defaultlengthOfFilms;
            }
        } else {
            if (lengthOfFilms < filmsInRepo.length) {
                askedFilms = lengthOfFilms;
            }
        }

        FilmItem[] result = new FilmItem[askedFilms];
        for (int i = 0; i < result.length; i++) {
            int index = filmsInRepo.length - i - 1;
            result[i] = filmsInRepo[index];
        }
        return result;
    }
}
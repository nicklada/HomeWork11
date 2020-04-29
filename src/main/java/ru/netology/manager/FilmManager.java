package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmItem;
import ru.netology.repository.FilmRepository;

@AllArgsConstructor
@NoArgsConstructor

public class FilmManager {
    private FilmRepository repository = new FilmRepository();
    private int lengthOfFilms = 10;
    public FilmManager(FilmRepository repository){
        this.repository=repository;
    }


    public void FilmAdd(FilmItem film) {
        repository.save(film);
    }

    public FilmItem[] getSaved (){
       return repository.findAll();
    }


    public FilmItem[] getAll() {
        FilmItem[] filmsFromRepo = repository.findAll();
        if (filmsFromRepo.length < lengthOfFilms) {
            lengthOfFilms = filmsFromRepo.length;
        }
        FilmItem[] result = new FilmItem[lengthOfFilms];
        for (int i = 0; i < result.length; i++) {
            int index = filmsFromRepo.length - i - 1;
            result[i] = filmsFromRepo[index];
        }
        return result;
    }
}
package info.jab.ms.service;

import info.jab.ms.repository.FilmRepository;
import info.jab.ms.service.dto.FilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<FilmDTO> getFilms() {
        return filmRepository.myQuery().stream()
                .map(f -> new FilmDTO(f.FILM_ID(), f.TITLE()))
                .toList();
    }
}

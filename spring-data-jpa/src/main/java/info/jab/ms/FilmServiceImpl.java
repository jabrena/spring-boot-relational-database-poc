package info.jab.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<FilmDTO> getFilms() {
        return filmRepository.findAll().stream()
                .filter(f -> f.getTitle().startsWith("A"))
                .map(f -> new FilmDTO(f.getFilm_id(), f.getTitle()))
                //.peek(System.out::println)
                .toList();
    }
}

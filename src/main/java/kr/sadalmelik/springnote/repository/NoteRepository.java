package kr.sadalmelik.springnote.repository;

import kr.sadalmelik.springnote.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
    Note findByUrlPath(String urlPath);
}

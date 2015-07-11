package kr.sadalmelik.springnote.service;

import kr.sadalmelik.springnote.repository.NoteRepository;
import kr.sadalmelik.springnote.repository.PageRepository;
import kr.sadalmelik.springnote.util.parser.MarkdownParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl{

    @Autowired
    PageRepository pageRepository;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    MarkdownParser markdownParser;

}

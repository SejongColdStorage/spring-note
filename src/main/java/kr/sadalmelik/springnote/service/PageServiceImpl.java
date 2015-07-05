package kr.sadalmelik.springnote.service;

import kr.sadalmelik.springnote.domain.Page;
import kr.sadalmelik.springnote.repository.PageRepository;
import kr.sadalmelik.springnote.util.parser.MarkdownParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class PageServiceImpl{

    @Autowired
    PageRepository pageRepository;

    @Autowired
    MarkdownParser markdownParser;



}

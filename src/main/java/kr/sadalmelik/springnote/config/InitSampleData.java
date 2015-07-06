package kr.sadalmelik.springnote.config;

import kr.sadalmelik.springnote.domain.Note;
import kr.sadalmelik.springnote.domain.Page;
import kr.sadalmelik.springnote.repository.NoteRepository;
import kr.sadalmelik.springnote.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;

@Configuration
public class InitSampleData {

    @Autowired
    PageRepository pageRepository;

    @Autowired
    NoteRepository noteRepository;

    @PostConstruct
    public void initPages() {
        Date current = new Date();

        Note note = new Note();
        note.setName("Spring data JPA");
        note.setUrlPath("spring-data-jpa");

        Page indexPage = new Page("index", note, 0, current, "<h1>index</h1>", "# index");
        Page metaData = new Page("Project metadata",note,  1, new Date(), "<h1>Project metadata</h1>", "# Project metadata");
        Page dependencies = new Page("Dependencies",note,  2, new Date(), "<h1>Dependencies</h1>", "# Dependencies");
        Page springBoot = new Page("Dependency management with Spring Boot", note, 3, new Date(), "<h1>Dependency management with Spring Boot</h1>", "# Dependency management with Spring Boot");
        Page springFramework = new Page("Spring Framework",note,  4, new Date(), "<h1>Spring Framework</h1>", "# Spring Framework");

        indexPage.getChildPages().add(metaData);
        indexPage.getChildPages().add(dependencies);
        metaData.setParentPage(indexPage);
        dependencies.setParentPage(indexPage);

        dependencies.getChildPages().add(springBoot);
        dependencies.getChildPages().add(springFramework);
        springBoot.setParentPage(dependencies);
        springFramework.setParentPage(dependencies);

        noteRepository.save(note);
        pageRepository.save(indexPage);
        pageRepository.save(metaData);
        pageRepository.save(dependencies);
        pageRepository.save(springBoot);
        pageRepository.save(springFramework);
    }

}

package kr.sadalmelik.springnote.config;

import kr.sadalmelik.springnote.domain.Note;
import kr.sadalmelik.springnote.domain.Page;
import kr.sadalmelik.springnote.domain.PageContents;
import kr.sadalmelik.springnote.domain.PageHistory;
import kr.sadalmelik.springnote.repository.NoteRepository;
import kr.sadalmelik.springnote.repository.PageHistoryRepository;
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
    PageHistoryRepository pageHistoryRepository;

    @Autowired
    NoteRepository noteRepository;


    @PostConstruct
    public void initPages() {
        Date current = new Date();

        Note note = new Note();
        note.setName("Spring data JPA");
        note.setUrlPath("spring-data-jpa");

        noteRepository.save(note);

        Page indexPage = new Page("index", note, 0, current, "<h1>index</h1>", "# index");
        Page metaData = new Page("Project metadata",note,  1, current, "<h1>Project metadata</h1>", "# Project metadata");
        Page dependencies = new Page("Dependencies",note,  2, current, "<h1>Dependencies</h1>", "# Dependencies");
        Page springBoot = new Page("Dependency management with Spring Boot", note, 3, current, "<h1>Dependency management with Spring Boot</h1>", "# Dependency management with Spring Boot");
        Page springFramework = new Page("Spring Framework",note,  4, current, "<h1>Spring Framework</h1>", "# Spring Framework");

        indexPage.getChildPages().add(metaData);
        indexPage.getChildPages().add(dependencies);
        metaData.setParentPage(indexPage);
        dependencies.setParentPage(indexPage);

        dependencies.getChildPages().add(springBoot);
        dependencies.getChildPages().add(springFramework);
        springBoot.setParentPage(dependencies);
        springFramework.setParentPage(dependencies);

        pageRepository.save(indexPage);
        pageRepository.save(metaData);
        pageRepository.save(dependencies);
        pageRepository.save(springBoot);
        pageRepository.save(springFramework);

        PageHistory metaData_1 = new PageHistory();
        metaData_1.setPage(metaData);
        metaData_1.setContents(new PageContents("index", current, "<h1>index000</h1>", "# index000"));
        metaData_1.setVersion(1);

        PageHistory metaData_2 = new PageHistory();
        metaData_2.setPage(metaData);
        metaData_2.setContents(new PageContents("index", current, "<h1>index001</h1>", "# index001"));
        metaData_2.setVersion(2);

        PageHistory metaData_3 = new PageHistory();
        metaData_3.setPage(metaData);
        metaData_3.setContents(new PageContents("index", current, "<h1>index002</h1>", "# index002"));
        metaData_3.setVersion(3);

        pageHistoryRepository.save(metaData_1);
        pageHistoryRepository.save(metaData_2);
        pageHistoryRepository.save(metaData_3);
    }

}

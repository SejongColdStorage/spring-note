package kr.sadalmelik.springnote.service;

import kr.sadalmelik.springnote.domain.Page;
import kr.sadalmelik.springnote.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class PageServiceImpl{

    @Autowired
    PageRepository pageRepository;

    @PostConstruct
    public void initPage(){
        pageRepository.save(new Page("test0", 0, new Date(), "<h1>title0</h1>", "# title0"));
        pageRepository.save(new Page("test1", 1, new Date(), "<h1>title1</h1>", "# title1"));
        pageRepository.save(new Page("test2", 2, new Date(), "<h1>title2</h1>", "# title2"));
        pageRepository.save(new Page("test3", 3, new Date(), "<h1>title3</h1>", "# title3"));
        pageRepository.save(new Page("test4", 4, new Date(), "<h1>title4</h1>", "# title4"));
    }

}

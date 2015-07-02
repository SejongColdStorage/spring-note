package kr.sadalmelik.springnote.repository;

import kr.sadalmelik.springnote.Application;
import kr.sadalmelik.springnote.domain.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class PageRepositoryTest {

    @Autowired
    private PageRepository pageRepository;

    @Test
    public void pageTest() {
        List<Page> pages = pageRepository.findAll();
        System.out.println(pages);
    }
}
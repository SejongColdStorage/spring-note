package kr.sadalmelik.springnote.controller;

import kr.sadalmelik.springnote.domain.Page;
import kr.sadalmelik.springnote.repository.NoteRepository;
import kr.sadalmelik.springnote.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    PageRepository pageRepository;

    @Autowired
    NoteRepository noteRepository;


    @RequestMapping("/note/{noteUrlPath}")
    public String viewIndexPage(Model model, @PathVariable String noteUrlPath){
        Page rootPage = pageRepository.findRootPage(noteUrlPath);
        return viewPage(model, noteUrlPath, rootPage.getId());
    }

    @RequestMapping("/note/{noteUrlPath}/{pageId}")
    public String viewPage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId){
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("pageList", pageRepository.findRootPage(noteUrlPath).getChildPages());
        model.addAttribute("pageContents", pageRepository.getOne(pageId));

        return "page/view";
    }

    @RequestMapping(value = "/note/{noteUrlPath}/{pageId}/edit", method= RequestMethod.GET )
    public String viewEditPage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId){
        model.addAttribute("pageContents", pageRepository.getOne(pageId));

        return "page/edit";
    }

    @RequestMapping(value = "/note/{noteUrlPath}/{pageId}/edit", method= RequestMethod.PUT )
    public String editPage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId){
        // 기존 페이지를 가져온다.
        Page originalPage = pageRepository.getOne(pageId);
        // TODO 마크다운을 HTML로 변환한다.
        // 변환된 정보를 페이지에 저장한다.

        return null;
    }


}


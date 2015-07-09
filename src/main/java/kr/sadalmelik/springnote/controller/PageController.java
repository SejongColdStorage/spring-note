package kr.sadalmelik.springnote.controller;

import kr.sadalmelik.springnote.domain.Note;
import kr.sadalmelik.springnote.domain.Page;
import kr.sadalmelik.springnote.domain.PageContents;
import kr.sadalmelik.springnote.repository.NoteRepository;
import kr.sadalmelik.springnote.repository.PageRepository;
import kr.sadalmelik.springnote.util.parser.MarkdownParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class PageController {

    @Autowired
    PageRepository pageRepository;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    MarkdownParser markdownParser;


    @RequestMapping("/note/{noteUrlPath}")
    public String viewIndexPage(Model model, @PathVariable String noteUrlPath) {
        Page rootPage = pageRepository.findRootPage(noteUrlPath);
        return "redirect:/note/" + noteUrlPath + "/" + rootPage.getId();
    }

    @RequestMapping("/note/{noteUrlPath}/{pageId}")
    public String viewPage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId) {
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("pageList", pageRepository.findRootPage(noteUrlPath).getChildPages());
        model.addAttribute("page", pageRepository.getOne(pageId));

        return "page/view";
    }

    @RequestMapping(value = "/note/{noteUrlPath}/{pageId}/create", method = RequestMethod.GET)
    public String viewCreatePage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId) {
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("page", new Page());
        model.addAttribute("editMode", "create");

        return "page/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/note/{noteUrlPath}/{pageId}/create", method = RequestMethod.POST)
    public String saveNewPage(
            @PathVariable String noteUrlPath,
            @PathVariable long pageId,
            @RequestParam String name,
            @RequestParam String rawContents
    ) {
        Note note = noteRepository.findByUrlPath(noteUrlPath);
        Page parentPage = pageRepository.findOne(pageId);

        Page page = new Page();
        page.setPageOrder(0);
        page.setParentPage(parentPage);
        page.setNote(note);
        page.setContents(
                new PageContents(name, new Date(), rawContents, markdownParser.parse(rawContents))
        );

        pageRepository.save(parentPage);
        Page createdPage = pageRepository.save(page);

        return "/note/" + note.getUrlPath() + "/" + createdPage.getId();
    }


    @RequestMapping(value = "/note/{noteUrlPath}/{pageId}/modify", method = RequestMethod.GET)
    public String viewEditPage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId) {
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("page", pageRepository.getOne(pageId));
        model.addAttribute("editMode", "modify");

        return "page/edit";
    }

    @RequestMapping(value = "/note/{noteUrlPath}/{pageId}/modify", method = RequestMethod.POST)
    @ResponseBody
    public String saveEditPage(@PathVariable String noteUrlPath,
                               @PathVariable long pageId,
                               @RequestParam String name,
                               @RequestParam String rawContents) {
        Page currentPage = pageRepository.findOne(pageId);
        PageContents currentPageContents = currentPage.getContents();
        currentPageContents.setName(name);
        currentPageContents.setModifiedDate(new Date());
        currentPageContents.setRawContents(rawContents);
        currentPageContents.setParsedContents(markdownParser.parse(rawContents));

        pageRepository.save(currentPage);

        return "/note/" + currentPage.getNote().getUrlPath() + "/" + currentPage.getId();
    }

    @RequestMapping("/note/{noteUrlPath}/{pageId}/history")
    public String viewHistoryPage(Model model,
                                  @PathVariable String noteUrlPath,
                                  @PathVariable long pageId) {
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("pageList", pageRepository.findRootPage(noteUrlPath).getChildPages());
        model.addAttribute("page", pageRepository.getOne(pageId));

        return "page/history";
    }
}


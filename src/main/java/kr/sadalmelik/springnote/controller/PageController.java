package kr.sadalmelik.springnote.controller;

import kr.sadalmelik.springnote.domain.Note;
import kr.sadalmelik.springnote.domain.Page;
import kr.sadalmelik.springnote.domain.PageContents;
import kr.sadalmelik.springnote.repository.NoteRepository;
import kr.sadalmelik.springnote.repository.PageHistoryRepository;
import kr.sadalmelik.springnote.repository.PageRepository;
import kr.sadalmelik.springnote.util.parser.MarkdownParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/note/{noteUrlPath}")
public class PageController {
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private PageHistoryRepository pageHistoryRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private MarkdownParser markdownParser;


    @RequestMapping("/")
    public String viewIndexPage(@PathVariable String noteUrlPath) {
        Page rootPage = pageRepository.findRootPage(noteUrlPath);
        return String.format("redirect:/note/%s/%s", noteUrlPath, rootPage.getId());
    }

    @RequestMapping("/{pageId}")
    public String viewPage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId) {
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("pageList", pageRepository.findRootPage(noteUrlPath).getChildPages());
        model.addAttribute("page", pageRepository.getOne(pageId));

        return "page/view";
    }

    @RequestMapping(value = "/{pageId}/add", method = RequestMethod.GET)
    public String viewCreatePage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId) {
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("page", new Page());

        return "page/edit";
    }

    //TODO 리팩토링
    @RequestMapping(value = "/{pageId}/add", method = RequestMethod.POST)
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
        page.setContents(new PageContents(name, new Date(), rawContents, markdownParser.parse(rawContents)));

        pageRepository.save(parentPage);
        Page createdPage = pageRepository.save(page);

        return String.format("redirect:/note/%s/%s", note.getUrlPath(), createdPage.getId());
    }


    @RequestMapping(value = "/{pageId}/edit", method = RequestMethod.GET)
    public String viewEditPage(Model model, @PathVariable String noteUrlPath, @PathVariable long pageId) {
        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("page", pageRepository.getOne(pageId));

        return "page/edit";
    }

    //TODO URL 변경.
    @RequestMapping(value = "/{pageId}/edit", method = RequestMethod.POST)
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

        return String.format("redirect:/note/%s/%s", noteUrlPath, pageId);
    }

    // TODO POST일 경우에만 사용할 수 있도록 변경필요
    @RequestMapping(value = "/{pageId}/delete")
    public String deletePage(@PathVariable String noteUrlPath,
                             @PathVariable long pageId) {
        pageRepository.delete(pageId);

        return String.format("redirect:/note/%s/%s", noteUrlPath, pageId);
    }

    @RequestMapping("/{pageId}/history")
    public String viewHistoryPage(Model model,
                                  @PathVariable String noteUrlPath,
                                  @PathVariable long pageId) {

        model.addAttribute("note", noteRepository.findByUrlPath(noteUrlPath));
        model.addAttribute("pageList", pageRepository.findRootPage(noteUrlPath).getChildPages());
        model.addAttribute("page", pageRepository.getOne(pageId));

        return "page/history";
    }

}


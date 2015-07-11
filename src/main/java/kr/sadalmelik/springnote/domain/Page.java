package kr.sadalmelik.springnote.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
public class Page implements Comparable<Page> {

    public Page() {
    }

    public Page(String name, Note note, Integer pageOrder, Date modifiedDate, String parsedContents, String rawContents) {
        this.pageOrder = pageOrder;
        this.note = note;

        this.contents.setName(name);
        this.contents.setModifiedDate(modifiedDate);
        this.contents.setParsedContents(parsedContents);
        this.contents.setRawContents(rawContents);
    }

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private Integer pageOrder;

    // TODO 계층형구조 구현하기.
    // TODO Cascade 공부하기
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Page parentPage;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "parentPage")
    @OrderBy("pageOrder asc")
    private Set<Page> childPages = new TreeSet<>();

    @OneToMany(mappedBy = "page", fetch = FetchType.LAZY)
    @OrderBy("version desc")
    private List<PageHistory> pageHistories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "NOTE_ID")
    private Note note;

    @Embedded
    private PageContents contents = new PageContents();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPageOrder() {
        return pageOrder;
    }

    public void setPageOrder(Integer pageOrder) {
        this.pageOrder = pageOrder;
    }

    public Page getParentPage() {
        return parentPage;
    }

    public void setParentPage(Page parentPage) {
        this.parentPage = parentPage;
    }

    public Set<Page> getChildPages() {
        return childPages;
    }

    public void setChildPages(Set<Page> childPages) {
        this.childPages = childPages;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public PageContents getContents() {
        return contents;
    }

    public void setContents(PageContents contents) {
        this.contents = contents;
    }

    public List<PageHistory> getPageHistories() {
        return pageHistories;
    }

    public void setPageHistories(List<PageHistory> pageHistories) {
        this.pageHistories = pageHistories;
    }

    @Override
    public int compareTo(Page comparePage) {
        if (comparePage == null || pageOrder == null)
            return -1;
        else
            return Integer.compare(pageOrder, comparePage.getPageOrder());
    }
}

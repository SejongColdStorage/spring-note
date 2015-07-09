package kr.sadalmelik.springnote.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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
    private Set<Page> childPages = new HashSet<>();

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

    @Override
    public int compareTo(Page comparePage) {
        if (comparePage == null || pageOrder == null)
            return -1;
        else
            return Integer.compare(pageOrder, comparePage.getPageOrder());
    }
}

package kr.sadalmelik.springnote.domain;

import javax.persistence.*;

@Entity
public class PageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int version;

    @ManyToOne
    @JoinColumn(name="PAGE_ID")
    private Page page;

    @Embedded
    private PageContents pageContents;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public PageContents getPageContents() {
        return pageContents;
    }

    public void setPageContents(PageContents pageContents) {
        this.pageContents = pageContents;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

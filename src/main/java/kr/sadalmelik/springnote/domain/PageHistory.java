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
    private PageContents contents;

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

    public PageContents getContents() {
        return contents;
    }

    public void setContents(PageContents contents) {
        this.contents = contents;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

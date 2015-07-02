package kr.sadalmelik.springnote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Page implements Comparable<Page> {

    public Page() {
    }

    public Page(String name, Integer pageOrder, Date modifiedDate, String parsedContents, String rawContents) {
        this.name = name;
        this.pageOrder = pageOrder;
        this.modifiedDate = modifiedDate;
        this.parsedContents = parsedContents;
        this.rawContents = rawContents;
    }

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private Integer pageOrder;

    // TODO 계층형구조 구현하기.
//    //TODO Cascade 공부하기
//    @ManyToOne
//    @JoinColumn(name = "PARENT_ID")
//    private Page parentPage;
//
//    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "parentPage")
//    private Set<Page> childPages = new TreeSet<Page>();

    // TODO 아래는 PageContents 도메인으로 분리할 것.
    // PageHistory 도메인에도 아래의 내용이 공통적으로 사용될 예정.
    @NotNull
    private String name;
    private Date modifiedDate;
    private String parsedContents;
    private String rawContents;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageOrder() {
        return pageOrder;
    }

    public void setPageOrder(Integer pageOrder) {
        this.pageOrder = pageOrder;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getParsedContents() {
        return parsedContents;
    }

    public void setParsedContents(String parsedContents) {
        this.parsedContents = parsedContents;
    }

    public String getRawContents() {
        return rawContents;
    }

    public void setRawContents(String rawContents) {
        this.rawContents = rawContents;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Page{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", pageOrder=").append(pageOrder);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Page comparePage) {
        if (comparePage == null || pageOrder == null)
            return -1;
        else
            return Integer.compare(pageOrder, comparePage.getPageOrder());
    }
}

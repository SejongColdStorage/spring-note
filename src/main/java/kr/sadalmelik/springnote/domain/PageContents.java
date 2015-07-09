package kr.sadalmelik.springnote.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Embeddable
public class PageContents {

    @NotNull
    private String name;
    private Date modifiedDate;
    private String parsedContents;
    private String rawContents;

    public PageContents() {
    }

    public PageContents(String name, Date modifiedDate, String parsedContents, String rawContents) {
        this.name = name;
        this.modifiedDate = modifiedDate;
        this.parsedContents = parsedContents;
        this.rawContents = rawContents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

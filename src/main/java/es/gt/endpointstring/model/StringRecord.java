package es.gt.endpointstring.model;

import javax.persistence.*;

@Entity
public class StringRecord {

    @Id
    @Column(name="Id")
    @GeneratedValue(generator="increment")
    private long id;
    @Column(name = "Original_String")
    private String originalString;
    @Column(name = "Upper_String")
    private String upperString;

    public StringRecord(){}

    public StringRecord(int id, String originalString, String upperString) {
        this.id = id;
        this.originalString = originalString;
        this.upperString = upperString;
    }

    public StringRecord(String originalString, String upperString) {
        this.originalString = originalString;
        this.upperString = upperString;
    }

    public long getId() {
        return id;
    }

    public String getOriginalString() {
        return originalString;
    }

    public String getUpperString() {
        return upperString;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }

    public void setUpperString(String upperString) {
        this.upperString = upperString;
    }
}

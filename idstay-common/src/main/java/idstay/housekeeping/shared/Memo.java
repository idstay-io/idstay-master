package idstay.housekeeping.shared;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class Memo {
    private String memoAuthor = "";
    private String memoSubject = "";
    private String memoBody = "";
    @Temporal(TemporalType.TIMESTAMP)
    private Date memoDate;

    public Memo() {}
    public String getMemoAuthor() {
        return memoAuthor;
    }

    public Memo setMemoAuthor(String memoAuthor) {
        this.memoAuthor = memoAuthor;
        return this;
    }

    public String getMemoSubject() {
        return memoSubject;
    }

    public Memo setMemoSubject(String memoSubject) {
        this.memoSubject = memoSubject;
        return this;
    }

    public String getMemoBody() {
        return memoBody + "";
    }

    public Memo setMemoBody(String memoBody) {
        this.memoBody = memoBody;
        return this;
    }

    public Date getMemoDate() {
        return memoDate;
    }

    public Memo setMemoDate(Date memoDate) {
        this.memoDate = memoDate;
        return this;
    }
}

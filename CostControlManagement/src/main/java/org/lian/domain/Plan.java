package org.lian.domain;

import javax.xml.soap.Text;
import java.util.Date;

/**
 * Created by lianjiangchao on 16/5/24.
 */
public class Plan {
    private Integer id;
    private String status;
    private Date createdate;
    private Text content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Text getContent() {
        return content;
    }

    public void setContent(Text content) {
        this.content = content;
    }
}

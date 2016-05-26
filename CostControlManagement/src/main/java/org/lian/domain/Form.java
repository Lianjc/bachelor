package org.lian.domain;

import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/24.
 */
public class Form {
    private Integer id;
    private String description;
    private Text path;
    private List<User> user;
    private Date createdate;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Text getPath() {
        return path;
    }

    public void setPath(Text path) {
        this.path = path;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

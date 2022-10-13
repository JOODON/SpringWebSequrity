package dto;

import java.util.Date;

public class Member {
    private Long id;
    private String name;
    private String MEMBER_PASSWORD;
    private String EMAIL;
    private Date create_date;
    private Date modify_date;

    public Member(){
        create_date=new Date();
        modify_date=new Date();
    }
    public Member(Long id, String name, String MEMBER_PASSWORD, String EMAIL) {
        this.id = id;
        this.name = name;
        this.MEMBER_PASSWORD = MEMBER_PASSWORD;
        this.EMAIL = EMAIL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMEMBER_PASSWORD() {
        return MEMBER_PASSWORD;
    }

    public void setMEMBER_PASSWORD(String MEMBER_PASSWORD) {
        this.MEMBER_PASSWORD = MEMBER_PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

}

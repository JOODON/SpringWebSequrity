package dto;

public class MemberRole {
    private Long id;
    private Long member_id;
    private String role_name;

    public MemberRole(Long member_id, String role_name) {
        this.member_id = member_id;
        this.role_name = role_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}

package dao;

public class MemberDaoSqls {
    public static final String SELECT_ALL_BY_EMAIL="SELECT ID,NAME,MEMBER_PASSWORD,EMAIL,create_date,modify_date FROM member WHERE email=:email";
}

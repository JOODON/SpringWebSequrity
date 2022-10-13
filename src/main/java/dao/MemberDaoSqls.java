package dao;

public class MemberDaoSqls {
    public static final String SELECT_ALL="SELECT ID,NAME,MEMBER_PASSWORD,EMAIL,create_date,modify_date FROM member WHERE email=:email";
}

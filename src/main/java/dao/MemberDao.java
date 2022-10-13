package dao;

import dto.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
@Repository
public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;

    private RowMapper<Member> rowMapper= BeanPropertyRowMapper.newInstance(Member.class);

    public MemberDao(DataSource dataSource){
        this.jdbc=new NamedParameterJdbcTemplate(dataSource);
    }
    public Member GetMemberByEmail(String email){
        Map<String,Object> map=new HashMap<>();
        map.put("email",email);

        return jdbc.queryForObject(MemberDaoSqls.SELECT_ALL,map,rowMapper);

    }

}

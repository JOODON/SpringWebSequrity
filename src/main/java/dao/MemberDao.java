package dao;

import dto.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;

    private RowMapper<Member> rowMapper= BeanPropertyRowMapper.newInstance(Member.class);

    private MemberDao(DataSource dataSource){
        this.jdbc=new NamedParameterJdbcTemplate(dataSource);
    }
    private Member GetMemberByEmail(String email){
        Map<String,Object> map=new HashMap<>();
        map.put("email",email);

        return jdbc.queryForObject(MemberDaoSqls.SELECT_ALL,map,rowMapper);

    }
}

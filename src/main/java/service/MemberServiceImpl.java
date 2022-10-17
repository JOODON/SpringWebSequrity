package service;

import dao.MemberDao;
import dao.MemberRoleDao;
import dto.Member;
import dto.MemberRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberDao memberDao;
    private final MemberRoleDao memberRoleDao;

    // @Service가 붙은 객체는 스프링이 자동으로 Bean으로 생성하는데
    // 기본생성자가 없고 아래와 같이 인자를 받는 생성자만 있을 경우 자동으로 관련된 타입이 Bean으로 있을 경우 주입해서 사용하게 된다.
    public MemberServiceImpl(MemberDao memberDao, MemberRoleDao memberRoleDao) {
        this.memberDao = memberDao;
        this.memberRoleDao = memberRoleDao;
    }

    @Override
    @Transactional
    public UserEntity getUser(String loginUserId){
        Member member=memberDao.getMemberByEmail(loginUserId);
        return new UserEntity(member.getEMAIL(),member.getMEMBER_PASSWORD());
    }


    @Override
    @Transactional
    public List<UserRoleEntity> getUserRoles(String loginUserId) {
        System.out.println(loginUserId);
        List<MemberRole> memberRoles = memberRoleDao.getRoleByEmail(loginUserId);
        List<UserRoleEntity> list = new ArrayList<>();
        for (MemberRole memberRole : memberRoles) {
            list.add(new UserRoleEntity(loginUserId,memberRole.getRoleName()));
        }
        System.out.println(list);
        return list;
    }
}

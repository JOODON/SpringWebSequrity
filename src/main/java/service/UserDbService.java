package service;

import java.util.List;
//UserDbService인터페이스를 작성합니다. 로그인한 사용자 id를 파라미터로 받아들여서
// UserEntity와 List<UserRoleEntity>를 리턴하는 메소드를 가지고 있음.
// 로그인 정보가 저장된 데이터베이스의 구조는 프로젝트마다 다르기 때문에 스프링 시큐리티에서 알 수가 없음.
// 로그인 정보가 어디에 저장되어 있든 해당 인터페이스를 구현하는 쪽에 맡기게 된다는 것을 의미.

public interface UserDbService {
    public UserEntity getUser(String loginUserId);
    public List<UserRoleEntity> getUserRoles(String loginUserId);
}

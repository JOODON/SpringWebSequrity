package service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

//앞에서 설명한 UserDetailsService인터페이스를 구현하는 CustomUserDetailsService를 생성합니다.

//UserDetailsService인터페이스는 1개의 메소드만 선언하고 있습니다.

//바로 public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException 메소드입니다.

//사용자가 로그인을 할 때 아이디를 입력하면 해당 아이디를 loadUserByUsername()메소드의 인자로 전달합니다. 해당 아이디에 해당하는 정보가 없으면 UsernameNotFoundException이 발생합니다.

//정보가 있을 경우엔 UserDetails인터페이스를 구현한 객체를 리턴 하게 됩니다.

// 데이터베이스에서 로그인 아이디에 해당하는 정보를 읽어 들이기 위해서 UserDbService를 구현한 객체를 주입받고 있습니다.

// UserDbService도 인터페이스이니 구현한 객체가 필요합니다.

//이렇게 조금은 복잡하게 구현된 이유는 데이터베이스에서 읽어 들이는 코드와 스프링 시큐리티에서 사용되는 코드를 분리하기 위함입니다.
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private Collection<? extends GrantedAuthority> authorities ;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}

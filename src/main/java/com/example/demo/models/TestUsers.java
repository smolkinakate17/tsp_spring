package com.example.demo.models;

import com.example.demo.models.enums.Role;
import javax.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name="test_users")
public class TestUsers implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="logins")
    private String logins;

    @Column(name="passwords")
    private String passwords;

    @Column(name = "active")
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles=new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TestMesseges> messeges;

    public TestUsers(Integer id,String logins,String passwords){
        this.id=id;
        this.logins=logins;
        this.passwords=passwords;
    }
    public TestUsers(String logins,String passwords){
        this.logins=logins;
        this.passwords=passwords;
    }

    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return passwords;
    }

    @Override
    public String getUsername() {
        return logins;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}

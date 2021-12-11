package com.appistock.proyectostock.security;

import com.appistock.proyectostock.entity.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserProveedorPrincipal implements UserDetails {

    private Proveedor proveedor;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserProveedorPrincipal create(Proveedor proveedor){
        List<GrantedAuthority> authorities= Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return new UserProveedorPrincipal(proveedor,authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return proveedor.getContrasenia();
    }

    @Override
    public String getUsername() {
        return proveedor.getEmail();
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
        return true;
    }
}

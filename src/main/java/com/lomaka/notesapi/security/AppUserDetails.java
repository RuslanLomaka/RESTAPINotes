package com.lomaka.notesapi.security;

import com.lomaka.notesapi.model.User;
import java.util.Set;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public record AppUserDetails(User delegate) implements UserDetails {

    @Override public String getUsername() { return delegate.getUsername(); }
    @Override public String getPassword() { return delegate.getPassword(); }
    @Override public boolean isEnabled()   { return delegate.isEnabled();  }

    @Override public Set<SimpleGrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_" + delegate.getRole().name()));
    }

    /* flags we don’t care about right now */
    @Override public boolean isAccountNonExpired()     { return true; }
    @Override public boolean isAccountNonLocked()      { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
}

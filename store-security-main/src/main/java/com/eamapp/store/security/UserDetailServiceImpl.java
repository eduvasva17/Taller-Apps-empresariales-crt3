package com.eamapp.store.security;

import com.eamapp.store.model.entity.User;
import com.eamapp.store.model.repository.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IUserDao userDao;

    /**
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+email+ "no existe"));

        return new UserDetailsImpl(user);
    }
}

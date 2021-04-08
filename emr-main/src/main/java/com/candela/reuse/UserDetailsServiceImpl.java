
package com.candela.reuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.candela.entity.User;
import com.candela.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mailId) {
        User user = userRepository.findByMailId(mailId);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        return new PortalUserDetails(user);
    }

}

package com.pilgrim_lifestyle.security.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import org.apache.log4j.Logger;

import com.pilgrim_lifestyle.security.model.AccountUser;

public class UserDetailsService extends JdbcDaoImpl
{
    @Override
    protected List<UserDetails> loadUsersByUsername( String username )
    {
        logger.info(  "loadUsersByUsername start" );
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] { username },
                new RowMapper<UserDetails>()
                {
                             public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException
                             {
                                String mailAddress = rs.getString( 1 );
                                String password = rs.getString( 2 );
                                String fullName = rs.getString( 4 );
                                return new AccountUser( mailAddress, password, fullName, AuthorityUtils.NO_AUTHORITIES);
                              }
                  });
    }

    @Override
    protected UserDetails createUserDetails( String mailAddress, UserDetails userFromUserQuery, List<GrantedAuthority> combinedAuthorities )
    {
        logger.info(  "createUserDetails start" );
        UserDetails user = super.createUserDetails( mailAddress, userFromUserQuery, combinedAuthorities );

        if (userFromUserQuery instanceof AccountUser)
        {
            AccountUser accoutUser = ( AccountUser ) userFromUserQuery;

            return new AccountUser( user.getUsername(), user.getPassword(), accoutUser.getFullName(), user.getAuthorities());
        }
        else
        {
             return user;
        }
    }

    private static Logger logger= Logger.getLogger( UserDetailsService.class );

}

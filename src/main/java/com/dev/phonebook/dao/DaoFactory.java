/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 12-07-2022/07/2022
 *   Time: 01:53 PM
 *   File: DaoFactory
 */

package com.dev.phonebook.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public final class DaoFactory {

    private DaoFactory() {
    }

    private static SqlSession createSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession(true);
        return session;
    }

    public static UserDao getUserDao() throws IOException {
        return createSession().getMapper(UserDao.class);
    }


    public static ContactDao getContactDao() throws IOException {
        return createSession().getMapper(ContactDao.class);
    }
}

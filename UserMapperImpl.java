package com.system.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.system.mapper.UserMapper;
import com.system.pojo.User;
import com.system.util.MybatisUtil;

public class UserMapperImpl implements UserMapper{

	@Override
	public int addUser(User user) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(UserMapper.class).addUser(user);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int delUserByNo(String userId) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(UserMapper.class).delUserByNo(userId);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int editUserByNo(User user) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(UserMapper.class).editUserByNo(user);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<User> getUserByName(String userName) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<User> user = session.getMapper(UserMapper.class).getUserByName(userName);
		if(session != null)
			session.close();
		return user;
	}

	@Override
	public List<User> getUserByNo(String userId) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<User> user = session.getMapper(UserMapper.class).getUserByNo(userId);
		if(session != null)
			session.close();
		return user;
	}

	@Override
	public List<User> getUserList() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<User> user = session.getMapper(UserMapper.class).getUserList();
		if(session != null)
			session.close();
		return user;
	}

	@Override
	public int getUserCount() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(UserMapper.class).getUserCount();
		if(session != null)
			session.close();
		return count;
	}



}

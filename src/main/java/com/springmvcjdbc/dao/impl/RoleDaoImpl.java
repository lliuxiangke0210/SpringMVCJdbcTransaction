package com.springmvcjdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.build.Criteria;
import com.springmvcjdbc.dao.RoleDao;
import com.springmvcjdbc.model.Role;

@Service
@Transactional
public class RoleDaoImpl extends JdbcDaoSupport implements RoleDao {

	@Autowired
	public RoleDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public Role findRole(Integer roleId) {// oo
		Criteria criteria = Criteria.select(Role.class).where("role_id", new Object[] { roleId });
		Role role = jdbcDao.querySingleResult(criteria);
		return role;
	}

	@Override
	public void insertRole(Role role) {// oo
		jdbcDao.insert(role);
	}

	@Override
	public List<Role> listRole() {// oo
		// Role role = new Role();
		// PageControl.performPage(role);
		// jdbcDao.queryList(role);
		// Pager pager = PageControl.getPager();
		// List<Role> roles = pager.getList(Role.class);
		// System.out.println(roles);
		// System.out.println("总记录数：" + pager.getItemsTotal());
		List<Role> roles = jdbcDao.queryList(Role.class);
		return roles;
	}

	@Override
	public void delete(Integer roleId) {// oo

		jdbcDao.delete(Role.class, roleId.longValue());
	}

	@Override
	public void Update(Role role) {// oo
		jdbcDao.update(role);
	}

	@Override
	public void deleteRoleUsers(Integer rid) {// oo
		String sql = "delete from user_role where role_id=?";
		jdbcDao.updateForSql(sql, new Object[] { rid });
	}

}
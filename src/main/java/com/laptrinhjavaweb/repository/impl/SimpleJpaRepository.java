package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.annotion.Entity;
import com.laptrinhjavaweb.annotion.Table;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.JpaRepository;

public class SimpleJpaRepository<T> implements JpaRepository<T> {
	private Class<T> zClass;

	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		// lấy phần tử T trả về một class
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll(Map<String, Object> properties, Pageable pageable, Object... where) {
		String tableName = "";
		if (zClass.isAnnotationPresent(Entity.class) && zClass.isAnnotationPresent(Table.class)) {
			Table tableClass = zClass.getAnnotation(Table.class);
			tableName = tableClass.name();
		}

		StringBuilder sql = new StringBuilder("SELECT * FROM " + tableName + " A WHERE 1=1 ");
		sql = createSQLfindAll(sql,properties);
		if (where != null && where.length > 0) {
			sql.append(where[0]);
		}
		sql.append(" limit " + pageable.getOffset() + ", " + pageable.getLimit() + "");
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = null;
		Statement statement = null;
//		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
//			statement = connection.prepareStatement(sql.toString());
			statement = connection.createStatement();
//			setParameter(statement, parameters);
			resultSet = statement.executeQuery(sql.toString());
			return resultSetMapper.mapRow(resultSet, this.zClass);
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

	private StringBuilder createSQLfindAll(StringBuilder where , Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			String[] keys = new String[params.size()];
			Object[] values = new Object[params.size()];
			int i = 0;
			for (Map.Entry<String, Object> item : params.entrySet()) {
				keys[i] = item.getKey();
				values[i] = item.getValue();
				i++;
			}
			for (int i1 = 0; i1 < keys.length; i1++) {
				if ((values[i1] instanceof String) && (StringUtils.isNotBlank(values[i1].toString()))) { // gia tri khac
																											// null va
																											// khac
																											// empty
					where.append("AND LOWER(A." + keys[i1] + ") LIKE '%" + values[i1] + "%' ");
				} else if ((values[i1] instanceof Integer) && (values[i1] != null)) {
					where.append("AND LOWER(A." + keys[i1] + ") = " + values[i1] + " ");
				} else if ((values[i1] instanceof Long) && (values[i1] != null)) {
					where.append("AND LOWER(A." + keys[i1] + ") = " + values[i1] + " ");
				}
			}
		}
		return where;
	}

}

package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.paging.Sorter;
import com.laptrinhjavaweb.repository.GenericJDBC;

public class AbstractJDBC<T> implements GenericJDBC<T> {

	private Class<T> zClass;

	@SuppressWarnings("unchecked")
	public AbstractJDBC() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	};

	@Override
	public List<T> query(String sql, Object... parameters) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection conn = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (conn != null) {
				// set paramerter to statement
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					statement.setObject(index, parameters[i]);
				}
				return resultSetMapper.mapRow(resultSet, this.zClass);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private Connection getConnection() {

		String databaseURL = "jdbc:mysql://localhost:3306/estate4month2019";
		String user = "root";
		String password = "123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(databaseURL, user, password);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			if (conn != null) {
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					statement.setObject(index, parameters[i]);
				}
				statement.executeUpdate();
				conn.commit();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
			if (conn != null) {
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					statement.setObject(index, parameters[i]);
				}
				int rowInserted = statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				conn.commit();
				if (rowInserted > 0) {
					while (resultSet.next()) {
						id = resultSet.getLong(1);

					}

				}
				return id;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long insert(Object object) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		try {

			String sql = createSQLInsert();
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);

			if (conn != null) {
				Class<?> zClass = object.getClass();
				Field[] fields = zClass.getDeclaredFields();

				// set parameter to statement
				for (int i = 0; i < fields.length; i++) {
					int index = i + 1;
					Field field = fields[i];
					field.setAccessible(true);
					statement.setObject(index, field.get(object));
				}
				Class<?> parentClass = zClass.getSuperclass();
				int indexparent = fields.length + 1;
				while (parentClass != null) {
					for (int i = 0; i < parentClass.getDeclaredFields().length; i++) {
						Field field = parentClass.getDeclaredFields()[i];
						field.setAccessible(true);
						statement.setObject(indexparent, field.get(object));
						indexparent = indexparent + 1;
					}
					parentClass = parentClass.getSuperclass();
				}

				int rowInserted = statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				conn.commit();
				if (rowInserted > 0) {
					while (resultSet.next()) {
						id = resultSet.getLong(1);

					}

				}
				return id;
			}
		} catch (SQLException | IllegalAccessException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	private String createSQLInsert() {
		String tableName = "";

		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}

		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");

		for (Field field : zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		// check parent class
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}
			}
			parentClass = parentClass.getSuperclass();
		}

		String sql = "INSERT INTO " + tableName.toString() + "(" + fields + ") VALUES(" + params.toString() + ")";
		return sql;
	}

	@Override
	public void update(Object object) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {

			String sql = createSQLUpdate();
			conn = getConnection();
			conn.setAutoCommit(false);

			statement = conn.prepareStatement(sql);
			if (conn != null) {
				Class<?> zClass = object.getClass();
				Field[] fields = zClass.getDeclaredFields();
				Object idValue = null;
				// set parameter to statement
				for (int i = 0; i < fields.length; i++) {
					int index = i + 1;
					Field field = fields[i];
					field.setAccessible(true);
					if (!field.getName().equals("id")) {
						statement.setObject(index, field.get(object));
					}
				}
				Class<?> parentClass = zClass.getSuperclass();
				int indexparent = fields.length + 1;
				while (parentClass != null) {
					for (int i = 0; i < parentClass.getDeclaredFields().length; i++) {
						Field field = parentClass.getDeclaredFields()[i];
						field.setAccessible(true);
						if (!field.getName().equals("id")) {
							statement.setObject(indexparent, field.get(object));
							indexparent = indexparent + 1;
						} else {
							idValue = field.get(object);
						}

					}
					parentClass = parentClass.getSuperclass();
				}
				statement.setObject(indexparent, idValue);
				statement.executeUpdate();

				conn.commit();

			}
		} catch (SQLException | IllegalAccessException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	private String createSQLUpdate() {
		String tableName = "";

		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}

		StringBuilder sets = new StringBuilder("");
		StringBuilder where = new StringBuilder("");

		for (Field field : zClass.getDeclaredFields()) {
			if (sets.length() > 1) {
				if (!field.getName().equals("id")) {
					sets.append(",");
				}
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				String columnName = column.name();
				if (!columnName.equals("id")) {
					String value = columnName + " =? ";
					sets.append(value);
				} else {
					String value = "where " + columnName + " = ? ";
					where.append(value);
				}

			}
		}
		// check parent class
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (sets.length() > 1) {
					if (!field.getName().equals("id")) {
						sets.append(",");
					}
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					String columnName = column.name();
					if (!columnName.equals("id")) {
						String value = columnName + " =? ";
						sets.append(value);
					} else {
						String value = " where " + columnName + " = ? ";
						where.append(value);
					}

				}
			}
			parentClass = parentClass.getSuperclass();
		}

		String sql = "UPDATE " + tableName.toString() + " SET " + sets + where;
		return sql;
	}

	@Override
	public void delete(Long id) {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "DELETE FROM " + tableName + " WHERE id= ?";
		Connection conn = null;
		PreparedStatement statement = null;
		conn = getConnection();
		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public <T> T findById(Long id) {
		BuildingDTO buildingDTO = new BuildingDTO();
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		conn = getConnection();
		try {
			statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			rs = statement.executeQuery();

			ResultSetMapper<BuildingEntity> rsm = new ResultSetMapper<>();
			List<BuildingEntity> list = rsm.mapRow(rs, zClass);
			BuildingConverter b = new BuildingConverter();
			buildingDTO = b.converterToDTO(list.get(0));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return (T) buildingDTO;
	}

	@Override
	public List<T> findAll(Map<String, Object> properties, Pageble page, Object... where) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection conn = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		StringBuilder sql = createSQLfindALL(properties);
		if (where != null && where.length > 0) {
			sql.append(where[0]) ; 
		}
		
		if(page!=null){
			if(page.getSorter()!=null){
				Sorter sorter = page.getSorter();
				sql.append(" ORDER BY "+sorter.getSortName()+" "+sorter.getSortBy()+" ");
			}
			
			if(page.getOffset()!=null && page.getLimit() !=null){
				sql.append(" LIMIT "+page.getOffset()+", "+page.getLimit()+" ");
			}
			
			
		}
		
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql.toString());
			if (conn != null) {
				return resultSetMapper.mapRow(resultSet, this.zClass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (Exception e2) {
			}
		}

		return null;
	}

	private StringBuilder createSQLfindALL(Map<String, Object> properties) {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		
		StringBuilder result = new StringBuilder("SELECT * FROM "+tableName+" WHERE 1=1");
		if(properties != null && properties.size()>0){
			String [] params = new String[properties.size()];
			Object [] values = new Object[properties.size()];
			int i=0;
			for(Map.Entry<?, ?> item : properties.entrySet()){
				params[i] = (String) item.getKey();
				values[i] = item.getValue();
				i++;
			}
			// luu y 
			for(int i1=0;i1 < params.length;i1++){
				if(values[i1] instanceof String){
					result.append(" and LOWER("+params[i1]+") LIKE '%"+values[i1]+"%' ");
				}else if (values[i1] instanceof Integer){
					result.append(" and "+params[i]+" = "+values[i]+" ");
				}
				
			}
			
		}
		
		return result;
	}

}

package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs, Class zClass) {
		List<T> results = new ArrayList<>();

		if (zClass.isAnnotationPresent(Entity.class)) {
			try {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();

				Field[] fields = zClass.getDeclaredFields();

				while (rs.next()) {
					T object = (T) zClass.newInstance();
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {

						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object comlumnValue = rs.getObject(i + 1);

						// current class
						convertResultSetToEntity(fields, columnName, comlumnValue, object);
						// super class
						Class parentClass = zClass.getSuperclass();
						while (parentClass != null) {
							Field[] fieldParents = parentClass.getDeclaredFields();
							convertResultSetToEntity(fieldParents, columnName, comlumnValue, object);
							parentClass = parentClass.getSuperclass();

						}
					
					}
					results.add(object);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return results;
	}

	private void convertResultSetToEntity(Field[] fieldParents, String columnName, Object comlumnValue, T object)
			throws IllegalAccessException, InvocationTargetException {
		for (Field field : fieldParents) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				if (column.name().equals(columnName) && comlumnValue != null) {
					BeanUtils.setProperty(object, field.getName(), comlumnValue);
					break;
				}
			}
		}
	}

}

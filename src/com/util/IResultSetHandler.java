package com.util;

import java.sql.ResultSet;

public interface IResultSetHandler {
	/**
     * @Method: handler
     * @Description: 结果集处理方法
     * @Anthor:yy
     *
     * @param rs 查询结果集
     * @return
     */ 
     public Object handler(ResultSet rs);
}

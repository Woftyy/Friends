package com.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
	private static List<Connection> pool; 	//���ӳض���
	public volatile int size;
	private static int pool_max_size;  //���������
	private static int pool_min_size;	//��С������
	
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	
	private static ConnectionPool cp = null;
	public static void setUrl(String url) {
		ConnectionPool.url = url;
	}

	public static void setUsername(String username) {
		ConnectionPool.username = username;
	}

	public static void setPassword(String password) {
		ConnectionPool.password = password;
	}

	public static void setDriver(String driver) {
		ConnectionPool.driver = driver;
	}

	public static void setPool_max_size(int pool_max_size) {
		ConnectionPool.pool_max_size = pool_max_size;
	}

	public static void setPool_min_size(int pool_min_size) {
		ConnectionPool.pool_min_size = pool_min_size;
	}
	
	public static ConnectionPool getInstance(){
		if(cp == null){
			synchronized (ConnectionPool.class){
				if(cp == null){
					cp = new ConnectionPool();
				}
			}
		}
		return cp;
	}
	
	/**
	 * ��ʼ�����ӳأ�ʹ�����������ﵽ��Сֵ
	 *  
	 * void
	 */
	private void initPool(){
		if(pool == null){
			pool = new LinkedList<Connection>();
		}
		/*
		 * ���û�дﵽ��С����������һֱװ
		 */
		while(pool.size() < ConnectionPool.pool_min_size){
			pool.add(createConn());
		}
	}
	/**
	 * ��ȡ���ݿ�����
	 * @return 
	 * Connection
	 */
	public static Connection createConn(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	public int size(){
		return pool.size();
	}
	
	/**
	 * @para name
	 * @Description Constructor
	 */
	private ConnectionPool(){
		initPool();
	}
	/*
	 * �ӳ���ȡ��һ������  ��synchronized����Ч�ʱȽϵ�
	 */
	public synchronized Connection getConn(){
		Connection conn = null;
		int index = pool.size() - 1;
		if(pool.size() > 0){
			conn = pool.remove(index);
		} else {
			conn = createConn();
		}
		return conn;
	}
	/*
	 * ����ﵽ���ֵ����Ĺر�����,����ͼ������
	 */
	public void close (Connection conn){
		if(pool.size() == pool_max_size){
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		} else{
			pool.add(conn);
		}
	}


	
	
}

package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.IFollowDao;
import com.entity.Follow;
import com.util.DBUtil;

public class FollowDaoImpl implements IFollowDao{

	@Override
	public int insert(Follow follow) {
		// TODO Auto-generated method stub
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into follow values(?,?,)");
		try {
			pstmt.setInt(0, follow.getUid());
			pstmt.setInt(1,follow.getF_uid() );
			affectRows = DBUtil.exeUpdate(pstmt);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

	@Override
	public int update(Follow follow) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CancelFollow(Follow follow) {
		// TODO Auto-generated method stub
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from follow where followuserid=?");
		try {
			pstmt.setInt(1, follow.getF_uid());
			affectRows = DBUtil.exeUpdate(pstmt);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

}

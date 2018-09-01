package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.IMomentDao;
import com.entity.Moment;
import com.entity.User;
import com.util.DBUtil;
import com.util.JDBCUtils;

public class MomentDaoImpl implements IMomentDao{

	@Override
	public int insert(Moment moment) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into moment values(null,?,?,now(),?)");
		try {
			pstmt.setInt(1, moment.getUid());
			pstmt.setString(2,moment.getContent() );
			pstmt.setString(3,moment.getImg());
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
	public int update(Moment moment) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update moment set uid=?, content=?, publishdate=?, img=?,"
				+ " where id=?");
		try {
			pstmt.setInt(1,moment.getUid());
			pstmt.setString(2,moment.getContent() );
			pstmt.setTimestamp(3, moment.getPublishdate());
			pstmt.setString(4,moment.getImg() );
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
	public int delete(Moment moment) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from moment where id=?");
		try {
			pstmt.setLong(1, moment.getId());
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
	public List<Moment> queryAllMoment() {
		// TODO Auto-generated method stub
		String sql = "select * from moment ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Moment> moments= new ArrayList<>();
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Moment moment = new Moment();
				moment.setId(rs.getInt("id"));
				moment.setUid(rs.getInt("uid"));
				moment.setContent(rs.getString("content"));
				moment.setPublishdate(rs.getTimestamp("publishdate"));
				moment.setImg(rs.getString("img"));
				moments.add(moment);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
		return moments;
	}

	@Override
	public List<Moment> queryByUid(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from moment where uid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Moment> moments= new ArrayList<>();
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while(rs.next()){
				Moment moment = new Moment();
				moment.setId(rs.getInt("id"));
				moment.setUid(rs.getInt("uid"));
				moment.setContent(rs.getString("content"));
				moment.setPublishdate(rs.getTimestamp("publishdate"));
				moment.setImg(rs.getString("img"));
				moments.add(moment);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
		return moments;
	}
	
}

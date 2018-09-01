package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ICommentDao;
import com.entity.Comment;
import com.entity.Moment;
import com.util.DBUtil;
import com.util.JDBCUtils;

public class CommentDaoImpl implements ICommentDao{

	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into comment values(null,?,?,?,now())");
		try {
			pstmt.setLong(1, comment.getMid());
			pstmt.setInt(2,comment.getUser_id() );
			pstmt.setString(3,comment.getContent());
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
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Comment> queryByMid(Long mid) {
		// TODO Auto-generated method stub
		
		String sql = "select * from comment where mid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Comment> comments= new ArrayList<>();
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, mid);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setUser_id(rs.getInt("uid"));
				comment.setContent(rs.getString("content"));
				comment.setPublishdate(rs.getTimestamp("publishdate"));
				comments.add(comment);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
		return comments;
	}

	
	
}

package com.myspring.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.myspring.entity.Score;

public class JDBC {
	private static final String SQL_INSERT_SCORE = "insert into score (SNO, CNO, DEGREE) values (?,?,?)";
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addScore(Score score) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = (Connection) dataSource.getConnection();
			stmt = (PreparedStatement) conn.prepareStatement(SQL_INSERT_SCORE);
			stmt.setString(1, score.getSNO());
			stmt.setString(2, score.getCNO());
			stmt.setFloat(3, score.getDEGREE());
			stmt.execute();
		} catch (SQLException e) {

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}

package com.ba.qr.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ServiceQRQueryImpl implements IServiceQRQuery {
	
	private DataSource dataSource;
	private final String QUERY_GET_URL_BY_ID = "select url from qr where id = ?";
	
	public String getUrlQr(String id) throws SQLException {
		String url = null;
		Connection conexion = getDataSource().getConnection();
		PreparedStatement ps = conexion.prepareStatement(QUERY_GET_URL_BY_ID);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			url = rs.getString(1);
		}
		ps.close();
		conexion.close();
		return url;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

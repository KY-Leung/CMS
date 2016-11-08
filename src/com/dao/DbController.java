package com.dao;

import java.sql.ResultSet;

public interface DbController {
	public void connect();
	public ResultSet executeQuery(String query);
	public int updateQuery(String query);
	public void close();
}

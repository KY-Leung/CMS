package com.dao;

import java.sql.ResultSet;

// TODO: Auto-generated Javadoc
/**
 * The Interface DbController.
 */
public interface DbController {
	
	/**
	 * Connect to db.
	 */
	public void connect();
	
	/**
	 * Execute query.
	 *
	 * @param query the query
	 * @return the result set
	 */
	public ResultSet executeQuery(String query);
	
	/**
	 * Update query.
	 *
	 * @param query the query
	 * @return the int
	 */
	public int updateQuery(String query);
	
	/**
	 * Close db connection.
	 */
	public void close();
}

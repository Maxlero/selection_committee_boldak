package by.grsu.boldak.sqlite;

import by.grsu.boldak.Starter;
import org.apache.log4j.Logger;
import org.sqlite.SQLiteException;

import java.sql.*;

public class SQLiteManager {
	// Getting logger from main instance
	private final Logger logger = Logger.getLogger(Starter.class.getName());

	// Current datebase connection
	private final Connection conn;

	/**
	 * Loads current datebase from resources
	 *
	 * @throws SQLException When datebase file corrupted or no sutable dricver installed
	 */
	public SQLiteManager() throws SQLException {
		ClassLoader classLoader = getClass().getClassLoader();

		// SQLite connection string
		String url = "jdbc:sqlite:" + classLoader.getResource("selection_committee.db");
		conn = DriverManager.getConnection(url);

		if (conn != null) {
			DatabaseMetaData meta = conn.getMetaData();
			logger.info("Base loaded successful. The driver name is " + meta.getDriverName());
		}
	}

	/**
	 * Dumps table `users`
	 *
	 * @throws SQLiteException When smth wrong with datebasse or querry
	 */
	public void selectAll() throws SQLException {
		String query = "SELECT * FROM `users`";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		// loop through the result set
		while (rs.next()) {
			logger.info(new SQLiteUsersObject(rs));
		}
	}
}

package boldak.dzmitry.SQLite;

import org.apache.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.sql.*;

public class SQLiteManager {
	// Getting logger from main instance
	private final Logger logger = Logger.getLogger("Starter");

	private final Connection conn;

	/**
	 * Loads current datebase from resources
	 *
	 * @throws SQLException When datebase file corrupted or no sutable dricver installed
	 */
	public SQLiteManager() throws SQLException {
		String url = "jdbc:sqlite:" + SQLiteManager.class.getResource("selection_committee.db");
		conn = DriverManager.getConnection(url);

		if (conn != null) {
			DatabaseMetaData meta = conn.getMetaData();
			logger.info("Base loaded successful. The driver name is " + meta.getDriverName());
		}
	}

	private Connection connect() {
		ClassLoader classLoader = getClass().getClassLoader();

		// SQLite connection string
		String url = "jdbc:sqlite:" + classLoader.getResource("selection_committee.db");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	public void selectAll() {
		String query = "SELECT id, username FROM users";

		try (Connection conn = this.connect();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query)) {

			// loop through the result set
			while (rs.next()) {
				logger.info(rs.getInt("id") + "\t" +
						rs.getString("username") + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

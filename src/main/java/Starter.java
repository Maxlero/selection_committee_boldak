import boldak.dzmitry.SQLite.SQLiteManager;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class Starter {
	private static final Logger logger = Logger.getLogger(Starter.class);

	public static void main(String args[]) {
		try {
			SQLiteManager sqLiteMenager = new SQLiteManager();
			sqLiteMenager.selectAll();
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
}

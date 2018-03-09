package by.grsu.boldak.sqlite;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLiteUsersObject {
	private int id;
	private String name;
	private int subject1;
	private int subject2;
	private int subject3;
	private int score;
	private int accepted;

	SQLiteUsersObject(ResultSet resultSet) {
		try {
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
				switch (resultSetMetaData.getColumnName(i + 1)) {
					case "id":
						id = resultSet.getInt(i + 1);
						break;
					case "name":
						name = resultSet.getString(i + 1);
						break;
					case "subject1":
						subject1 = resultSet.getInt(i + 1);
						break;
					case "subject2":
						subject2 = resultSet.getInt(i + 1);
						break;
					case "subject3":
						subject3 = resultSet.getInt(i + 1);
						break;
					case "score":
						score = resultSet.getInt(i + 1);
						break;
					case "accepted":
						accepted = resultSet.getInt(i + 1);
						break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + subject1 + "\t" + subject2 + "\t" + subject3 + "\t" + score + "\t" + accepted;
	}

	public int getAccepted() {
		return accepted;
	}

	public int getId() {
		return id;
	}

	public int getSubject1() {
		return subject1;
	}

	public int getSubject2() {
		return subject2;
	}

	public int getSubject3() {
		return subject3;
	}

	public String getName() {
		return name;
	}
}

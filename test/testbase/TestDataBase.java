package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;

import db.DataBaseManager;

public class TestDataBase {

	protected Connection getConnection() throws Exception{
		Class.forName(DataBaseManager.driver);
		Connection con=DriverManager.getConnection(DataBaseManager.dburl, DataBaseManager.dbuser,
				DataBaseManager.dbpassword);
		return con;
	}

	protected IDataSet getDataSet(String filename) throws Exception {
		IDataSet dataSet =
			new XlsDataSet(
					new FileInputStream(new File(filename)));
		return dataSet;
	}

	public void setTestData(String dataFileName) {
		IDatabaseConnection connection = null;
		try {
			Connection con = getConnection();
			connection = new DatabaseConnection(con);

			IDataSet dataSet = getDataSet(dataFileName);
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
	}

	public void removeTestData(String dataFileName) {

		IDatabaseConnection connection = null;
		try {
			Connection con = getConnection();
			connection = new DatabaseConnection(con);

			IDataSet dataSet = getDataSet(dataFileName);
			DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}

	}
}

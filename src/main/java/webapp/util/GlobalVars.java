package webapp.util;

import java.sql.Connection;

import javax.sql.DataSource;

public class GlobalVars {

	public static ThreadLocal<Connection> con = new ThreadLocal<Connection>();
	public static DataSource ds;
	
}

package webapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import javax.sql.DataSource;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.util.EmployeeDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class DataSourceTest {
	
	static Log log = LogFactory.getLog(DataSourceTest.class);
	
	
	@Autowired
	ApplicationContext factory;
	
	@Test
	public void testDriverManagerDataSource() throws SQLException {
		DataSource ds = factory.getBean(DataSource.class);
		
		Connection con = ds.getConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select 2+2 from dual");
		
		rs.next();
		
		int sum = rs.getInt(1);
		
		assertEquals(4, sum);
		
		log.info("sum = " + sum);
		
	}
	
	@Test
	public void testDataSource() throws SQLException {
		String className="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(className);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		
		Connection con = ds.getConnection();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select 1+1 from dual");
		rs.next();
		
		int sum = rs.getInt(1);
		
		assertEquals(2, sum);
		
		log.info("sum=" + sum);
		
		
	}

}

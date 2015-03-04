package webapp.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import webapp.exception.DeptNotFoundException;
import webapp.model.Dept;
import webapp.model.Emp;
import webapp.service.DeptInfoService;
import webapp.util.EmployeeDataSource;

public class InsertTest {
	static GenericXmlApplicationContext factory;
	static Logger log = Logger.getLogger(InsertTest.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log.info("### setUpBeforeClass()");
		factory = new GenericXmlApplicationContext("classpath:/webapp/resource/beans.xml");
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.info("### tearDownAfterClass()");
		factory.close();
	}
	@Test
	public void testInsert() throws SQLException {
		DataSource ds = factory.getBean(DataSource.class);
		
		Connection con = ds.getConnection();
		String sql = "insert into dept values (?, ?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 80);
		pstmt.setString(2, "xxx");
		pstmt.setString(3, "yyyy");
		
		pstmt.executeUpdate();
		
		con.rollback();
//		con.commit();
	}
}
				
	


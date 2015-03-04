package webapp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import webapp.dao.DeptDao;
import webapp.model.Dept;
import webapp.model.Emp;

public class MockDeptDao implements DeptDao{

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dept selectByDeptno(Integer deptno) {
		return null;
	}

	@Override
	public Dept selectByDeptnoWithEmps(Integer deptno) {
		
	Dept dept = null;
	if (deptno == 10) {
		dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname("총무부");
		dept.setLoc("서울");
		
		List<Emp> emps = new ArrayList<Emp>();
		
		Emp emp1 = new Emp();
		emp1.setEmpno(11111); emp1.setEname("홍길동1");
		
		Emp emp2 = new Emp();
		emp2.setEmpno(22222); emp2.setEname("홍길동2");
		
		emps.add(emp1);
		emps.add(emp2);
		
		dept.setEmps(emps);
	}
	return dept;
}

	@Override
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> selectAllWithEmps() {
		// TODO Auto-generated method stub
		return null;
	}

}

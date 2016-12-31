package com.grgbanking.fingervein.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.fingervein.dao.IEmployeeDao;
import com.grgbanking.fingervein.data.EmployeeData;
import com.grgbanking.fingervein.entity.Employee;
import com.grgbanking.fingervein.mapper.IEmployeeMapper;
import com.grgbanking.fingervein.param.EmployeeQueryParam;


@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

    @Autowired
    private IEmployeeMapper employeeMapper;
    
    @Override
    public int save(Employee employee) {
        return employeeMapper.save(employee);
    }

    @Override
    public int saveBatch(List<Employee> employees) {
        return employeeMapper.saveBatch(employees);
    }
    
    @Override
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public int deleteById(String id) {
        return employeeMapper.deleteById(id);
    }

    @Override
    public int delete(Employee employee) {
        return employeeMapper.delete(employee);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return employeeMapper.deleteByIds(ids);
    }

    @Override
    public Employee getById(String id) {
        return employeeMapper.getById(id);
    }

    @Override
    public Employee getData(Employee employee) {
        return employeeMapper.getData(employee);
    }

    @Override
    public int count(EmployeeQueryParam param) {
        return employeeMapper.count(param);
    }

    @Override
    public List<Employee> query(EmployeeQueryParam param, int start,
            int end) {
        return employeeMapper.query(param, start, end);
    }

    @Override
    public List<Employee> queryAll(EmployeeQueryParam param) {
        return employeeMapper.queryAll(param);
    }

	@Override
	public EmployeeData getDataById(String id) {
		return employeeMapper.getDataById(id);
	}
}

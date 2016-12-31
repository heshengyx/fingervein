package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.data.EmployeeData;
import com.grgbanking.fingervein.entity.Employee;
import com.grgbanking.fingervein.param.EmployeeQueryParam;


public interface IEmployeeDao {

    /**
     * 新增
     * @param employee
     * @return
     */
    int save(Employee employee);
    /**
     * 批量新增
     * @param employees
     * @return
     */
    int saveBatch(List<Employee> employees);
    
    /**
     * 修改
     * @param employee
     */
    int update(Employee employee);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param employee
     */
    int delete(Employee employee);
    
    /**
     * 根据ID批量删除
     * @param id
     */
    int deleteByIds(List<String> ids);
    
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Employee getById(String id);
    
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    EmployeeData getDataById(String id);
    
    /**
     * 多条件查找
     * @param employee
     * @return
     */
    Employee getData(Employee employee);

    int count(EmployeeQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Employee> query(EmployeeQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Employee> queryAll(EmployeeQueryParam param);
}

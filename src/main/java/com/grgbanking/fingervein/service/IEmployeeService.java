package com.grgbanking.fingervein.service;

import java.util.List;

import com.grgbanking.fingervein.data.EmployeeData;
import com.grgbanking.fingervein.entity.Employee;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.param.EmployeeQueryParam;


public interface IEmployeeService {

    /**
     * 新增
     * @param employee
     */
    void save(Employee employee);
    /**
     * 批量新增
     * @param employees
     * @return
     */
    void saveBatch(List<Employee> employees);
    /**
     * 批量新增
     * @param data
     * @return
     */
    void saveBatchData(EmployeeData data);
    
    /**
     * 修改
     * @param Employee
     */
    void update(Employee employee);
    
    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 多条件删除
     * @param employee
     */
    void delete(Employee employee);
    
    /**
     * 根据ID批量删除
     * @param id
     */
    void deleteByIds(List<String> ids);
    
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Employee getById(String id);
    
    /**
     * 多条件查找
     * @param employee
     * @return
     */
    Employee getData(Employee employee);
    
    /**
     * 保存或修改
     * @param employee
     */
    void saveOrUpdate(Employee employee);
    
    /**
     * 查询分页
     * @param param
     * @return
     */
    IPage<Employee> query(EmployeeQueryParam param);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Employee> queryAll(EmployeeQueryParam param);
}
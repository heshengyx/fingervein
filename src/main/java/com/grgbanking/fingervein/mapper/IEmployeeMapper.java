package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.data.EmployeeData;
import com.grgbanking.fingervein.entity.Employee;
import com.grgbanking.fingervein.param.EmployeeQueryParam;


public interface IEmployeeMapper {

    /**
     * 新增
     * @param employee
     * @return
     */
    int save(@Param("param") Employee employee);
    /**
     * 批量新增
     * @param employees
     * @return
     */
    int saveBatch(@Param("list") List<Employee> employees);
    
    /**
     * 修改
     * @param employee
     */
    int update(@Param("param") Employee employee);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param employee
     */
    int delete(@Param("param") Employee employee);
    
    /**
     * 根据ID批量删除
     * @param id
     */
    int deleteByIds(@Param("ids") List<String> ids);
    
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Employee getById(@Param("id") String id);
    
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    EmployeeData getDataById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param employee
     * @return
     */
    Employee getData(@Param("param") Employee employee);
    
    int count(@Param("param") EmployeeQueryParam param);
    List<Employee> query(@Param("param") EmployeeQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Employee> queryAll(@Param("param") EmployeeQueryParam param);
}


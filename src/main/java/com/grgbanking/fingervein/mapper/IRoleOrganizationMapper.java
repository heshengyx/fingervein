package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.RoleOrganization;
import com.grgbanking.fingervein.param.RoleOrganizationQueryParam;


public interface IRoleOrganizationMapper {

    /**
     * 新增
     * @param roleOrganization
     * @return
     */
    int save(@Param("param") RoleOrganization roleOrganization);
    /**
     * 批量新增
     * @param roleOrganizations
     * @return
     */
    int saveBatch(@Param("list") List<RoleOrganization> roleOrganizations);
    
    /**
     * 修改
     * @param roleOrganization
     */
    int update(@Param("param") RoleOrganization roleOrganization);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param roleOrganization
     */
    int delete(@Param("param") RoleOrganization roleOrganization);
    
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
    RoleOrganization getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param roleOrganization
     * @return
     */
    RoleOrganization getData(@Param("param") RoleOrganization roleOrganization);
    
    int count(@Param("param") RoleOrganizationQueryParam param);
    List<RoleOrganization> query(@Param("param") RoleOrganizationQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<RoleOrganization> queryAll(@Param("param") RoleOrganizationQueryParam param);
    
    /**
     * 根据用户ID查找机构ID
     * @param userId
     * @return
     */
    List<RoleOrganization> queryByUserId(@Param("userId") String userId);
}


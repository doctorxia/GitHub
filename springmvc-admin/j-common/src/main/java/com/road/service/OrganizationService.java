package com.road.service;

import java.util.List;

import com.road.model.easyui.Tree;
import com.road.model.entity.Organization;

public interface OrganizationService {
    /**
     * 查询部门资源树
     *
     * @return
     */
    List<Tree> findTree();

    /**
     * 查询部门数据表格
     *
     * @return
     */
    List<Organization> findTreeGrid();

    /**
     * 添加部门
     *
     * @param organization
     */
    void addOrganization(Organization organization);

    /**
     * 根据id查找部门
     *
     * @param id
     * @return
     */
    Organization findOrganizationById(Long id);

    /**
     * 更新部门
     *
     * @param organization
     */
    void updateOrganization(Organization organization);

    /**
     * 根据id删除部门
     *
     * @param id
     */
    void deleteOrganizationById(Long id);

}

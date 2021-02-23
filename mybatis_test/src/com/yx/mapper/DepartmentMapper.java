package com.yx.mapper;

import com.yx.po.Department;
import com.yx.po.CriteriaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    int countByExample(CriteriaExample example);

    int deleteByExample(CriteriaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(CriteriaExample example);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") CriteriaExample example);

    int updateByExample(@Param("record") Department record, @Param("example") CriteriaExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}
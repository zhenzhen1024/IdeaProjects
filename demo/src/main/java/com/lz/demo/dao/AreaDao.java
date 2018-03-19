package com.lz.demo.dao;

import com.lz.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     *列出区域列表
     * @return areaList
     */
    List<Area> queryArea();

    /**
     *根据Id列出具体区域
     * @param areaId
     * @return area
     */
    Area queryAreaById(int areaId);

    /**
     *插入区域信息
     * @param area
     * @return areaId
     */
    int insertArea(Area area);

    /**
     *更新区域信息
     * @param area
     * @return areaId
     */
    int updateArea(Area area);

    /**
     *删除区域信息
     * @param areaId
     * @return areaId
     */
    int deleteArea(int areaId);
}

package com.lz.demo.service;

import com.lz.demo.entity.Area;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AreaService {
    /**
     *列出区域列表
     * @return areaList
     */
    List<Area> getAreaList();

    /**
     *根据Id列出具体区域
     * @param areaId
     * @return area
     */
    Area getAreaById(int areaId);

    /**
     *插入区域信息
     * @param area
     * @return areaId
     */
    boolean addArea(Area area);

    /**
     *更新区域信息
     * @param area
     * @return areaId
     */
    boolean modifyArea(Area area);

    /**
     *删除区域信息
     * @param areaId
     * @return areaId
     */
    boolean deleteArea(int areaId);

}

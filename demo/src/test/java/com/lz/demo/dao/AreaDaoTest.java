package com.lz.demo.dao;

import com.lz.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(1, areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1, effectedNum);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setAreaId(3);
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteArea() {
        int effectedNum = areaDao.deleteArea(2);
        assertEquals(1,effectedNum);
    }
}
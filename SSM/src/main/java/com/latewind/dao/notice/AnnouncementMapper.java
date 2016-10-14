package com.latewind.dao.notice;

import java.util.List;

import com.latewind.pojo.notice.Announcement;

public interface AnnouncementMapper {
    int deleteByPrimaryKey(Integer announId);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(Integer announId);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKeyWithBLOBs(Announcement record);

    int updateByPrimaryKey(Announcement record);
   
    List<Announcement> selectCurAnnounce();
}
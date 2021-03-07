package com.heima.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.pojos.WmNewsMaterial;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmNewsMaterialMapper extends BaseMapper<WmNewsMaterial> {

    void saveRelationsByContent(@Param("materialIdList") List<Integer> materialIdList, @Param("newsId") Integer newId, @Param("type") short type);
}

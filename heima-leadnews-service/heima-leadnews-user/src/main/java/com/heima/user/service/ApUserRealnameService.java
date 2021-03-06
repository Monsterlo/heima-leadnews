package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import com.heima.model.user.pojos.ApUserRealname;

public interface ApUserRealnameService extends IService<ApUserRealname> {

    /**
     * 查询认证信息分页列表
     * @param dto
     * @return
     */
    ResponseResult list(AuthDto dto);

    /**
     * 审核接口
     * @param dto
     * @param status
     * @return
     */
    ResponseResult auth(AuthDto dto,Short status);
}

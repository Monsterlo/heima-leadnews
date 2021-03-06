package com.heima.user.controller.v1;

import com.heima.common.constants.user.UserConstants;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import com.heima.user.service.ApUserRealnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class ApUserRealnameController {


    @Autowired
    private ApUserRealnameService apUserRealnameService;

    @PostMapping("/list")
    public ResponseResult list(@RequestBody AuthDto authDto){
        return apUserRealnameService.list(authDto);
    }


    /**
     * 审核通过
     * @param dto
     * @return
     */
    @PostMapping("/authPass")
    public ResponseResult authPass(@RequestBody AuthDto dto){
        return apUserRealnameService.auth(dto, UserConstants.PASS_AUTH);
    }


    /**
     * 审核驳回
     * @param dto
     * @return
     */
    @PostMapping("/authFail")
    public ResponseResult authFail(@RequestBody AuthDto dto){
        return apUserRealnameService.auth(dto,UserConstants.FAIL_AUTH);
    }


}

package com.heima.wemedia.feign;

import com.heima.apis.wemedia.IWemediaClient;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.pojos.WmNews;
import com.heima.model.wemedia.pojos.WmUser;
import com.heima.wemedia.service.WmNewsService;
import com.heima.wemedia.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 自媒体微服务对外提供接口的controller（虽然命名为Client，但是还是controller）
 */
@RestController
public class WemediaClient implements IWemediaClient {

    @Autowired
    private WmUserService wmUserService;

    @Autowired
    private WmNewsService wmNewsService;

    @Override
    @PostMapping("/api/v1/user/save")
    public ResponseResult save(@RequestBody WmUser wmUser) {
        return wmUserService.insert(wmUser);
    }

    @Override
    @GetMapping("/api/v1/user/findByName/{name}")
    public WmUser findByName(@PathVariable("name") String name) {
        return wmUserService.findByName(name);
    }

    @Override
    @GetMapping("/api/v1/news/findOne/{id}")
    public WmNews findNewsById(@PathVariable("id") Integer id) {
        return wmNewsService.getById(id);
    }

    @Override
    @PostMapping("/api/v1/news/update")
    public ResponseResult updateWmNews(@RequestBody WmNews wmNews) {
        wmNewsService.updateById(wmNews);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    @GetMapping("/api/v1/user/findOne/{id}")
    public WmUser findWmUserById(@PathVariable("id") Long id) {
        return wmUserService.getById(id);

    }
}

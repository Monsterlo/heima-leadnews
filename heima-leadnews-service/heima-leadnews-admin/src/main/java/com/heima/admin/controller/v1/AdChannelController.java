package com.heima.admin.controller.v1;

import com.heima.admin.service.AdChannelService;
import com.heima.apis.admin.AdChannelControllerApi;
import com.heima.model.admin.dtos.ChannelDto;
import com.heima.model.admin.pojos.AdChannel;
import com.heima.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/channel")
@Api(value = "频道管理",tags = "channel", description = "频道管理API")
public class AdChannelController implements AdChannelControllerApi {


    @Autowired
    private AdChannelService adChannelService;


    @PostMapping("/list")
    @Override
    public ResponseResult findByNameAndPage(@RequestBody ChannelDto dto) {
        return adChannelService.findByNameAndPage(dto);
    }


    @PostMapping("/save")
    @Override
    public ResponseResult insert(@RequestBody AdChannel adChannel) {
        return adChannelService.insert(adChannel);
    }


    @PostMapping("/update")
    @Override
    public ResponseResult update(@RequestBody AdChannel adChannel) {
        return adChannelService.update(adChannel);
    }

    @GetMapping("/del/{id}")
    @Override
    public ResponseResult deleteById(@PathVariable("id") Integer id) {
        return adChannelService.deleteById(id);
    }
}
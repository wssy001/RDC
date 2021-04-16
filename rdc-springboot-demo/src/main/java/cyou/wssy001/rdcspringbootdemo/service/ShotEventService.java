package cyou.wssy001.rdcspringbootdemo.service;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import cyou.wssy001.rdcspringbootdemo.dto.EventDto;
import cyou.wssy001.rdcspringbootdemo.entity.EventType;
import cyou.wssy001.rdcspringbootdemo.entity.KillEvent;
import cyou.wssy001.rdcspringbootdemo.entity.ShotEvent;
import cyou.wssy001.rdcspringbootdemo.handler.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @projectName: rdc-springboot-demo
 * @className: ShotEventService
 * @description: 处理射击事件
 * @author: alexpetertyler
 * @date: 2021/4/13
 * @version: v1.0
 */
@Service
@Slf4j
public class ShotEventService implements EventHandler {
    @Override
    public void handle(EventType eventType, EventDto dto) {
        ShotEvent shotEvent = new ShotEvent();
        BeanUtil.copyProperties(dto, shotEvent);
        log.info("******shotEvent" + JSON.toJSONString(shotEvent));
    }
}

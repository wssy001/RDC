package cyou.wssy001.rdcspringbootdemo.service;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import cyou.wssy001.rdcspringbootdemo.dto.EventDto;
import cyou.wssy001.rdcspringbootdemo.entity.EventType;
import cyou.wssy001.rdcspringbootdemo.entity.HitEvent;
import cyou.wssy001.rdcspringbootdemo.entity.KillEvent;
import cyou.wssy001.rdcspringbootdemo.handler.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @projectName: rdc-springboot-demo
 * @className: HitEventService
 * @description: 处理命中事件
 * @author: alexpetertyler
 * @date: 2021/4/13
 * @version: v1.0
 */
@Service
@Slf4j
public class HitEventService implements EventHandler {
    @Override
    public void handle(EventType eventType, EventDto dto) {
        HitEvent hitEvent = new HitEvent();
        BeanUtil.copyProperties(dto, hitEvent);
        log.info("******hitEvent" + JSON.toJSONString(hitEvent));
    }
}

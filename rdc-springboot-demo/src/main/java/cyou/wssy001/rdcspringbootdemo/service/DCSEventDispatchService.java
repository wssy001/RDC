package cyou.wssy001.rdcspringbootdemo.service;

import com.alibaba.fastjson.JSON;
import cyou.wssy001.rdcspringbootdemo.dto.EventDto;
import cyou.wssy001.rdcspringbootdemo.entity.EventType;
import cyou.wssy001.rdcspringbootdemo.handler.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @projectName: rdc-springboot-demo
 * @className: DCSEventDispatchService
 * @description: 事件分发
 * @author: alexpetertyler
 * @date: 2021/4/12
 * @version: v1.0
 */
@Service
@Slf4j
public class DCSEventDispatchService implements AutoCloseable {
    private Map<EventType, EventHandler> handlers = new ConcurrentHashMap<>();

    public void bind(EventType eventType, EventHandler eventHandler) {
        handlers.put(eventType, eventHandler);
    }

    public void dispatch(EventDto eventDto) {
        EventType eventType = EventType.getTypeByName(eventDto.getEvent());
        EventHandler handler = handlers.get(eventType);
        if (handler != null) handler.handle(eventType, eventDto);
    }

    @Override
    public void close() throws Exception {

    }
}

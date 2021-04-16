package cyou.wssy001.rdcspringbootdemo.config;

import cyou.wssy001.rdcspringbootdemo.entity.EventType;
import cyou.wssy001.rdcspringbootdemo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @projectName: rdc-springboot-demo
 * @className: EventDispatcherConfig
 * @description: 事件分发配置
 * @author: alexpetertyler
 * @date: 2021/4/13
 * @version: v1.0
 */
@Configuration
@RequiredArgsConstructor
public class EventDispatcherConfig {
    private final TakeOffEventService takeOffEventService;
    private final KillEventService killEventService;
    private final HitEventService hitEventService;
    private final ShotEventService shotEventService;
    private final DCSEventDispatchService dcsEventDispatchService;

    @PostConstruct
    public void init() {
        dcsEventDispatchService.bind(EventType.TAKEOFF, takeOffEventService);
        dcsEventDispatchService.bind(EventType.KILL, killEventService);
        dcsEventDispatchService.bind(EventType.SHOT, shotEventService);
        dcsEventDispatchService.bind(EventType.HIT, hitEventService);
    }
}

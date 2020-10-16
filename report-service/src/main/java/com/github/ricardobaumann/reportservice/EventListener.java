/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.reportservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
@AllArgsConstructor
public class EventListener {

    private final TimelineRepo timelineRepo;

    @StreamListener("devices")
    public void handleDeviceEvents(DeviceEvent deviceEvent) {
        log.info("handled device event: " + deviceEvent);
        timelineRepo.save(new TimelineEvent(
                UUID.randomUUID().toString(),
                deviceEvent.getEventType().toString(),
                deviceEvent.getDevice().getId(),
                deviceEvent.getDevice(),
                new Date()
        ));
    }

    @StreamListener("activities")
    public void handleActivityEvents(Activity activity) {
        log.info("handled activity event: " + activity);
        timelineRepo.save(new TimelineEvent(
                UUID.randomUUID().toString(),
                "created",
                activity.getDeviceId(),
                activity,
                new Date()
        ));
    }

}

/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.deviceservice;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class Scheduler {

    private final MyProcessor myProcessor;

    @Scheduled(fixedRate = 5000L)
    public void run() {
        myProcessor.devices().send(new DeviceEventMessage(new DeviceEvent(
                new Device(
                        "device " + UUID.randomUUID().toString(),
                        "happyhippo",
                        "hardw"
                ),
                EventType.CREATED)));
    }

}

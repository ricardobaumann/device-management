/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.activityservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DeviceEventListener {

    private final DeviceRepo deviceRepo;

    @StreamListener(MyProcessor.DEVICES_QUEUE)
    public void handle(DeviceEvent deviceEvent) {
        log.info("Handling event: " + deviceEvent);
        deviceRepo.save(deviceEvent.getDevice());
    }

}

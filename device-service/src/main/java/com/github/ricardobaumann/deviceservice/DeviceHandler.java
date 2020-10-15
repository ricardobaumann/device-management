/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.deviceservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RepositoryEventHandler
@AllArgsConstructor
public class DeviceHandler {

    private final MyProcessor myProcessor;

    @HandleAfterCreate
    public void handleDeviceCreate(Device device) {
        log.info("Publishing event " + device);
        myProcessor.devices().send(new DeviceEventMessage(new DeviceEvent(device, EventType.CREATED)));
    }
}

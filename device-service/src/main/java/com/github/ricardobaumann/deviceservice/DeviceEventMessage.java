/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.deviceservice;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.Collections;

public class DeviceEventMessage implements Message<DeviceEvent> {

    private final DeviceEvent deviceEvent;

    public DeviceEventMessage(DeviceEvent deviceEvent) {
        this.deviceEvent = deviceEvent;
    }

    @Override
    public DeviceEvent getPayload() {
        return deviceEvent;
    }

    @Override
    public MessageHeaders getHeaders() {
        return new MessageHeaders(Collections.emptyMap());
    }
}

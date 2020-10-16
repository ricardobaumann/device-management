/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.reportservice;

import lombok.Data;

@Data
public class DeviceEvent {
    private Device device;
    private EventType eventType;
}

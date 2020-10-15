/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.activityservice;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {
    String DEVICES_QUEUE = "devices";
    String ACTIVITIES_TOPIC = "activities";

    @Input("devices")
    SubscribableChannel devices();

    @Output("activities")
    MessageChannel activities();

}

/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.deviceservice;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MyProcessor.class)
public class StreamConfig {
}

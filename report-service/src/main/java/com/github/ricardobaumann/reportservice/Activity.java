/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.reportservice;

import lombok.Data;

import java.util.Date;

@Data
public class Activity {

    private String id;

    private String deviceId;

    private Double latitude;

    private Double longitude;

    private Date createdAt;
}

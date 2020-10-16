/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.reportservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TimelineController {

    private final TimelineRepo timelineRepo;

    @GetMapping("/timeline/{deviceId}")
    public List<TimelineEvent> getTimelineEvents(@PathVariable String deviceId) {
        return timelineRepo.findByDeviceIdOrderByCreatedAtDesc(deviceId);
    }

}

/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.reportservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineRepo extends CrudRepository<TimelineEvent, String> {
    List<TimelineEvent> findByDeviceIdOrderByCreatedAtDesc(String deviceId);
}

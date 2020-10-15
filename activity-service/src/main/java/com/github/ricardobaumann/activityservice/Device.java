/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.activityservice;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Device {

    @Id
    private String id;

    @NotNull
    private String owner;

    public Device(String id, @NotNull String owner) {
        this.id = id;
        this.owner = owner;
    }

    public Device() {
    }
}

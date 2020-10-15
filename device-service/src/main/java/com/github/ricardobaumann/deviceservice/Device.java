/*
 * Copyright 2020 the original author or authors.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.github.ricardobaumann.deviceservice;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Device {

    @Id
    private String id = UUID.randomUUID().toString();

    @NotNull
    private String name;
    @NotNull
    private String owner;
    private String hardwareUid;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private String status;
    private String msisdn;

    public Device(@NotNull String name, @NotNull String owner, String hardwareUid) {
        this.name = name;
        this.owner = owner;
        this.hardwareUid = hardwareUid;
    }

    public Device() {
    }
}

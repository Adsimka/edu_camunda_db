package com.worker.service;

import com.worker.dao.AccessRequest;

import java.util.Optional;

public interface AccessRequestService {

    Long create(Long entityId, String username, String comment);

    Optional<AccessRequest> update(Long entityId, String approver, Boolean isApproved);
}

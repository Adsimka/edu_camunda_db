package com.worker.service;

import com.worker.dao.AccessRequest;
import com.worker.repository.AccessRequestRepository;
import com.worker.util.ProcessVariableConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessRequestServiceImpl implements AccessRequestService {

    private final AccessRequestRepository accessRequestRepository;

    @Override
    public Long create(Long entityId, String username, String comment) {
        var accessRequest = buildAccessRequest(entityId, username, comment);

        return accessRequestRepository
                .save(accessRequest)
                .getId();
    }

    @Override
    public Optional<AccessRequest> update(Long entityId, String approver, Boolean isApproved) {
        return accessRequestRepository.findOneByEntityId(entityId)
                .map(request -> {
                    request.setApprover(approver);
                    request.setIsApproved(isApproved);

                    return accessRequestRepository.saveAndFlush(request);
                });
    }

    private AccessRequest buildAccessRequest(Long entityId, String username, String comment) {
        return AccessRequest.builder()
                .entityId(entityId)
                .username(username)
                .comment(comment)
                .build();
    }
}

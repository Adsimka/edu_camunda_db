package com.worker.delegate;

import com.worker.service.AccessRequestService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.worker.util.ProcessVariableConstants.*;

@Component
@RequiredArgsConstructor
public class UpdateAccessRequestDelegate implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        var entityId = (Long) execution.getVariable(ENTITY_ID);
        var approver = (String) execution.getVariable(APPROVER);
        var isApproved = (Boolean) execution.getVariable(IS_APPROVED);

        accessRequestService.update(entityId, approver, isApproved);
    }
}

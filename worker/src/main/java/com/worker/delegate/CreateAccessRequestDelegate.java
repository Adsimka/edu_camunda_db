package com.worker.delegate;

import com.worker.service.AccessRequestService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.worker.util.ProcessVariableConstants.*;

@Component
@RequiredArgsConstructor
public class CreateAccessRequestDelegate implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        var entityId = (Long) execution.getVariable(ENTITY_ID);
        var username = (String) execution.getVariable(USERNAME);
        var comment = (String) execution.getVariable(COMMENT);

        var id = accessRequestService.create(entityId, username, comment);
        execution.setVariable(ID, id);
    }
}

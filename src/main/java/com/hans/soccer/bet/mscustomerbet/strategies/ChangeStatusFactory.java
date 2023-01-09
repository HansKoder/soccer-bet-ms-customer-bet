package com.hans.soccer.bet.mscustomerbet.strategies;

import com.hans.soccer.bet.mscustomerbet.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ChangeStatusFactory {

    private Map<Status, ChangeStatus> changeStatusMap;

    @Autowired
    public ChangeStatusFactory(Set<ChangeStatus> changeStatusSet) {
        this.loadChangeStatusMap(changeStatusSet);
    }

    private void loadChangeStatusMap (Set<ChangeStatus> changeStatusSet) {
        changeStatusMap = new HashMap<>();

        changeStatusSet.forEach(changeStatus -> changeStatusMap.put(changeStatus.getStatus(), changeStatus));
    }

    public ChangeStatus find (Status status) {
        return changeStatusMap.get(status);
    }

}

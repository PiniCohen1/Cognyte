package com.cognyte.firststarter.aop;

import com.cognyte.firststarter.exception.CognyteException;

public interface ExceptionDistributor {
    void deliverException(CognyteException ce);
}

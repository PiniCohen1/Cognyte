package com.cognyte.firststarter.aop;

import com.cognyte.firststarter.exception.CognyteException;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static java.util.Arrays.asList;

public class EmailExceptionDistributor implements ExceptionDistributor {

    private List<String> mails;
    @Value("${support.mails}")
    public  void setMails(String[] mails) {
        this.mails = asList(mails);
    }

    @Override
    public void deliverException(CognyteException ce) {
        System.out.printf("Cognyte Exception occurred, message: %s \n",
                ce.getMessage());
        for (String mail : mails) {
            System.out.printf("Email sent to %s\n", mail);
        }
    }
}

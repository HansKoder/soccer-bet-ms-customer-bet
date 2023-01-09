package com.hans.soccer.bet.mscustomerbet.strategies;

import org.springframework.http.HttpStatus;

public class ChangeStatusResponse {

    private String messageUpdated;
    private String error;
    private HttpStatus codeError;

    public ChangeStatusResponse(ChangeStatusResponseBuilder builder) {
        this.messageUpdated = builder.messageUpdated;
        this.error = builder.error;
        this.codeError = builder.codeError;
    }

    public String getMessageUpdated() {
        return messageUpdated;
    }

    public void setMessageUpdated(String messageUpdated) {
        this.messageUpdated = messageUpdated;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getCodeError() {
        return codeError;
    }

    public void setCodeError(HttpStatus codeError) {
        this.codeError = codeError;
    }

    public static class ChangeStatusResponseBuilder {

        private String messageUpdated;
        private String error;
        private HttpStatus codeError;

        public ChangeStatusResponseBuilder setMessageUpdated (String messageUpdated) {
            this.messageUpdated = messageUpdated;
            return this;
        }

        public ChangeStatusResponseBuilder setError (String error) {
            this.error = error;

            return this;
        }

        public ChangeStatusResponseBuilder setCodeError (HttpStatus codeError) {
            this.codeError = codeError;

            return this;
        }

        public ChangeStatusResponse build () {
            return new ChangeStatusResponse(this);
        }

    }


}

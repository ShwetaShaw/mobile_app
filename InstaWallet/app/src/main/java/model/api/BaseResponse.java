package model.api;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by megha on 11/06/17.
 */

public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Expose
    protected int status;

    @Expose
    protected boolean success;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}

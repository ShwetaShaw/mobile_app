package model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by megha on 11/06/17.
 */

public class UserAuthenticate implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserAuthenticate(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}

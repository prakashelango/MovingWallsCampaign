package com.base.movingwalls.model.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@ApiModel("User Session Token Details")
@Getter
public class UserTokenSessionInfo implements Serializable {

    private static final long serialVersionUID = -7597602634402038857L;

    @ApiModelProperty(notes = "The database generated user, token and session mapping ID.")
    private Long id;

    @ApiModelProperty(notes = "User name.")
    private String username;

    @ApiModelProperty(notes = "Authorization token.")
    private String token;

    @ApiModelProperty(notes = "Session-id received in request header.")
    private String sessionId;

    @ApiModelProperty(notes = "Authorization token expiry time.")
    private Long expiryTime;

    @ApiModelProperty(notes = "The database generated user, token and session mapping created time.")
    private LocalDateTime createdTime;

    @ApiModelProperty(notes = "The database generated user, token and session mapping updated time.")
    private LocalDateTime updatedTime;

    public UserTokenSessionInfo() {
    }

    public UserTokenSessionInfo(String username, String token, String sessionId, Long expiryTime) {
        this.username = username;
        this.token = token;
        this.sessionId = sessionId;
        this.expiryTime = expiryTime;
    }

    @PrePersist
    protected void onCreate() {
        createdTime = LocalDateTime.now();
        updatedTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTime = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTokenSessionInfo that = (UserTokenSessionInfo) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(token, that.token) &&
                Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(expiryTime, that.expiryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, token, sessionId, expiryTime);
    }

    @Override
    public String toString() {
        return "UserTokenSession{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", expiryTime=" + expiryTime +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}

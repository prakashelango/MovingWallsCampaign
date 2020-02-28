package com.base.movingwalls.service.impl.user;

import com.base.movingwalls.common.core.Builder;
import com.base.movingwalls.model.user.User;
import com.base.movingwalls.model.user.UserInfo;

public class UserConverter {

    public static User convertToUser(final UserInfo source) {
        return User.builder()
                .on(user -> user.getUsername())
                .set(source.getUsername())
                .on(user -> user.getCreatedTime())
                .set(source.getCreatedTime())
                .on(user -> user.getPassword())
                .set(source.getPassword())
                .on(user -> user.getPassword())
                .set(source.getPassword())
                .build();
    }


    public static UserInfo convertTo(final User source) {
        return new UserInfo(source.getUsername(), source.getPassword(), source.isEnabled(), source.getCreatedTime(), source.getUpdatedTime());
    }

    public static UserInfo convertToInfo(final User source) {
        return Builder.of(UserInfo.class)
                .with(UserInfo::getId, source.getId())
                .with(UserInfo::getUsername, source.getUsername())
                .with(UserInfo::getPassword, source.getPassword())
                .with(UserInfo::isEnabled, source.isEnabled())
                .with(UserInfo::getCreatedTime, source.getCreatedTime())
                .with(UserInfo::getUpdatedTime, source.getUpdatedTime())
                .build();
    }

    public static User convertWithId(final UserInfo source, final Long id) {
        return User.builder()
                .on(category -> category.getId())
                .set(id)
                .on(category -> category.getUsername())
                .set(source.getUsername())
                .on(category -> category.getPassword())
                .set(source.getPassword())
                .on(category -> category.isEnabled())
                .set(source.isEnabled())
                .on(category -> category.getCreatedTime())
                .set(source.getCreatedTime())
                .on(category -> category.getUpdatedTime())
                .set(source.getUpdatedTime())
                .build();
    }

}

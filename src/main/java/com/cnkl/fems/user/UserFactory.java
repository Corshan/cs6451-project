package com.cnkl.fems.user;

import com.cnkl.fems.user.festivalOrganiser.FestivalOrganiser;

public class UserFactory {

    public static User createUser(User user, String type) {
        return switch (type){
            case "festival_organiser" -> new FestivalOrganiser(user);
            default -> null;
        };
    }

}

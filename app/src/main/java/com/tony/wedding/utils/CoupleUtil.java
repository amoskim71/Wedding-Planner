package com.tony.wedding.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tony.wedding.model.Couple;
import com.tony.wedding.model.Feed;
import com.tony.wedding.model.Guest;
import com.tony.wedding.model.Table;

/**
 * Created by tinashe on 2016/02/18.
 */
public class CoupleUtil {

    public static Couple buildGuestAddedFeed(@NonNull Guest guest) {
        Couple feed = new Couple();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) { //Should never happen
            return feed;
        }

        String name = user.getDisplayName();
        if (TextUtils.isEmpty(name)) {
            name = "";
        }

       /* feed.setVisible(true);
        feed.setOwnerKey(user.getEmail());
        feed.setOwnerUrl(user.getPhotoUrl() == null ? null : user.getPhotoUrl().toString());
        feed.setOwner(name.contains(" ") ? name.substring(0, name.indexOf(" ")) : name);
        feed.setDisplay("...added <b>" + guest.getFirstName() + "</b>");
        feed.setTimestampCreated(Calendar.getInstance().getTimeInMillis());*/


        return feed;
    }

    public static Couple buildGuestAssignedTableFeed(@NonNull Guest guest, @NonNull Table table) {
        Couple couple = new Couple();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) { //Should never happen
            return couple;
        }

        String name = user.getDisplayName();
        if (TextUtils.isEmpty(name)) {
            name = "";
        }

       /* couple.setVisible(true);
        couple.setOwnerKey(user.getEmail());
        couple.setOwnerUrl(user.getPhotoUrl() == null ? null : user.getPhotoUrl().toString());
        couple.setOwner(name.contains(" ") ? name.substring(0, name.indexOf(" ")) : name);
        couple.setDisplay("...assigned <b>" + guest.getFirstName() + "</b> to " + "<b>Table #" + table.getNumber() + "</b>");
        couple.setTimestampCreated(Calendar.getInstance().getTimeInMillis());
*/
        return couple;
    }

    public static boolean isOwner(@NonNull Feed feed) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return false;
        }
        String userEmail = user.getEmail();

        return (!TextUtils.isEmpty(userEmail) &&
                !TextUtils.isEmpty(feed.getOwnerKey()) &&
                feed.getOwnerKey().equals(userEmail));
    }
}

package com.tony.wedding.callbacks;

import com.tony.wedding.model.Couple;
import com.tony.wedding.model.Feed;
import com.tony.wedding.model.Guest;
import com.tony.wedding.model.Table;

import java.util.List;

/**
 * Created by tinashe on 2016/02/12.
 */
public interface MainController {

    boolean isPermissionGranted();

    void hideFab();

    void showFab();

    List<Guest> getGuestList();

    List<Table> getTablesList();

    List<Feed> getFeedList();

    List<Couple> getCoupleList();


    void readGuestList();

    void addGuest(Guest guest);

    void editGuest(Guest guest);

    void deleteGuest(Guest guest);


    void readTableList();

    void addTable(Table table);

    void editTable(Table table);

    void deleteTable(Table table);


    void readFeedList();

    void addFeed(Feed feed);

    void deleteFeed(Feed feed);

    void readCoupleList();

}

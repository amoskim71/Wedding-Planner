package com.tony.wedding.utils;


import com.google.android.gms.maps.model.LatLng;

/**
 * Created by tinashe on 2016/02/08.
 */
public class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where user lists are stored (ie "guestList")
     */
    public static final String FIREBASE_LOCATION_GUESTS = "guestList";
    public static final String FIREBASE_LOCATION_TABLES = "tableList";
    public static final String FIREBASE_LOCATION_FEED = "feedList";
    public static final String FIREBASE_LOCATION_COUPLE = "couple";



    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";


    /**
     * Venue
     */
    public static final LatLng OUDE_LIBERTAS = new LatLng( -1.1987308870134887, 36.90632734447718);


    public static final String COUPLE_PHOTO = "https://goo.gl/Cp5AXc";
}

package edu.sdccd.cisc191.template.GameAssets.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * TODO wip
 * recursive of Locations on a map
 * has a current, previous, and next locations
 */
public class Location {
    /**
     * TODO
     * cities and different points of interest on the map
     */
    public enum SpecificLocation{
        Xian, Zhangye, Constaninople
    }

    private SpecificLocation[] locations; //array of the location point , required for reverse route
    private SpecificLocation locationPoint; //where the player is right now
    private Location next; // the next location player goes to
    private Location previous; //the location the player was at before

    /**
     * creates a location object based on where the player starts
     * sets the current and next location
     * @param chinaStart if the player starts in china
     */
    public Location(boolean chinaStart){
        //if starting from China, get the first city and go in order of enum
        if(chinaStart){
            //makes china -> europe array
            locations = SpecificLocation.values();
            //starts in xian
         locationPoint = locations[0];
         //sets next location to zhangye
        next = setNextLocation();
        }

        //if not starting from China get the cities from the reverse order
        else{
            //makes europe -> china array
            SpecificLocation[] temp = SpecificLocation.values();
            locations = new SpecificLocation[temp.length];
            for (int i = temp.length-1; i > 0; i--) {
                locations[temp.length-1-i]= temp[i];
            }

            //starts in constantinople
            locationPoint = locations[0];
            //sets next location to whatever the next city is
            next =setNextLocation();
        }
    }

    /**
     * make a Location object with a specific location
     * @param location point
     */
    public Location(SpecificLocation location){
        locationPoint = location;
    }

    /**
     * sets the next location
     * @return the next Location
     */
    public Location setNextLocation(){
        //goes through the location array to find where the location is at
        int i = 0;
        while(!locations[i].equals(locationPoint)){
            i++;
        }
        //makes sure not out of bound
        if((i++)<locations.length){
        //add 1 to where the current location is, to get the next!
        return new Location(locations[i]);}
        else{ // if out of bound just return the End point
            return new Location(locations[locations.length]);
        }

    }
    /**
     * move up one location, the current, previous, and next Locations all move
     * to the next SpecificLocation
     */
    public void move() {
        //find where current location is
        int i = 0;
        while(!locations[i].equals(locationPoint)){
            i++;
        }
        //sets prev to what it is right now
        previous = new Location(locationPoint);
        //get the next location
        locationPoint = next.getLocation();
        //set next location
        next = setNextLocation();

    }
    /**
     *
     * @return the location that you are at
     */
    public SpecificLocation getLocation(){
        return locationPoint;
    }
    /**
     *
     * @return the location that you are going to next
     */
    public SpecificLocation getNext(){
        return next.getLocation();
    }

    /**
     *
     * @return the location that you were at previous
     */
    public SpecificLocation getPrevious(){
        return previous.getLocation();
    }
}
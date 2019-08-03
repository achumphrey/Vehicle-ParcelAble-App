package com.example.vehicleparcelableapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {

    private String vehicleMake;
    private String colour;
    private int numberOfDoors;

    public Vehicle(String vehicleMake, String colour, int numberOfDoors) {
        this.vehicleMake = vehicleMake;
        this.colour = colour;
        this.numberOfDoors = numberOfDoors;
    }

    protected Vehicle(Parcel in) {
        vehicleMake = in.readString();
        colour = in.readString();
        numberOfDoors = in.readInt();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(vehicleMake);
        parcel.writeString(colour);
        parcel.writeInt(numberOfDoors);
    }
}

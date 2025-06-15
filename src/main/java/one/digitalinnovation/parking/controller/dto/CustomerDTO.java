package one.digitalinnovation.parking.controller.dto;

import java.util.Set;

public class CustomerDTO {

    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Set<ParkingDTO> parkings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<ParkingDTO> getParkings() {
        return parkings;
    }

    public void setParkings(Set<ParkingDTO> parkings) {
        this.parkings = parkings;
    }
}

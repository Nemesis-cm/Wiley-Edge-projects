package com.sf.superherosightings.dto;

import java.util.Objects;

public class Organization {
    private int id;
    private String name;
    private String description;
    private String contactInfo;
    private int locationId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return id == that.id && locationId == that.locationId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(contactInfo, that.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, contactInfo, locationId);
    }
}

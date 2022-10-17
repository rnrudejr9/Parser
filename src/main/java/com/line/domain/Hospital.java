package com.line.domain;

public class Hospital {
    private String id;
    private String adress;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
    private String subdivision;
    public Hospital() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEmergencyRoom(Integer emergencyRoom) {
        this.emergencyRoom = emergencyRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }


    public Hospital(String id, String adress, String district, String category, Integer emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.adress = adress;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public void print(){
        System.out.println(this.getId());
        System.out.println(this.getAdress());
        System.out.println(this.getDistrict());
        System.out.println(this.getCategory());
        System.out.println(this.getEmergencyRoom());
        System.out.println(this.getName());
        System.out.println(this.getSubdivision());
    }

    public String getAdress() {
        return adress;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

}

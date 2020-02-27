package com.metacube.eadSession4.model;

public class ParkingPass {
	private int passNumber;
	private String passType;
	private String vehicleNumber;
	
	public int getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(int passNumber) {
		this.passNumber = passNumber;
	}

	public String getPassType() {
		return passType;
	}
	
	public void setPassType(String passType) {
		this.passType = passType;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
}

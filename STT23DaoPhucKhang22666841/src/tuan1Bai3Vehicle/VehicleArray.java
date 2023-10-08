package tuan1Bai3Vehicle;

public class VehicleArray {
	private Vehicle[] vehicles;
	public int sptThuc = 0;
	
	public Vehicle[] getVehicleArray() {
		return this.vehicles;
	}
	
	public void add(Vehicle veh) throws Exception {
		if(!isExisingVehicle(veh.getTenChuXe())) {
			if (sptThuc == vehicles.length) 
				vehicles = tangKichThuoc(vehicles, sptThuc * 2);
			vehicles[sptThuc++] = veh;
		}else {
			throw new Exception("Dữ liệu người này đã tồn tại");
		}
	}
	
	public boolean isExisingVehicle(String name) {
		for (int i = 0; i < sptThuc; i++) {
			if (vehicles[i].getTenChuXe() == name) return true;
		}
		return false;
	}
	
	public Vehicle[] tangKichThuoc(Vehicle[] array, int newLength) {
		Vehicle[] newArray = new Vehicle[newLength];
		for (int i = 0; i < sptThuc; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	public VehicleArray() {
		super();
		this.vehicles = new Vehicle[1];
	}
	
	
}

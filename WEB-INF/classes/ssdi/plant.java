package ssdi;

public class plant {
private String plantname;
public String getPlantname() {
	return plantname;
}
public void setPlantname(String plantname) {
	this.plantname = plantname;
}
private String region;
private String soiltype;
private String sunexposure;
private String moisture;
private String description;

public  void setPlantName(String name) {
    this.plantname=name;
}
public  void setRegion(String region) {
    this.region=region;
}
public  void setSoiltype(String soiltype) {
    this.soiltype=soiltype;
}
public  void setSunexposure(String sunexposure) {
    this.sunexposure=sunexposure;
}
public  void setMoisture(String moisture) {
    this.moisture=moisture;
}
public  void setDescription(String description) {
    this.description=description;
}

public String getPlantName() {
    return plantname;
}

public String getRegion() {
    return region;
}
public String getSoiltype() {
    return soiltype;
}
public String getSunexposure() {
    return sunexposure;
}
public String getMoisture() {
    return moisture;
}
public String getDescription() {
    return description;
}
}

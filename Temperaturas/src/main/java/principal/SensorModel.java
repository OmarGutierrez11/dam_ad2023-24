package principal;

public class SensorModel {

    private int modelCode;
    private String modelName;
    private double minTemperatureRange;
    private double maxTemperatureRange;
    private String manufacturer;

    public SensorModel(int modelCode, String modelName, double minTemperatureRange, double maxTemperatureRange, String manufacturer) {
        this.modelCode = modelCode;
        this.modelName = modelName;
        this.minTemperatureRange = minTemperatureRange;
        this.maxTemperatureRange = maxTemperatureRange;
        this.manufacturer = manufacturer;
    }

    public int getModelCode() {
        return modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public double getMinTemperatureRange() {
        return minTemperatureRange;
    }

    public double getMaxTemperatureRange() {
        return maxTemperatureRange;
    }

    public String getManufacturer() {
        return manufacturer;
    }


}

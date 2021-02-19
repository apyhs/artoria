package artoria.data;

import java.io.Serializable;

/**
 * Device information object.
 * @author Kahle
 */
public class Device extends AbstractExtraData implements Serializable {
    /**
     * The id of the device.
     */
    private String id;
    /**
     * The name of the device.
     */
    private String name;
    /**
     * The type of the device.
     */
    private String type;
    /**
     * The name of the company the device is branded with (e.g. Apple).
     */
    private String brandName;
    /**
     * The model of the device.
     */
    private String model;
    /**
     * The code name of the device.
     * @see <a href="https://en.wikipedia.org/wiki/Code_name">Code name</a>
     */
    private String codeName;
    /**
     * The display or market name of the device.
     */
    private String displayName;
    /**
     * The manufacturer of the device.
     */
    private String manufacturer;
    /**
     * The description of the device.
     */
    private String description;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getBrandName() {

        return brandName;
    }

    public void setBrandName(String brandName) {

        this.brandName = brandName;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public String getCodeName() {

        return codeName;
    }

    public void setCodeName(String codeName) {

        this.codeName = codeName;
    }

    public String getDisplayName() {

        return displayName;
    }

    public void setDisplayName(String displayName) {

        this.displayName = displayName;
    }

    public String getManufacturer() {

        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {

        this.manufacturer = manufacturer;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

}

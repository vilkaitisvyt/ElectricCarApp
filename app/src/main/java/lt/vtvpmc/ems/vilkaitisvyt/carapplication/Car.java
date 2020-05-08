package lt.vtvpmc.ems.vilkaitisvyt.carapplication;

import java.io.Serializable;

public class Car implements Serializable {

    private int id;

    private String plateNumber;

    private CarLocation location;

    private CarModel model;

    private int batteryPercentage;

    private int batteryEstimatedDistance;

    private boolean isCharging;

    public int getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public CarLocation getLocation() {
        return location;
    }

    public CarModel getModel() {
        return model;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public int getBatteryEstimatedDistance() {
        return batteryEstimatedDistance;
    }

    public boolean isCharging() {
        return isCharging;
    }

        static class CarModel implements Serializable {

            private int id;
            private String title;
            private String photoUrl;

            public int getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getPhotoUrl() {
                return photoUrl;
            }
        }

        static class CarLocation implements Serializable {

            private int id;
            private float latitude;
            private float longitude;
            private String adress;

            public int getId() {
                return id;
            }

            public float getLatitude() {
                return latitude;
            }

            public float getLongitude() {
                return longitude;
            }

            public String getAdress() {
                return adress;
            }
        }
}

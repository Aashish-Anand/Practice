package designPattern;
class Vehicles {
    //required parameter
    private String engine;
    private int wheel;

    //optional parameter
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    private Vehicles(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicles build() {
            return new Vehicles(this);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args) {
        Vehicles v1 = new Vehicles.VehicleBuilder("2000CC", 4).setAirbags(4).build();
        Vehicles v2 = new Vehicles.VehicleBuilder("200CC",2).build();

        System.out.println("Car");
        System.out.println(v1.getAirbags());
        System.out.println(v1.getEngine());
        System.out.println(v1.getWheel());

        System.out.println("\nBike");
        System.out.println(v2.getAirbags());
        System.out.println(v2.getEngine());
        System.out.println(v2.getWheel());

    }
}

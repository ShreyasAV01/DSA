package com.example.Design.Patterns.Builder;

public class Laptop {
    private String brand;
    private int ramGB;
    private int memory;
    private boolean hasSSD;

    //    private constructor for the laptop object
    private Laptop(LaptopBuilder builder) {
        this.memory = builder.memory;
        this.brand = builder.brand;
        this.hasSSD = builder.hasSSD;
        this.ramGB = builder.ramGB;
    }

    @Override
    public String toString() {
        return "LaptopBuilder{" +
                "brand='" + brand + '\'' +
                ", ramGB=" + ramGB +
                ", memory=" + memory +
                ", hasSSD=" + hasSSD +
                '}';
    }

    public static class LaptopBuilder {
        private String brand;
        private int ramGB;
        private int memory;
        private boolean hasSSD;

        //required field constructor
        public LaptopBuilder(String brand) {
            this.brand = brand;
        }

        //optional setters
        public LaptopBuilder ramGB(int ramGB) {
            this.ramGB = ramGB;
            return this;
        }

        //optional setters
        public LaptopBuilder memory(int memory) {
            this.memory = memory;
            return this;
        }

        //optional setters
        public LaptopBuilder hasSSD(boolean hasSSD) {
            this.hasSSD = hasSSD;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }

    }

    public static void main(String[] args) {
        Laptop hpLaptop = new Laptop.LaptopBuilder("HP")
                .ramGB(16)
                .memory(512)
                .hasSSD(true)
                .build();
        Laptop dellLaptop = new Laptop.LaptopBuilder("DELL")
                .ramGB(16)
                .memory(512)
                .hasSSD(true)
                .build();
        System.out.println(hpLaptop);
        System.out.println(dellLaptop);
    }
}



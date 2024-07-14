public class PCDirector {
    private PC.PCBuilder builder;

    public PCDirector(PC.PCBuilder builder) {
        this.builder = builder;
    }

    public PC GamingPC() {
        return builder
                .setCPU("Intel Core i9")
                .setGPU("NVIDIA RTX 3080")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setPowerSupply("750W")
                .build();
    }

    public PC OfficePC() {
        return builder
                .setCPU("Intel Core i5")
                .setGPU("Integrated Graphics")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setPowerSupply("500W")
                .build();
    }

}

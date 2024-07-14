public class PC {
    private final String CPU;
    private final String GPU;
    private final String RAM;
    private final String storage;
    private final String powerSupply;

    private PC(PCBuilder builder) {
        this.CPU = builder.CPU;
        this.GPU = builder.GPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.powerSupply = builder.powerSupply;
    }

    @Override
    public String toString() {
        return " CPU: " + CPU + ", GPU:  " + GPU + ", RAM: " + RAM + ", storage : " + storage + ", powerSupply:" + powerSupply ;
    }
    public PCBuilder changeBuilder() {
        PCBuilder builder = new PCBuilder();
        builder.setCPU(this.CPU)
                .setGPU(this.GPU)
                .setRAM(this.RAM)
                .setStorage(this.storage)
                .setPowerSupply(this.powerSupply);
        return builder;
    }
    public static class PCBuilder {
        private String CPU;
        private String GPU;
        private String RAM;
        private String storage;
        private String powerSupply;

        public PCBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public PCBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public PCBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public PCBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public PCBuilder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public PC build() {
            return new PC(this);
        }
    }
}

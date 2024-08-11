public class Main {
    public static void main(String[] args) {
        PC.PCBuilder builder = new PC.PCBuilder();
        PCDirector director = new PCDirector(builder);

        // create a Gaming PC
        PC gamingPC = director.GamingPC();
        System.out.println("Gaming PC before : " + gamingPC);

        // change a Gaming PC

        PC changedpc = gamingPC.changeBuilder()
                .setRAM("64GB")
                .build();
        System.out.println("Gaming PC after : " + changedpc);


        // create Office pc
        PC OfficePC = director.OfficePC();

        System.out.println("Office PC: " + OfficePC);

        //create customized pc
        PC customPC = builder
                .setCPU("Intel Core i9")
                .setGPU("NVIDIA RTX 3080")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setPowerSupply("750W")
                .build();

        System.out.println("customized PC: "+customPC);
    }
}

public class Assembler {
    /*TODO 2: declare these private instance variables: cpu, ram, storage and graphicsCard.*/
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String graphicsCard;

    /*TODO 3: Add a constructor method for this class by using the Generate option from the menu that pops up on right-click.*/

    public Assembler(String cpu, String ram, String storage, String graphicsCard) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
    }
    /*TODO 4: similarly, add getters for all instance variables.*/

    public String getCpu() {
        return cpu;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public static class Builder {
        /*TODO 6: declare the same private instance variables: cpu, ram, storage and graphicsCard.*/

        /*TODO 7: Define setter methods for these instance variables.The setCpu() method is given below.
           Follow the same to add setRam(), setStorage() and setGraphicsCard() methods*/

        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;

        public setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public void setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public void setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public void setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }





        /* TODO 8: Define build() method that returns an object of Assembler class*/
    }

    }

}




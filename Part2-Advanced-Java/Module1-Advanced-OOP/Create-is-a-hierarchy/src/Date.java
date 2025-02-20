public class Date {
    int dd;
    int mm;
    int yy;

    Date(int d, int m, int y) {
        this.dd = d;
        this.mm = m;
        this.yy = y;
    }

//    @Override
//    void getDetails() {
//    }

    String getDate() {
        return this.dd + "-" + this.mm + "-" + this.yy;
    }

}

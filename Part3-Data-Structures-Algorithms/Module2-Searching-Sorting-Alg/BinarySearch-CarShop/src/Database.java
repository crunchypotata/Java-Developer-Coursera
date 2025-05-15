import java.util.ArrayList;
import java.util.TreeMap;

public class Database {
    private TreeMap<String, Registration> treeMap = new TreeMap<>();
    private Registration[] registrations;

    public Database() {
        // Initialize the list of registrations
        ArrayList<Registration> arrayList = new ArrayList<>(30);
        arrayList.add(new Registration("SGL-6855", "Tyler Lennon"));
        arrayList.add(new Registration("SDN-2659", "Margaret Jeffers"));
        arrayList.add(new Registration("ANA-2866", "Zane Hallworth"));
        arrayList.add(new Registration("DYC-5707", "Jodi Gatfield"));
        arrayList.add(new Registration("GIG-1870", "Harvey Kilkenny"));
        arrayList.add(new Registration("NWK-2057", "Janice Hudson"));
        arrayList.add(new Registration("BYJ-6279", "Larry Newman"));
        arrayList.add(new Registration("ENY-2915", "Helen Pryor"));
        arrayList.add(new Registration("OYW-0632", "Quincy Cromwell"));
        arrayList.add(new Registration("KEC-3996", "Kathy Myers"));
        arrayList.add(new Registration("HOZ-1224", "Hugh Haines"));
        arrayList.add(new Registration("KGJ-5010", "Tammy Mallard"));
        arrayList.add(new Registration("FVA-4467", "Michael Knowles"));
        arrayList.add(new Registration("NEV-9119", "Michael Knowles"));
        arrayList.add(new Registration("BJT-9772", "Karl Yardley"));
        arrayList.add(new Registration("YQD-3410", "Andrea Elsworth"));
        arrayList.add(new Registration("DUY-0288", "Jay Zagorski"));
        arrayList.add(new Registration("ATZ-9783", "Sally Oakes"));
        arrayList.add(new Registration("IAG-6602", "Patrick Hewitt"));
        arrayList.add(new Registration("DCP-2974", "Donna Wardman"));
        arrayList.add(new Registration("FAH-2515", "Jay Newton"));
        arrayList.add(new Registration("GYF-3958", "Carla Collins"));
        arrayList.add(new Registration("NCL-9068", "James McBride"));
        arrayList.add(new Registration("UBJ-1923", "Helen Gibbs"));
        arrayList.add(new Registration("UUG-4837", "Conrad Pryor"));
        arrayList.add(new Registration("GMD-6786", "Tracy Gilbert"));
        arrayList.add(new Registration("QTW-6473", "Donald Gatfield"));
        arrayList.add(new Registration("QQE-3264", "Charlotte Newport"));
        arrayList.add(new Registration("WAO-8258", "Rodney Gilbert"));

        // Add registrations to the TreeMap
        for (Registration reg : arrayList) {
            treeMap.put(reg.license, reg);
        }

        // Convert TreeMap values to an array
        registrations = treeMap.values().toArray(new Registration[0]);
    }

    public Registration[] getRegistrations() {
        return registrations;
    }

}
package Transport;

public class TransportRunner {
    public static void main(String[] args) {

        LandPassenger pas = new LandPassenger();
        pas.print();
        pas.fuelDist(3);
        System.out.println();

        LandFreight fr = new LandFreight();
        fr.print();
        fr.carringFr(22);
        System.out.println();

        AirCivil ac = new AirCivil();
        ac.print();
        ac.airPassengers(100);
        System.out.println();

        AirMilitary am = new AirMilitary();
        am.print();
        am.shootMiss();
        am.shootMiss();
        am.shootMiss();
        am.eject();

    }
}
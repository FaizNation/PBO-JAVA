class Pet {
    String rasPet;

    public Pet(String rasPet) {
        this.rasPet = rasPet;
    }

    public void suara() {
        System.out.println(rasPet + " bersuara...");
    }
}

class Anjing extends Pet {
    public Anjing(String rasPet) {
        super(rasPet);
    }

    @Override
    public void suara() {
        System.out.println(rasPet + " menggonggong: Woof woof!");
    }
}

public class soal2 {
    public static void main(String[] args) {
        Anjing p = new Anjing("Husky");
        p.suara();
    }
}

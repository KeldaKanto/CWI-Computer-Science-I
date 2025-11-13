public class Coin {
    private CoinFace currentFace = CoinFace.HEADS;
    private CoinFace face;

    private enum CoinFace {
        HEADS, TAILS;
    }

    public Coin () {
        flip ();
    }

    public void flip() {
        face = (Math.random() * 2 > 1) ? CoinFace.HEADS : CoinFace.TAILS;
    }

    public boolean isHeads() {
        return (face.ordinal() == currentFace.ordinal());
    }

    public String toString() {
        return (face.ordinal() == currentFace.ordinal()) ? "Heads" : "Tails";
    }
}

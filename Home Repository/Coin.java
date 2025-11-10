public class Coin {
    private CoinFace currentFace = CoinFace.heads;
    private CoinFace face;

    private enum CoinFace {
        heads, tails;
    }

    public Coin () {
        flip ();
    }

    public void flip() {
        face = (Math.random() * 2 > 1) ? CoinFace.heads : CoinFace.tails;
    }

    public boolean isHeads() {
        return (face.ordinal() == currentFace.ordinal());
    }

    public String toString() {
        return (face.ordinal() == currentFace.ordinal()) ? "Heads" : "Tails";
    }
}

package number;

public class WaterAndJugProblem {
	public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(z == 0) return true;
        if(x == 0) return y == z;
        if(y == 0) return x == z;

        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}

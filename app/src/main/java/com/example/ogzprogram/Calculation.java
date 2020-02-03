package com.example.ogzprogram;

public class Calculation {
    /**
     * Розрахунок дирекційного кута
     *
     * @param Xknp координати КСП (Х)
     * @param Yknp координати КСП (У)
     * @param X_z  координати цілі (Х)
     * @param Y_z  координати цілі (У)
     * @return Розраховується Дирекційний кут з КСП на Ціль
     */
    public float Ak(float Xknp, float Yknp, float X_z, float Y_z) {
        float dx = X_z - Xknp;
        float dy = Y_z - Yknp;

        double Ak = Math.atan2(dy, dx) * 30 / Math.PI;
        if (Ak < 0) {
            Ak = Ak + 60;
        }

        return (float) Ak;
    }

    /**
     * Розрахунок Дальності
     *
     * @param Xknp координати КСП (Х)
     * @param Yknp координати КСП (У)
     * @param X_z  координати цілі (Х)
     * @param Y_z  координати цілі (У)
     * @return Розраховується Дальність з КСП на Ціль
     */
    public float Dk(float Xknp, float Yknp, float X_z, float Y_z) {
        float dx = X_z - Xknp;
        float dy = Y_z - Yknp;

        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}

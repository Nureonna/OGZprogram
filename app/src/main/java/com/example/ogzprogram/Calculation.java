package com.example.ogzprogram;

public class Calculation {
    /**
     * Розрахунок дирекційного кута
     *
     * @param xPost   координати КСП (Х)
     * @param yPost   координати КСП (У)
     * @param xTarget координати цілі (Х)
     * @param yTarget координати цілі (У)
     * @return Розраховується Дирекційний кут з КСП на Ціль
     */
    public float calculateAngle(float xPost, float yPost, float xTarget, float yTarget) {
        float dx = xTarget - xPost;
        float dy = yTarget - yPost;

        double result = Math.atan2(dy, dx) * 30 / Math.PI;
        if (result < 0) {
            result = result + 60;
        }

        return (float) result;
    }

    /**
     * Розрахунок Дальності
     *
     * @param xPost   координати КСП (Х)
     * @param yPost   координати КСП (У)
     * @param xTarget координати цілі (Х)
     * @param yTarget координати цілі (У)
     * @return Розраховується Дальність з КСП на Ціль
     */
    public float calculateDistance(float xPost, float yPost, float xTarget, float yTarget) {
        float dx = xTarget - xPost;
        float dy = yTarget - yPost;

        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}

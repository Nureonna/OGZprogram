package com.example.ogzprogram;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Enclosed.class)
public class CalculationTest {

    private static Calculation calculation;

    @RunWith(Parameterized.class)
    public static class CalculateAngleTest {

        private float exp;
        private float xPost;
        private float yPost;
        private float xTarget;
        private float yTarget;

        public CalculateAngleTest(float exp, float xPost, float yPost, float xTarget, float yTarget) {

            this.exp = exp;
            this.xPost = xPost;
            this.yPost = yPost;
            this.xTarget = xTarget;
            this.yTarget = yTarget;
        }

        @Before()
        public void setUp() {
            calculation = new Calculation();
        }

        @Test()
        public void calculateAngleTestWithCorrectValues() {

            float act = calculation.calculateAngle(xPost, yPost, xTarget, yTarget);

            Assert.assertEquals(exp, act, 0.01);
        }

        @Test()
        public void calculateAngleTestWithError() {
            float error = 10;
            float act = calculation.calculateAngle(xPost, yPost, xTarget, yTarget);
            act += error;

            Assert.assertNotEquals(exp, act, 0.000000001);
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0f, -1000000000000000f, -1000000000000000f, -1000000000000000f, -1000000000000000f},
                    {0f, 0f, 0f, 0f, 0f},
                    {0f, -1000000000000000f, -1000000000000000f, -1000000000000000f, -1000000000000000f},
                    {0f, -1000000000000000f, 1000000000000000f, -1000000000000000f, 1000000000000000f},
                    {0f, 1000000000000000f, -1000000000000000f, 1000000000000000f, -1000000000000000f},
                    {7.5f, -1000000000000000f, -1000000000000000f, 1000000000000000f, 1000000000000000f},
                    {37.5f, 1000000000000000f, 1000000000000000f, -1000000000000000f, -1000000000000000f},
                    {6.938923223f, 1f, 2f, 10f, 10f},
                    {15.04026815f, 5824f, 58920f, 2334f, 886543f},
            });
        }

    }
}

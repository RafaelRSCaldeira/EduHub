package com.example.eduhub.utils;

import android.graphics.Color;
import java.util.Random;

public class ColorUtils {
    public static String generateRandomRainbowColorHex() {
        Random random = new Random();
        float hue = random.nextFloat() * 360;  // Matiz aleatório entre 0 e 360
        float saturation = 1.0f;               // Saturação 100%
        float value = 1.0f;                    // Valor 100%

        // Gera a cor no formato ARGB e converte para RGB hex
        int colorInt = Color.HSVToColor(new float[]{hue, saturation, value});
        return String.format("#%06X", (0xFFFFFF & colorInt));
    }
}
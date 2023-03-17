package org.campus02.figures;

import java.util.ArrayList;
import java.util.HashMap;

public class FigureManager {
    private ArrayList<Figure> figures = new ArrayList<>();

    public void add(Figure f) {
        figures.add(f);
    }

    public double getMaxPerimeter() {
        double umfang = 0;
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i).getPerimeter() > umfang) {
                umfang = figures.get(i).getPerimeter();
            }
        }
        return umfang;
    }

    public Figure getFigureWithMaxPerimeter() {
        double maxPerimeter = getMaxPerimeter();
        for (Figure f: figures ) {
            if (f.getPerimeter() == maxPerimeter)
                return f;
        }
        return null;
    }

    public Figure getFigureWithMaxPerimeter2() {
        double umfang = 0;
        Figure figureWithMaxPerimeter = null;
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i).getPerimeter() > umfang) {
                umfang = figures.get(i).getPerimeter();
                figureWithMaxPerimeter = figures.get(i);
            }
        }
        return figureWithMaxPerimeter;
    }

    public double getAverageAreaSize() {
        double sumArea = 0;

        for (Figure f :  figures) {
            sumArea += f.getArea();
        }
        return sumArea / figures.size();
    }

    public HashMap<String, Double> getAreaBySizeCategories()
    {
        HashMap<String, Double> result = new HashMap<>();
        double klein = 0, mittel =0, gross = 0;

        for (Figure f: figures) {
            if (f.getArea() < 1000)
                klein += f.getArea();
            else if (f.getArea() < 5000)
                mittel += f.getArea();
            else
                gross += f.getArea();
        }

        result.put("klein", klein);
        result.put("mittel", mittel);
        result.put("groß", gross);

        return result;
    }


    public HashMap<String, Double> getAreaBySizeCategories2()
    {
        HashMap<String, Double> result = new HashMap<>();

        // die kategorien werden hier initial (mit 0) in die Map geschrieben
        result.put("klein", 0.0);
        result.put("mittel", 0.0);
        result.put("groß", 0.0);

        for (Figure f: figures) {
            if (f.getArea() < 1000)
                result.put("klein", result.get("klein") + f.getArea());
            else if (f.getArea() < 5000)
                result.put("mittel", result.get("mittel") + f.getArea());
            else
                result.put("groß", result.get("groß") + f.getArea());
        }

        return result;
    }

    public HashMap<String, Double> getAreaBySizeCategories3()
    {
        // verwende result.getOrDefault(key, defaultWert)
        // ist der key bereits in der Map, dann wird der Value retourniert
        // ist der key nicht drinnen, wird der default wert geliefert

        HashMap<String, Double> result = new HashMap<>();
        for (Figure f: figures) {
            if (f.getArea() < 1000)
                result.put("klein", result.getOrDefault("klein", 0.0) + f.getArea());
            else if (f.getArea() < 5000)
                result.put("mittel", result.getOrDefault("mittel", 0.0) + f.getArea());
            else
                result.put("groß", result.getOrDefault("groß", 0.0) + f.getArea());
        }

        return result;
    }
}

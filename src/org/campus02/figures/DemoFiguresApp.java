package org.campus02.figures;

public class DemoFiguresApp {

    public static void main(String[] args) {

        FigureManager fm = new FigureManager();

        fm.add(new Circle(22));
        fm.add(new Rectangle(30, 20));
        fm.add(new Circle(88));
        fm.add(new Rectangle(39, 17));
        fm.add(new Circle(18));


        System.out.println(fm.getMaxPerimeter());
        System.out.println(fm.getAreaBySizeCategories());
        System.out.println(fm.getAreaBySizeCategories2());
        System.out.println(fm.getAreaBySizeCategories3());
        System.out.println(fm.getAverageAreaSize());


    }
}

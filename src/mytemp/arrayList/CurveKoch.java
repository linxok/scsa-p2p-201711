package mytemp.arrayList;/*
 * License GNU GPL v2 http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (c) 2012, vankof@gmail.com
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class CurveKoch extends JApplet {

    private boolean drawn = false;
    private Graphics2D g2 = null;

    @Override
    public void paint(Graphics g) {

        if (drawn)
            return;
        drawn = true;

        super.paint(g);

        g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.gray);

        /* Расчет координат треугольника для прорисовки снежинки Коха */
        double a = 300; // Длина стороны треугольника (px)
        double p1x = 250; // Координата x нижней левой точки основания треугольника (px)
        double p1y = 400; // Координата y нижней левой точки основания треугольника (px)
        double p2x = p1x + a;
        double p2y = p1y;
        double h = Math.sqrt(Math.pow(a, 2) - Math.pow((a / 2), 2) / 4);
        double pmx = (p1x + p2x) / 2;
        double pmy = (p1y + p2y) / 2;
        double p3x = pmx + (h * (p1y - pmy)) / (a / 2);
        double p3y = pmy + (h * (p1x - pmx)) / (a / 2);

        /* Сравнительный тест быстроты рекурсионного алгоритма (drawCurveKochRecur)
         * и алгоритма с циклом и массивом (drawCurveKoch).
         * Рисуются последовательно 4 одинаковые кривые Коха разными алгоритмами.
         * Рекурсивный алгоритм выполняется намного медленнее.
         * Возможно, это вызвано особенностями реализации конкретно
         * этого примера на Java. Прежде чем делать выводы, необходим
         * подробный анализ алгоритма.
         */
//        drawCurveKoch     (new Line2D.Double(600,150,200,150), 8);
//        drawCurveKochRecur(new Line2D.Double(600,300,200,300), 8);
//        drawCurveKoch     (new Line2D.Double(600,450,200,450), 4);
//        drawCurveKochRecur(new Line2D.Double(600,600,200,600), 4);
/*
        *//* Кривые Коха с разным количеством итераций *//*
        int y = 40; // Стартовая позиция первой кривой по оси Y
        int iter = 0;
        while(y < 800){ // Максимальная высота области рисования
            drawCurveKochRecur(new Line2D.Double(600,y,200,y), iter);
            y+=140; // Расстояние между кривыми
            iter++;
        }*/
/*

        */
/* Обычная снежинка Коха (Koch snowflake) *//*

        drawCurveKochRecur(new Line2D.Double(p1x,p1y,p2x,p2y), 5); // Основание
        drawCurveKochRecur(new Line2D.Double(p3x,p3y,p1x,p1y), 5); // Левая
        drawCurveKochRecur(new Line2D.Double(p2x,p2y,p3x,p3y), 5); // Правая

        */
/* Снежинка Коха с разным количеством итераций на разных стронах *//*

        drawCurveKoch(new Line2D.Double(p1x, p1y, p2x, p2y), 3); // Основание
        drawCurveKoch(new Line2D.Double(p3x, p3y, p1x, p1y), 4); // Левая
        drawCurveKoch(new Line2D.Double(p2x, p2y, p3x, p3y), 5); // Правая

        */
/* Две кривых Коха, расположенных зеркально *//*

        drawCurveKochRecur(new Line2D.Double(500,300,100,300), 5);
        drawCurveKochRecur(new Line2D.Double(100,300,500,300), 5);

        */
/* Cesaro fractal - кривые Коха на основе квадрата, вогнутые во внутрь. *//*

        drawCurveKochRecur(new Line2D.Double(200, 200, 600, 200), 5);
        drawCurveKochRecur(new Line2D.Double(600, 200, 600, 600), 5);
        drawCurveKochRecur(new Line2D.Double(600, 600, 200, 600), 5);
        drawCurveKochRecur(new Line2D.Double(200, 600, 200, 200), 5);

        */
/* Маленький фрактал Коха на основе ромба внутри фрактала Cesaro *//*

        drawCurveKochRecur(new Line2D.Double(460,400,400,340), 4);
        drawCurveKochRecur(new Line2D.Double(400,460,460,400), 4);
        drawCurveKochRecur(new Line2D.Double(340,400,400,460), 4);
        drawCurveKochRecur(new Line2D.Double(400,340,340,400), 4);

*/
    }

    /** Нарисовать кривую Коха на основе линии line.
     * Колическтво итераций - maxIter.
     * Алгоритм с циклом и массивом для хранения линий следующего итерационного цикла.
     */
    private void drawCurveKoch(Line2D line, int maxIter) {

        int j = 0;
        int ln = 0;
        Line2D[] linesNext = null;
        int linesNextLength = 0;
        int linesNextCnt = 0;
        int i = 0;
        Line2D[] linesDraw = null;
        Point2D ps = null;
        Point2D pe = null;
        double a = 0;
        double h = 0;

        drawLine(line);

        a = line.getP1().distance(line.getP2());

        linesNext = new Line2D[1];
        linesNext[0] = line;

        for (i = 0; i < maxIter; i++) {

            linesDraw = linesNext;

            a = a / 3;
            //g2.drawString(String.valueOf(a), 10, Integer.parseInt(String.valueOf(Math.round(10+(i*10)))));
            h = Math.sqrt(Math.pow(a, 2) - Math.pow((a / 2), 2) / 4);

            if (linesNextLength == 0) {
                linesNextLength = 4;
            } else {
                linesNextLength = linesNextLength * 4; // С каждой итерацией кол-во линий увеличивается в 2 раза
            }
            linesNextCnt = 0;
            linesNext = new Line2D[linesNextLength];
            j = 0;
            ln = linesDraw.length;
            for (j = 0; j < ln; j++) {

                ps = linesDraw[j].getP1();
                pe = linesDraw[j].getP2();

                Point2D pm = new Point2D.Double((ps.getX() + pe.getX()) / 2, (ps.getY() + pe.getY()) / 2);
                Point2D p1 = new Point2D.Double((2 * ps.getX() + pe.getX()) / 3, (2 * ps.getY() + pe.getY()) / 3);
                Point2D p2 = new Point2D.Double((2 * pe.getX() + ps.getX()) / 3, (2 * pe.getY() + ps.getY()) / 3);
                Point2D p3 = new Point2D.Double(
                        pm.getX() + (h * (-p2.getY() + pm.getY())) / (a / 2),
                        pm.getY() + (h * (p2.getX() - pm.getX())) / (a / 2));

                // Сохранение линий для следующей итерации обработки
                linesNext[linesNextCnt] = new Line2D.Double(ps, p1);
                //drawLine(linesNext[linesNextCnt]);
                linesNextCnt++;
                linesNext[linesNextCnt] = new Line2D.Double(p1, p3);
                drawLine(linesNext[linesNextCnt]);
                linesNextCnt++;
                linesNext[linesNextCnt] = new Line2D.Double(p3, p2);
                drawLine(linesNext[linesNextCnt]);
                linesNextCnt++;
                linesNext[linesNextCnt] = new Line2D.Double(p2, pe);
                //drawLine(linesNext[linesNextCnt]);
                linesNextCnt++;
            }
        }
    }

    /** Нарисовать кривую Коха на основе линии line.
     * Колическтво итераций - maxIter. Текущая итерация рекурсии - curIter.
     *
     * Рекурсивный алгоритм.
     * В данном алгоритме решена проблема "стирания" среднего отрезка линии.
     * Т.е., в итоге действительно получается нарисованна только кривая,
     * без вспомогательных линий.
     * Работает немного медленней, чем с циклом и массивом,
     */
    private void drawCurveKochRecur(Line2D line, int maxIter, int curIter) {

        if (curIter == maxIter) // убрав эту проверку, будут прорисованы все линии, а не только сама кривая
            drawLine(line);

        if (curIter <= maxIter){

            double a = line.getP1().distance(line.getP2());
            a = a / 3;
            //g2.drawString(String.valueOf(a), 10, Integer.parseInt(String.valueOf(Math.round(10+(i*10)))));
            double h = Math.sqrt(Math.pow(a, 2) - Math.pow((a / 2), 2) / 4);

            Point2D ps = line.getP1();
            Point2D pe = line.getP2();

            Point2D pm = new Point2D.Double((ps.getX() + pe.getX()) / 2, (ps.getY() + pe.getY()) / 2);
            Point2D p1 = new Point2D.Double((2 * ps.getX() + pe.getX()) / 3, (2 * ps.getY() + pe.getY()) / 3);
            Point2D p2 = new Point2D.Double((2 * pe.getX() + ps.getX()) / 3, (2 * pe.getY() + ps.getY()) / 3);
            Point2D p3 = new Point2D.Double(
                    pm.getX() + (h * (-p2.getY() + pm.getY())) / (a / 2),
                    pm.getY() + (h * (p2.getX() - pm.getX())) / (a / 2)
            );

            // Рекурсия
            curIter++;
            drawCurveKochRecur(new Line2D.Double(ps,p1), maxIter, curIter);
            drawCurveKochRecur(new Line2D.Double(p1,p3), maxIter, curIter);
            drawCurveKochRecur(new Line2D.Double(p3,p2), maxIter, curIter);
            drawCurveKochRecur(new Line2D.Double(p2,pe), maxIter, curIter);

        }
    }

    private void drawCurveKochRecur(Line2D line, int maxIter) {
        drawCurveKochRecur(line, maxIter, 0);
    }

    /** Нарисовать линию */
    public void drawLine(Line2D line) {
        g2.draw(new Line2D.Double(line.getP1(), line.getP2()));
    }

    /** Run main */
    public static void main(String s[]) {
        JFrame f = new JFrame("ShapesDemo2D");
        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet applet = new CurveKoch();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(800, 800));
        f.show();
    }
}
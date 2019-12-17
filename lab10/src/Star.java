import java.awt.*;
import java.awt.geom.Path2D;

public class Star implements XmasShape {
    private int x;
    private int y;
    private Color starColor;

    Star(int x, int y, Color starColor) {
        this.x = x;
        this.y = y;
        this.starColor = starColor;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setPaint(new RadialGradientPaint(
                    new Point(x, y), 60, new float[] { 0, 1 },
                    new Color[] { Color.WHITE, Color.YELLOW }));
        g2d.fill(createStar(80, 300, 20, 60, 8, 0));
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x, y);
    }

    private static Shape createStar(double centerX, double centerY,
                                    double innerRadius, double outerRadius, int numRays,
                                    double startAngleRad)
    {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++)
        {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0)
            {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else
            {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0)
            {
                path.moveTo(centerX + relX, centerY + relY);
            }
            else
            {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }
}


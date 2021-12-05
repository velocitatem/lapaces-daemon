package velo.ladaalpha.misc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.*;

// TODO: Auto-generated Javadoc

/**
 * Simple implementation of plot. Minimal features, no dependencies besides standard libraries.
 * Options are self-descriptive, see also samples.
 *
 * @author Yuriy Guskov
 */
public class Plot {

    /**
     * The Enum Line.
     */
    public enum Line {
        /**
         * The none.
         */
        NONE,
        /**
         * The solid.
         */
        SOLID,
        /**
         * The dashed.
         */
        DASHED
    }

    /**
     * The Enum Marker.
     */
    public enum Marker {
        /**
         * The none.
         */
        NONE,
        /**
         * The circle.
         */
        CIRCLE,
        /**
         * The square.
         */
        SQUARE,
        /**
         * The diamond.
         */
        DIAMOND,
        /**
         * The column.
         */
        COLUMN,
        /**
         * The bar.
         */
        BAR
    }

    /**
     * The Enum AxisFormat.
     */
    public enum AxisFormat {
        /**
         * The number.
         */
        NUMBER,
        /**
         * The number kgm.
         */
        NUMBER_KGM,
        /**
         * The number int.
         */
        NUMBER_INT,
        /**
         * The time hm.
         */
        TIME_HM,
        /**
         * The time hms.
         */
        TIME_HMS,
        /**
         * The date.
         */
        DATE,
        /**
         * The datetime hm.
         */
        DATETIME_HM,
        /**
         * The datetime hms.
         */
        DATETIME_HMS
    }

    /**
     * The Enum LegendFormat.
     */
    public enum LegendFormat {
        /**
         * The none.
         */
        NONE,
        /**
         * The top.
         */
        TOP,
        /**
         * The right.
         */
        RIGHT,
        /**
         * The bottom.
         */
        BOTTOM
    }

    /**
     * The Enum HorizAlign.
     */
    private enum HorizAlign {
        /**
         * The left.
         */
        LEFT,
        /**
         * The center.
         */
        CENTER,
        /**
         * The right.
         */
        RIGHT
    }

    /**
     * The Enum VertAlign.
     */
    private enum VertAlign {
        /**
         * The top.
         */
        TOP,
        /**
         * The center.
         */
        CENTER,
        /**
         * The bottom.
         */
        BOTTOM
    }

    /**
     * The opts.
     */
    private PlotOptions opts = new PlotOptions();

    /**
     * The bound rect.
     */
    private final Rectangle boundRect;

    /**
     * The plot area.
     */
    private final PlotArea plotArea;

    /**
     * The x axes.
     */
    private final Map<String, Axis> xAxes = new HashMap<String, Axis>(3);

    /**
     * The y axes.
     */
    private final Map<String, Axis> yAxes = new HashMap<String, Axis>(3);

    /**
     * The data series map.
     */
    private final Map<String, DataSeries> dataSeriesMap = new LinkedHashMap<String, DataSeries>(5);

    /**
     * Plot.
     *
     * @param opts the opts
     * @return the plot
     */
    public static Plot plot(PlotOptions opts) {
        return new Plot(opts);
    }

    /**
     * Plot opts.
     *
     * @return the plot options
     */
    public static PlotOptions plotOpts() {
        return new PlotOptions();
    }

    /**
     * The Class PlotOptions.
     */
    public static class PlotOptions {

        /**
         * The title.
         */
        private String title = "";

        /**
         * The width.
         */
        private int width = 800;

        /**
         * The height.
         */
        private int height = 600;

        /**
         * The background color.
         */
        private Color backgroundColor = Color.WHITE;

        /**
         * The foreground color.
         */
        private Color foregroundColor = Color.BLACK;

        /**
         * The title font.
         */
        private Font titleFont = new Font("Arial", Font.BOLD, 16);

        /**
         * The padding.
         */
        private int padding = 10; // padding for the entire image

        /**
         * The plot padding.
         */
        private int plotPadding = 5; // padding for plot area (to have min and max values padded)

        /**
         * The label padding.
         */
        private int labelPadding = 10;

        /**
         * The default legend sign size.
         */
        private final int defaultLegendSignSize = 10;

        /**
         * The legend sign size.
         */
        private int legendSignSize = 10;

        /**
         * The grids.
         */
        private Point grids = new Point(10, 10); // grid lines by x and y

        /**
         * The grid color.
         */
        private Color gridColor = Color.GRAY;

        /**
         * The grid stroke.
         */
        private Stroke gridStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, new float[]{5.0f}, 0.0f);

        /**
         * The tick size.
         */
        private int tickSize = 5;

        /**
         * The label font.
         */
        private Font labelFont = new Font("Arial", 0, 12);

        /**
         * The legend.
         */
        private LegendFormat legend = LegendFormat.NONE;

        /**
         * Instantiates a new plot options.
         */
        private PlotOptions() {
        }

        /**
         * Title.
         *
         * @param title the title
         * @return the plot options
         */
        public PlotOptions title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Width.
         *
         * @param width the width
         * @return the plot options
         */
        public PlotOptions width(int width) {
            this.width = width;
            return this;
        }

        /**
         * Height.
         *
         * @param height the height
         * @return the plot options
         */
        public PlotOptions height(int height) {
            this.height = height;
            return this;
        }

        /**
         * Bg color.
         *
         * @param color the color
         * @return the plot options
         */
        public PlotOptions bgColor(Color color) {
            this.backgroundColor = color;
            return this;
        }

        /**
         * Fg color.
         *
         * @param color the color
         * @return the plot options
         */
        public PlotOptions fgColor(Color color) {
            this.foregroundColor = color;
            return this;
        }

        /**
         * Title font.
         *
         * @param font the font
         * @return the plot options
         */
        public PlotOptions titleFont(Font font) {
            this.titleFont = font;
            return this;
        }

        /**
         * Padding.
         *
         * @param padding the padding
         * @return the plot options
         */
        public PlotOptions padding(int padding) {
            this.padding = padding;
            return this;
        }

        /**
         * Plot padding.
         *
         * @param padding the padding
         * @return the plot options
         */
        public PlotOptions plotPadding(int padding) {
            this.plotPadding = padding;
            return this;
        }

        /**
         * Label padding.
         *
         * @param padding the padding
         * @return the plot options
         */
        public PlotOptions labelPadding(int padding) {
            this.labelPadding = padding;
            return this;
        }

        /**
         * Label font.
         *
         * @param font the font
         * @return the plot options
         */
        public PlotOptions labelFont(Font font) {
            this.labelFont = font;
            return this;
        }

        /**
         * Grids.
         *
         * @param byX the by X
         * @param byY the by Y
         * @return the plot options
         */
        public PlotOptions grids(int byX, int byY) {
            this.grids = new Point(byX, byY);
            return this;
        }

        /**
         * Grid color.
         *
         * @param color the color
         * @return the plot options
         */
        public PlotOptions gridColor(Color color) {
            this.gridColor = color;
            return this;
        }

        /**
         * Grid stroke.
         *
         * @param stroke the stroke
         * @return the plot options
         */
        public PlotOptions gridStroke(Stroke stroke) {
            this.gridStroke = stroke;
            return this;
        }

        /**
         * Tick size.
         *
         * @param value the value
         * @return the plot options
         */
        public PlotOptions tickSize(int value) {
            this.tickSize = value;
            return this;
        }

        /**
         * Legend.
         *
         * @param legend the legend
         * @return the plot options
         */
        public PlotOptions legend(LegendFormat legend) {
            this.legend = legend;
            return this;
        }

    }

    /**
     * Instantiates a new plot.
     *
     * @param opts the opts
     */
    private Plot(PlotOptions opts) {
        if (opts != null)
            this.opts = opts;
        boundRect = new Rectangle(0, 0, this.opts.width, this.opts.height);
        plotArea = new PlotArea();
    }

    /**
     * Opts.
     *
     * @return the plot options
     */
    public PlotOptions opts() {
        return opts;
    }

    /**
     * X axis.
     *
     * @param name the name
     * @param opts the opts
     * @return the plot
     */
    public Plot xAxis(String name, AxisOptions opts) {
        xAxes.put(name, new Axis(name, opts));
        return this;
    }

    /**
     * Y axis.
     *
     * @param name the name
     * @param opts the opts
     * @return the plot
     */
    public Plot yAxis(String name, AxisOptions opts) {
        yAxes.put(name, new Axis(name, opts));
        return this;
    }

    /**
     * Series.
     *
     * @param name the name
     * @param data the data
     * @param opts the opts
     * @return the plot
     */
    public Plot series(String name, Data data, DataSeriesOptions opts) {
        DataSeries series = dataSeriesMap.get(name);
        if (opts != null)
            opts.setPlot(this);
        if (series == null) {
            series = new DataSeries(name, data, opts);
            dataSeriesMap.put(name, series);
        } else {
            series.data = data;
            series.opts = opts;
        }
        return this;
    }

    /**
     * Series.
     *
     * @param name the name
     * @param opts the opts
     * @return the plot
     */
    public Plot series(String name, DataSeriesOptions opts) {
        DataSeries series = dataSeriesMap.get(name);
        if (opts != null)
            opts.setPlot(this);
        if (series != null)
            series.opts = opts;
        return this;
    }

    /**
     * Calc.
     *
     * @param g the g
     */
    private void calc(Graphics2D g) {
        plotArea.calc(g);
    }

    /**
     * Clear.
     */
    private void clear() {
        plotArea.clear();
        for (DataSeries series : dataSeriesMap.values())
            series.clear();
    }

    /**
     * Draw.
     *
     * @return the buffered image
     */
    private BufferedImage draw() {
        BufferedImage image = new BufferedImage(opts.width, opts.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        try {
            calc(g);
            drawBackground(g);
            plotArea.draw(g);
            for (DataSeries series : dataSeriesMap.values())
                series.draw(g);
            return image;
        } finally {
            g.dispose();
        }
    }

    /**
     * Draw background.
     *
     * @param g the g
     */
    private void drawBackground(Graphics2D g) {
        g.setColor(opts.backgroundColor);
        g.fillRect(0, 0, opts.width, opts.height);
    }

    /**
     * Save.
     *
     * @param fileName the file name
     * @param type     the type
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void save(String fileName, String type) throws IOException {
        clear();
        BufferedImage bi = draw();
        File outputFile = new File(fileName + "." + type);
        ImageIO.write(bi, type, outputFile);
    }

    /**
     * The Class Legend.
     */
    private class Legend {

        /**
         * The rect.
         */
        Rectangle rect;

        /**
         * The label rect.
         */
        Rectangle2D labelRect;

        /**
         * The entry width.
         */
        public int entryWidth;

        /**
         * The entry width padded.
         */
        public int entryWidthPadded;

        /**
         * The entry count.
         */
        public int entryCount;

        /**
         * The x count.
         */
        public int xCount;

        /**
         * The y count.
         */
        public int yCount;
    }

    /**
     * The Class PlotArea.
     */
    private class PlotArea {

        /**
         * The plot border rect.
         */
        private final Rectangle plotBorderRect = new Rectangle(); // boundRect | labels/legend | plotBorderRect | plotPadding | plotRect/clipRect

        /**
         * The plot rect.
         */
        private final Rectangle plotRect = new Rectangle();

        /**
         * The plot clip rect.
         */
        private final Rectangle plotClipRect = new Rectangle();

        /**
         * The legend.
         */
        private final Legend legend = new Legend();

        /**
         * The x plot range.
         */
        private final Range xPlotRange = new Range(0, 0);

        /**
         * The y plot range.
         */
        private final Range yPlotRange = new Range(0, 0);

        /**
         * Instantiates a new plot area.
         */
        public PlotArea() {
            clear();
        }

        /**
         * Clear.
         */
        private void clear() {
            plotBorderRect.setBounds(boundRect);
            plotRectChanged();
        }

        /**
         * Offset.
         *
         * @param dx the dx
         * @param dy the dy
         * @param dw the dw
         * @param dh the dh
         */
        private void offset(int dx, int dy, int dw, int dh) {
            plotBorderRect.translate(dx, dy);
            plotBorderRect.setSize(plotBorderRect.width - dx - dw, plotBorderRect.height - dy - dh);
            plotRectChanged();
        }

        /**
         * Plot rect changed.
         */
        private void plotRectChanged() {
            plotRect.setBounds(plotBorderRect.x + opts.plotPadding, plotBorderRect.y + opts.plotPadding,
                    plotBorderRect.width - opts.plotPadding * 2, plotBorderRect.height - opts.plotPadding * 2);
            xPlotRange.setMin(plotRect.getX());
            xPlotRange.setMax(plotRect.getX() + plotRect.getWidth());
            yPlotRange.setMin(plotRect.getY());
            yPlotRange.setMax(plotRect.getY() + plotRect.getHeight());

            plotClipRect.setBounds(plotBorderRect.x + 1, plotBorderRect.y + 1, plotBorderRect.width - 1, plotBorderRect.height - 1);
        }

        /**
         * Calc.
         *
         * @param g the g
         */
        private void calc(Graphics2D g) {
            calcAxes(g);
            calcRange(true);
            calcRange(false);
            calcAxisLabels(g, true);
            calcAxisLabels(g, false);
            g.setFont(opts.titleFont);
            FontMetrics fm = g.getFontMetrics();
            Rectangle2D titleRect = fm.getStringBounds(opts.title, g);
            g.setFont(opts.labelFont);
            fm = g.getFontMetrics();
            int xAxesHeight = 0, xAxesHalfWidth = 0;
            for (Map.Entry<String, Axis> entry : xAxes.entrySet()) {
                Axis xAxis = entry.getValue();
                xAxesHeight += toInt(xAxis.labelRect.getHeight()) + opts.labelPadding * 2;
                if (xAxis.labelRect.getWidth() > xAxesHalfWidth)
                    xAxesHalfWidth = toInt(xAxis.labelRect.getWidth());
            }
            int yAxesWidth = 0;
            for (Map.Entry<String, Axis> entry : yAxes.entrySet())
                yAxesWidth += toInt(entry.getValue().labelRect.getWidth()) + opts.labelPadding * 2;
            int dx = opts.padding + yAxesWidth;
            int dy = opts.padding + toInt(titleRect.getHeight() + opts.labelPadding);
            int dw = opts.padding;
            if (opts.legend != LegendFormat.RIGHT)
                dw += xAxesHalfWidth; // half of label goes beyond a plot in right bottom corner
            int dh = opts.padding + xAxesHeight;
            // offset for legend
            Rectangle temp = new Rectangle(plotBorderRect); // save plotRect
            offset(dx, dy, dw, dh);
            calcLegend(g); // use plotRect
            plotBorderRect.setBounds(temp); // restore plotRect
            switch (opts.legend) {
                case TOP:
                    dy += legend.rect.height + opts.labelPadding;
                    break;
                case RIGHT:
                    dw += legend.rect.width + opts.labelPadding;
                    break;
                case BOTTOM:
                    dh += legend.rect.height;
                    break;
                default:
            }
            offset(dx, dy, dw, dh);
        }

        /**
         * Draw.
         *
         * @param g the g
         */
        private void draw(Graphics2D g) {
            drawPlotArea(g);
            drawGrid(g);
            drawAxes(g);
            drawLegend(g);
            // if check needed that content is inside padding
            //g.setColor(Color.GRAY);
            //g.drawRect(boundRect.x + opts.padding, boundRect.y + opts.padding, boundRect.width - opts.padding * 2, boundRect.height - opts.padding * 2);
        }

        /**
         * Draw plot area.
         *
         * @param g the g
         */
        private void drawPlotArea(Graphics2D g) {
            g.setColor(opts.foregroundColor);
            g.drawRect(plotBorderRect.x, plotBorderRect.y, plotBorderRect.width, plotBorderRect.height);
            g.setFont(opts.titleFont);
            drawLabel(g, opts.title, plotBorderRect.x + toInt(plotBorderRect.getWidth() / 2), opts.padding, HorizAlign.CENTER, VertAlign.TOP);
        }

        /**
         * Draw grid.
         *
         * @param g the g
         */
        private void drawGrid(Graphics2D g) {
            Stroke stroke = g.getStroke();
            g.setStroke(opts.gridStroke);
            g.setColor(opts.gridColor);

            int leftX = plotBorderRect.x + 1;
            int rightX = plotBorderRect.x + plotBorderRect.width - 1;
            int topY = plotBorderRect.y + 1;
            int bottomY = plotBorderRect.y + plotBorderRect.height - 1;

            for (int i = 0; i < opts.grids.x + 1; i++) {
                int x = toInt(plotRect.x + (plotRect.getWidth() / opts.grids.x) * i);
                g.drawLine(x, topY, x, bottomY);
            }

            for (int i = 0; i < opts.grids.y + 1; i++) {
                int y = toInt(plotRect.y + (plotRect.getHeight() / opts.grids.y) * i);
                g.drawLine(leftX, y, rightX, y);
            }

            g.setStroke(stroke);
        }

        /**
         * Calc axes.
         *
         * @param g the g
         */
        private void calcAxes(Graphics2D g) {
            Axis xAxis = xAxes.isEmpty() ? new Axis("", null) : xAxes.values().iterator().next();
            Axis yAxis = yAxes.isEmpty() ? new Axis("", null) : yAxes.values().iterator().next();
            int xCount = 0, yCount = 0;
            for (DataSeries series : dataSeriesMap.values()) {
                if (series.opts.xAxis == null) {
                    series.opts.xAxis = xAxis;
                    xCount++;
                }
                if (series.opts.yAxis == null) {
                    series.opts.yAxis = yAxis;
                    yCount++;
                }
                series.addAxesToName();
            }
            if (xAxes.isEmpty() && xCount > 0)
                xAxes.put("x", xAxis);
            if (yAxes.isEmpty() && yCount > 0)
                yAxes.put("y", yAxis);
        }

        /**
         * Calc axis labels.
         *
         * @param g   the g
         * @param isX the is X
         */
        private void calcAxisLabels(Graphics2D g, boolean isX) {
            FontMetrics fm = g.getFontMetrics();
            Rectangle2D rect = null;
            double w = 0, h = 0;
            Map<String, Axis> axes = isX ? xAxes : yAxes;
            int grids = isX ? opts.grids.x : opts.grids.y;
            for (Map.Entry<String, Axis> entry : axes.entrySet()) {
                Axis axis = entry.getValue();
                axis.labels = new String[grids + 1];
                axis.labelRect = fm.getStringBounds("", g);
                double xStep = axis.opts.range.diff / grids;
                for (int j = 0; j < grids + 1; j++) {
                    axis.labels[j] = formatDouble(axis.opts.range.min + xStep * j, axis.opts.format);
                    rect = fm.getStringBounds(axis.labels[j], g);
                    if (rect.getWidth() > w)
                        w = rect.getWidth();
                    if (rect.getHeight() > h)
                        h = rect.getHeight();
                }
                axis.labelRect.setRect(0, 0, w, h);
            }
        }

        /**
         * Calc range.
         *
         * @param isX the is X
         */
        private void calcRange(boolean isX) {
            for (DataSeries series : dataSeriesMap.values()) {
                Axis axis = isX ? series.opts.xAxis : series.opts.yAxis;
                if (axis.opts.dynamicRange) {
                    Range range = isX ? series.xRange() : series.yRange();
                    if (axis.opts.range == null)
                        axis.opts.range = range;
                    else {
                        if (range.max > axis.opts.range.max)
                            axis.opts.range.setMax(range.max);
                        if (range.min < axis.opts.range.min)
                            axis.opts.range.setMin(range.min);
                    }
                }
            }
            Map<String, Axis> axes = isX ? xAxes : yAxes;
            for (Iterator<Axis> it = axes.values().iterator(); it.hasNext(); ) {
                Axis axis = it.next();
                if (axis.opts.range == null)
                    it.remove();
            }
        }

        /**
         * Draw axes.
         *
         * @param g the g
         */
        private void drawAxes(Graphics2D g) {
            g.setFont(opts.labelFont);
            g.setColor(opts.foregroundColor);

            int leftXPadded = plotBorderRect.x - opts.labelPadding;
            int rightX = plotBorderRect.x + plotBorderRect.width;
            int bottomY = plotBorderRect.y + plotBorderRect.height;
            int bottomYPadded = bottomY + opts.labelPadding;

            int axisOffset = 0;
            for (Map.Entry<String, Axis> entry : xAxes.entrySet()) {
                Axis axis = entry.getValue();
                double xStep = axis.opts.range.diff / opts.grids.x;

                drawLabel(g, axis.name, rightX + opts.labelPadding, bottomY + axisOffset, HorizAlign.LEFT, VertAlign.CENTER);
                g.drawLine(plotRect.x, bottomY + axisOffset, plotRect.x + plotRect.width, bottomY + axisOffset);

                for (int j = 0; j < opts.grids.x + 1; j++) {
                    int x = toInt(plotRect.x + (plotRect.getWidth() / opts.grids.x) * j);
                    drawLabel(g, formatDouble(axis.opts.range.min + xStep * j, axis.opts.format), x, bottomYPadded + axisOffset, HorizAlign.CENTER, VertAlign.TOP);
                    g.drawLine(x, bottomY + axisOffset, x, bottomY + opts.tickSize + axisOffset);
                }
                axisOffset += toInt(axis.labelRect.getHeight() + opts.labelPadding * 2);
            }

            axisOffset = 0;
            for (Map.Entry<String, Axis> entry : yAxes.entrySet()) {
                Axis axis = entry.getValue();
                double yStep = axis.opts.range.diff / opts.grids.y;

                drawLabel(g, axis.name, leftXPadded - axisOffset, plotBorderRect.y - toInt(axis.labelRect.getHeight() + opts.labelPadding), HorizAlign.RIGHT, VertAlign.CENTER);
                g.drawLine(plotBorderRect.x - axisOffset, plotRect.y + plotRect.height, plotBorderRect.x - axisOffset, plotRect.y);

                for (int j = 0; j < opts.grids.y + 1; j++) {
                    int y = toInt(plotRect.y + (plotRect.getHeight() / opts.grids.y) * j);
                    drawLabel(g, formatDouble(axis.opts.range.max - yStep * j, axis.opts.format), leftXPadded - axisOffset, y, HorizAlign.RIGHT, VertAlign.CENTER);
                    g.drawLine(plotBorderRect.x - axisOffset, y, plotBorderRect.x - opts.tickSize - axisOffset, y);
                }
                axisOffset += toInt(axis.labelRect.getWidth() + opts.labelPadding * 2);
            }
        }

        /**
         * Calc legend.
         *
         * @param g the g
         */
        private void calcLegend(Graphics2D g) {
            legend.rect = new Rectangle(0, 0);
            if (opts.legend == LegendFormat.NONE)
                return;
            int size = dataSeriesMap.size();
            if (size == 0)
                return;

            FontMetrics fm = g.getFontMetrics();
            Iterator<DataSeries> it = dataSeriesMap.values().iterator();
            legend.labelRect = fm.getStringBounds(it.next().nameWithAxes, g);
            int legendSignSize = opts.defaultLegendSignSize;
            while (it.hasNext()) {
                DataSeries series = it.next();
                Rectangle2D rect = fm.getStringBounds(series.nameWithAxes, g);
                if (rect.getWidth() > legend.labelRect.getWidth())
                    legend.labelRect.setRect(0, 0, rect.getWidth(), legend.labelRect.getHeight());
                if (rect.getHeight() > legend.labelRect.getHeight())
                    legend.labelRect.setRect(0, 0, legend.labelRect.getWidth(), rect.getHeight());
                switch (series.opts.marker) {
                    case CIRCLE:
                    case SQUARE:
                        if (series.opts.markerSize + opts.defaultLegendSignSize > legendSignSize)
                            legendSignSize = series.opts.markerSize + opts.defaultLegendSignSize;
                        break;
                    case DIAMOND:
                        if (series.getDiagMarkerSize() + opts.defaultLegendSignSize > legendSignSize)
                            legendSignSize = series.getDiagMarkerSize() + opts.defaultLegendSignSize;
                        break;
                    default:
                }
            }
            opts.legendSignSize = legendSignSize;

            legend.entryWidth = legendSignSize + opts.labelPadding + toInt(legend.labelRect.getWidth());
            legend.entryWidthPadded = legend.entryWidth + opts.labelPadding;

            switch (opts.legend) {
                case TOP:
                case BOTTOM:
                    legend.entryCount = (int) Math.floor((double) (plotBorderRect.width - opts.labelPadding) / legend.entryWidthPadded);
                    legend.xCount = size <= legend.entryCount ? size : legend.entryCount;
                    legend.yCount = size <= legend.entryCount ? 1 : (int) Math.ceil((double) size / legend.entryCount);
                    legend.rect.width = opts.labelPadding + (legend.xCount * legend.entryWidthPadded);
                    legend.rect.height = opts.labelPadding + toInt(legend.yCount * (opts.labelPadding + legend.labelRect.getHeight()));
                    legend.rect.x = plotBorderRect.x + (plotBorderRect.width - legend.rect.width) / 2;
                    if (opts.legend == LegendFormat.TOP)
                        legend.rect.y = plotBorderRect.y;
                    else
                        legend.rect.y = boundRect.height - legend.rect.height - opts.padding;
                    break;
                case RIGHT:
                    legend.rect.width = opts.labelPadding * 3 + legendSignSize + toInt(legend.labelRect.getWidth());
                    legend.rect.height = opts.labelPadding * (size + 1) + toInt(legend.labelRect.getHeight() * size);
                    legend.rect.x = boundRect.width - legend.rect.width - opts.padding;
                    legend.rect.y = plotBorderRect.y + plotBorderRect.height / 2 - legend.rect.height / 2;
                    break;
                default:
            }
        }

        /**
         * Draw legend.
         *
         * @param g the g
         */
        private void drawLegend(Graphics2D g) {
            if (opts.legend == LegendFormat.NONE)
                return;

            g.drawRect(legend.rect.x, legend.rect.y, legend.rect.width, legend.rect.height);
            int labelHeight = toInt(legend.labelRect.getHeight());
            int x = legend.rect.x + opts.labelPadding;
            int y = legend.rect.y + opts.labelPadding + labelHeight / 2;

            switch (opts.legend) {
                case TOP:
                case BOTTOM:
                    int i = 0;
                    for (DataSeries series : dataSeriesMap.values()) {
                        drawLegendEntry(g, series, x, y);
                        x += legend.entryWidthPadded;
                        if ((i + 1) % legend.xCount == 0) {
                            x = legend.rect.x + opts.labelPadding;
                            y += opts.labelPadding + labelHeight;
                        }
                        i++;
                    }
                    break;
                case RIGHT:
                    for (DataSeries series : dataSeriesMap.values()) {
                        drawLegendEntry(g, series, x, y);
                        y += opts.labelPadding + labelHeight;
                    }
                    break;
                default:
            }
        }

        /**
         * Draw legend entry.
         *
         * @param g      the g
         * @param series the series
         * @param x      the x
         * @param y      the y
         */
        private void drawLegendEntry(Graphics2D g, DataSeries series, int x, int y) {
            series.fillArea(g, x, y, x + opts.legendSignSize, y, y + opts.legendSignSize / 2);
            series.drawLine(g, x, y, x + opts.legendSignSize, y);
            series.drawMarker(g, x + opts.legendSignSize / 2, y, x, y + opts.legendSignSize / 2);
            g.setColor(opts.foregroundColor);
            drawLabel(g, series.nameWithAxes, x + opts.legendSignSize + opts.labelPadding, y, HorizAlign.LEFT, VertAlign.CENTER);
        }

    }

    /**
     * The Class Range.
     */
    public static class Range {

        /**
         * The min.
         */
        private double min;

        /**
         * The max.
         */
        private double max;

        /**
         * The diff.
         */
        private double diff;

        /**
         * Instantiates a new range.
         *
         * @param min the min
         * @param max the max
         */
        public Range(double min, double max) {
            this.min = min;
            this.max = max;
            this.diff = max - min;
        }

        /**
         * Instantiates a new range.
         *
         * @param range the range
         */
        public Range(Range range) {
            this.min = range.min;
            this.max = range.max;
            this.diff = max - min;
        }

        /**
         * Sets the min.
         *
         * @param min the new min
         */
        public void setMin(double min) {
            this.min = min;
            this.diff = max - min;
        }

        /**
         * Sets the max.
         *
         * @param max the new max
         */
        public void setMax(double max) {
            this.max = max;
            this.diff = max - min;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {
            return "Range [min=" + min + ", max=" + max + "]";
        }

    }

    /**
     * Axis opts.
     *
     * @return the axis options
     */
    public static AxisOptions axisOpts() {
        return new AxisOptions();
    }

    /**
     * The Class AxisOptions.
     */
    public static class AxisOptions {

        /**
         * The format.
         */
        private AxisFormat format = AxisFormat.NUMBER;

        /**
         * The dynamic range.
         */
        private boolean dynamicRange = true;

        /**
         * The range.
         */
        private Range range;

        /**
         * Format.
         *
         * @param format the format
         * @return the axis options
         */
        public AxisOptions format(AxisFormat format) {
            this.format = format;
            return this;
        }

        /**
         * Range.
         *
         * @param min the min
         * @param max the max
         * @return the axis options
         */
        public AxisOptions range(double min, double max) {
            this.range = new Range(min, max);
            this.dynamicRange = false;
            return this;
        }

    }

    /**
     * The Class Axis.
     */
    private class Axis {

        /**
         * The name.
         */
        private final String name;

        /**
         * The opts.
         */
        private AxisOptions opts = new AxisOptions();

        /**
         * The label rect.
         */
        private Rectangle2D labelRect;

        /**
         * The labels.
         */
        private String[] labels;

        /**
         * Instantiates a new axis.
         *
         * @param name the name
         * @param opts the opts
         */
        public Axis(String name, AxisOptions opts) {
            this.name = name;
            if (opts != null)
                this.opts = opts;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {
            return "Axis [name=" + name + ", opts=" + opts + "]";
        }

    }

    /**
     * Series opts.
     *
     * @return the data series options
     */
    public static DataSeriesOptions seriesOpts() {
        return new DataSeriesOptions();
    }

    /**
     * The Class DataSeriesOptions.
     */
    public static class DataSeriesOptions {

        /**
         * The series color.
         */
        private Color seriesColor = Color.BLUE;

        /**
         * The line.
         */
        private Line line = Line.SOLID;

        /**
         * The line width.
         */
        private int lineWidth = 2;

        /**
         * The line dash.
         */
        private float[] lineDash = new float[]{3.0f, 3.0f};

        /**
         * The marker.
         */
        private Marker marker = Marker.NONE;

        /**
         * The marker size.
         */
        private int markerSize = 10;

        /**
         * The marker color.
         */
        private Color markerColor = Color.WHITE;

        /**
         * The area color.
         */
        private Color areaColor = null;

        /**
         * The x axis name.
         */
        private String xAxisName;

        /**
         * The y axis name.
         */
        private String yAxisName;

        /**
         * The x axis.
         */
        private Axis xAxis;

        /**
         * The y axis.
         */
        private Axis yAxis;

        /**
         * Color.
         *
         * @param seriesColor the series color
         * @return the data series options
         */
        public DataSeriesOptions color(Color seriesColor) {
            this.seriesColor = seriesColor;
            return this;
        }

        /**
         * Line.
         *
         * @param line the line
         * @return the data series options
         */
        public DataSeriesOptions line(Line line) {
            this.line = line;
            return this;
        }

        /**
         * Line width.
         *
         * @param width the width
         * @return the data series options
         */
        public DataSeriesOptions lineWidth(int width) {
            this.lineWidth = width;
            return this;
        }

        /**
         * Line dash.
         *
         * @param dash the dash
         * @return the data series options
         */
        public DataSeriesOptions lineDash(float[] dash) {
            this.lineDash = dash;
            return this;
        }

        /**
         * Marker.
         *
         * @param marker the marker
         * @return the data series options
         */
        public DataSeriesOptions marker(Marker marker) {
            this.marker = marker;
            return this;
        }

        /**
         * Marker size.
         *
         * @param markerSize the marker size
         * @return the data series options
         */
        public DataSeriesOptions markerSize(int markerSize) {
            this.markerSize = markerSize;
            return this;
        }

        /**
         * Marker color.
         *
         * @param color the color
         * @return the data series options
         */
        public DataSeriesOptions markerColor(Color color) {
            this.markerColor = color;
            return this;
        }

        /**
         * Area color.
         *
         * @param color the color
         * @return the data series options
         */
        public DataSeriesOptions areaColor(Color color) {
            this.areaColor = color;
            return this;
        }

        /**
         * X axis.
         *
         * @param name the name
         * @return the data series options
         */
        public DataSeriesOptions xAxis(String name) {
            this.xAxisName = name;
            return this;
        }

        /**
         * Y axis.
         *
         * @param name the name
         * @return the data series options
         */
        public DataSeriesOptions yAxis(String name) {
            this.yAxisName = name;
            return this;
        }

        /**
         * Sets the plot.
         *
         * @param plot the new plot
         */
        private void setPlot(Plot plot) {
            if (plot != null)
                this.xAxis = plot.xAxes.get(xAxisName);
            if (plot != null)
                this.yAxis = plot.yAxes.get(yAxisName);
        }

    }

    /**
     * Data.
     *
     * @return the data
     */
    public static Data data() {
        return new Data();
    }

    /**
     * The Class Data.
     */
    public static class Data {

        /**
         * The x 1.
         */
        private double[] x1;

        /**
         * The y 1.
         */
        private double[] y1;

        /**
         * The x 2.
         */
        private List<Double> x2;

        /**
         * The y 2.
         */
        private List<Double> y2;

        /**
         * Instantiates a new data.
         */
        private Data() {
        }

        /**
         * Xy.
         *
         * @param x the x
         * @param y the y
         * @return the data
         */
        public Data xy(double[] x, double[] y) {
            this.x1 = x;
            this.y1 = y;
            return this;
        }

        /**
         * Xy.
         *
         * @param x the x
         * @param y the y
         * @return the data
         */
        public Data xy(double x, double y) {
            if (this.x2 == null || this.y2 == null) {
                this.x2 = new ArrayList<Double>(10);
                this.y2 = new ArrayList<Double>(10);
            }
            x2.add(x);
            y2.add(y);
            return this;
        }

        /**
         * Xy.
         *
         * @param x the x
         * @param y the y
         * @return the data
         */
        public Data xy(List<Double> x, List<Double> y) {
            this.x2 = x;
            this.y2 = y;
            return this;
        }

        /**
         * Size.
         *
         * @return the int
         */
        public int size() {
            if (x1 != null)
                return x1.length;
            if (x2 != null)
                return x2.size();
            return 0;
        }

        /**
         * X.
         *
         * @param i the i
         * @return the double
         */
        public double x(int i) {
            if (x1 != null)
                return x1[i];
            if (x2 != null)
                return x2.get(i);
            return 0;
        }

        /**
         * Y.
         *
         * @param i the i
         * @return the double
         */
        public double y(int i) {
            if (y1 != null)
                return y1[i];
            if (y2 != null)
                return y2.get(i);
            return 0;
        }

    }

    /**
     * The Class DataSeries.
     */
    public class DataSeries {

        /**
         * The name.
         */
        private final String name;

        /**
         * The name with axes.
         */
        private String nameWithAxes;

        /**
         * The opts.
         */
        private DataSeriesOptions opts = new DataSeriesOptions();

        /**
         * The data.
         */
        private Data data;

        /**
         * Instantiates a new data series.
         *
         * @param name the name
         * @param data the data
         * @param opts the opts
         */
        public DataSeries(String name, Data data, DataSeriesOptions opts) {
            if (opts != null)
                this.opts = opts;
            this.name = name;
            this.data = data;
            if (this.data == null)
                this.data = data();
        }

        /**
         * Clear.
         */
        public void clear() {
        }

        /**
         * Adds the axes to name.
         */
        private void addAxesToName() {
            this.nameWithAxes = this.name + " (" + opts.yAxis.name + "/" + opts.xAxis.name + ")";
        }

        /**
         * X range.
         *
         * @return the range
         */
        private Range xRange() {
            Range range = new Range(0, 0);
            if (data != null && data.size() > 0) {
                range = new Range(data.x(0), data.x(0));
                for (int i = 1; i < data.size(); i++) {
                    if (data.x(i) > range.max)
                        range.setMax(data.x(i));
                    if (data.x(i) < range.min)
                        range.setMin(data.x(i));
                }
            }
            return range;
        }

        /**
         * Y range.
         *
         * @return the range
         */
        private Range yRange() {
            Range range = new Range(0, 0);
            if (data != null && data.size() > 0) {
                range = new Range(data.y(0), data.y(0));
                for (int i = 1; i < data.size(); i++) {
                    if (data.y(i) > range.max)
                        range.setMax(data.y(i));
                    if (data.y(i) < range.min)
                        range.setMin(data.y(i));
                }
            }
            return range;
        }

        /**
         * Draw.
         *
         * @param g the g
         */
        private void draw(Graphics2D g) {
            g.setClip(plotArea.plotClipRect);
            if (data != null) {
                double x1 = 0, y1 = 0;
                int size = data.size();
                if (opts.line != Line.NONE)
                    for (int j = 0; j < size; j++) {
                        double x2 = x2x(data.x(j), opts.xAxis.opts.range, plotArea.xPlotRange);
                        double y2 = y2y(data.y(j), opts.yAxis.opts.range, plotArea.yPlotRange);
                        int ix1 = toInt(x1), iy1 = toInt(y1), ix2 = toInt(x2), iy2 = toInt(y2);
                        int iy3 = plotArea.plotRect.y + plotArea.plotRect.height;
                        // special case for the case when only the first point present
                        if (size == 1) {
                            ix1 = ix2;
                            iy1 = iy2;
                        }
                        if (j != 0 || size == 1) {
                            fillArea(g, ix1, iy1, ix2, iy2, iy3);
                            drawLine(g, ix1, iy1, ix2, iy2);
                        }
                        x1 = x2;
                        y1 = y2;
                    }

                int halfMarkerSize = opts.markerSize / 2;
                int halfDiagMarkerSize = getDiagMarkerSize() / 2;
                g.setStroke(new BasicStroke(2));
                if (opts.marker != Marker.NONE)
                    for (int j = 0; j < size; j++) {
                        double x2 = x2x(data.x(j), opts.xAxis.opts.range, plotArea.xPlotRange);
                        double y2 = y2y(data.y(j), opts.yAxis.opts.range, plotArea.yPlotRange);
                        drawMarker(g, halfMarkerSize, halfDiagMarkerSize, x2, y2,
                                plotArea.plotRect.x, plotArea.plotRect.y + plotArea.plotRect.height);
                    }
            }
        }

        /**
         * Gets the diag marker size.
         *
         * @return the diag marker size
         */
        private int getDiagMarkerSize() {
            return (int) Math.round(Math.sqrt(2 * opts.markerSize * opts.markerSize));
        }

        /**
         * Fill area.
         *
         * @param g   the g
         * @param ix1 the ix 1
         * @param iy1 the iy 1
         * @param ix2 the ix 2
         * @param iy2 the iy 2
         * @param iy3 the iy 3
         */
        private void fillArea(Graphics2D g, int ix1, int iy1, int ix2, int iy2, int iy3) {
            if (opts.areaColor != null) {
                g.setColor(opts.areaColor);
                g.fill(new Polygon(
                        new int[]{ix1, ix2, ix2, ix1},
                        new int[]{iy1, iy2, iy3, iy3},
                        4));
                g.setColor(opts.seriesColor);
            }
        }

        /**
         * Draw line.
         *
         * @param g   the g
         * @param ix1 the ix 1
         * @param iy1 the iy 1
         * @param ix2 the ix 2
         * @param iy2 the iy 2
         */
        private void drawLine(Graphics2D g, int ix1, int iy1, int ix2, int iy2) {
            if (opts.line != Line.NONE) {
                g.setColor(opts.seriesColor);
                setStroke(g);
                g.drawLine(ix1, iy1, ix2, iy2);
            }
        }

        /**
         * Sets the stroke.
         *
         * @param g the new stroke
         */
        private void setStroke(Graphics2D g) {
            switch (opts.line) {
                case SOLID:
                    g.setStroke(new BasicStroke(opts.lineWidth));
                    break;
                case DASHED:
                    g.setStroke(new BasicStroke(opts.lineWidth, BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND, 10.0f, opts.lineDash, 0.0f));
                    break;
                default:
            }
        }

        /**
         * Draw marker.
         *
         * @param g  the g
         * @param x2 the x 2
         * @param y2 the y 2
         * @param x3 the x 3
         * @param y3 the y 3
         */
        private void drawMarker(Graphics2D g, int x2, int y2, int x3, int y3) {
            int halfMarkerSize = opts.markerSize / 2;
            int halfDiagMarkerSize = getDiagMarkerSize() / 2;
            g.setStroke(new BasicStroke(2));
            drawMarker(g, halfMarkerSize, halfDiagMarkerSize, x2, y2, x3, y3);
        }

        /**
         * Draw marker.
         *
         * @param g                  the g
         * @param halfMarkerSize     the half marker size
         * @param halfDiagMarkerSize the half diag marker size
         * @param x2                 the x 2
         * @param y2                 the y 2
         * @param x3                 the x 3
         * @param y3                 the y 3
         */
        private void drawMarker(Graphics2D g, int halfMarkerSize, int halfDiagMarkerSize, double x2, double y2, double x3, double y3) {
            switch (opts.marker) {
                case CIRCLE:
                    g.setColor(opts.markerColor);
                    g.fillOval(toInt(x2 - halfMarkerSize), toInt(y2 - halfMarkerSize), opts.markerSize, opts.markerSize);
                    g.setColor(opts.seriesColor);
                    g.drawOval(toInt(x2 - halfMarkerSize), toInt(y2 - halfMarkerSize), opts.markerSize, opts.markerSize);
                    break;
                case SQUARE:
                    g.setColor(opts.markerColor);
                    g.fillRect(toInt(x2 - halfMarkerSize), toInt(y2 - halfMarkerSize), opts.markerSize, opts.markerSize);
                    g.setColor(opts.seriesColor);
                    g.drawRect(toInt(x2 - halfMarkerSize), toInt(y2 - halfMarkerSize), opts.markerSize, opts.markerSize);
                    break;
                case DIAMOND:
                    int[] xpts = {toInt(x2), toInt(x2 + halfDiagMarkerSize), toInt(x2), toInt(x2 - halfDiagMarkerSize)};
                    int[] ypts = {toInt(y2 - halfDiagMarkerSize), toInt(y2), toInt(y2 + halfDiagMarkerSize), toInt(y2)};
                    g.setColor(opts.markerColor);
                    g.fillPolygon(xpts, ypts, 4);
                    g.setColor(opts.seriesColor);
                    g.drawPolygon(xpts, ypts, 4);
                    break;
                case COLUMN:
                    g.setColor(opts.markerColor);
                    g.fillRect(toInt(x2), toInt(y2), opts.markerSize, toInt(y3 - y2));
                    g.setColor(opts.seriesColor);
                    g.drawRect(toInt(x2), toInt(y2), opts.markerSize, toInt(y3 - y2));
                    break;
                case BAR:
                    g.setColor(opts.markerColor);
                    g.fillRect(toInt(x3), toInt(y2), toInt(x2 - x3), opts.markerSize);
                    g.setColor(opts.seriesColor);
                    g.drawRect(toInt(x3), toInt(y2), toInt(x2 - x3), opts.markerSize);
                    break;
                default:
            }
        }

    }

    /**
     * Draw label.
     *
     * @param g      the g
     * @param s      the s
     * @param x      the x
     * @param y      the y
     * @param hAlign the h align
     * @param vAlign the v align
     */
    private static void drawLabel(Graphics2D g, String s, int x, int y, HorizAlign hAlign, VertAlign vAlign) {
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(s, g);

        // by default align by left
        if (hAlign == HorizAlign.RIGHT)
            x -= rect.getWidth();
        else if (hAlign == HorizAlign.CENTER)
            x -= rect.getWidth() / 2;

        // by default align by bottom
        if (vAlign == VertAlign.TOP)
            y += rect.getHeight();
        else if (vAlign == VertAlign.CENTER)
            y += rect.getHeight() / 2;

        g.drawString(s, x, y);
    }

    /**
     * Format double.
     *
     * @param d      the d
     * @param format the format
     * @return the string
     */
    public static String formatDouble(double d, AxisFormat format) {
        switch (format) {
            case TIME_HM:
                return String.format("%tR", new java.util.Date((long) d));
            case TIME_HMS:
                return String.format("%tT", new java.util.Date((long) d));
            case DATE:
                return String.format("%tF", new java.util.Date((long) d));
            case DATETIME_HM:
                return String.format("%tF %1$tR", new java.util.Date((long) d));
            case DATETIME_HMS:
                return String.format("%tF %1$tT", new java.util.Date((long) d));
            case NUMBER_KGM:
                return formatDoubleAsNumber(d, true);
            case NUMBER_INT:
                return Integer.toString((int) d);
            default:
                return formatDoubleAsNumber(d, false);
        }
    }

    /**
     * Format double as number.
     *
     * @param d      the d
     * @param useKGM the use KGM
     * @return the string
     */
    private static String formatDoubleAsNumber(double d, boolean useKGM) {
        if (useKGM && d > 1000 && d < 1000000000000l) {
            long[] numbers = new long[]{1000l, 1000000l, 1000000000l};
            char[] suffix = new char[]{'K', 'M', 'G'};

            int i = 0;
            double r = 0;
            for (long number : numbers) {
                r = d / number;
                if (r < 1000)
                    break;
                i++;
            }
            if (i == suffix.length)
                i--;
            return String.format("%1$,.2f%2$c", r, suffix[i]);
        } else
            return String.format("%1$.3G", d);
    }

    /**
     * X 2 x.
     *
     * @param x   the x
     * @param xr1 the xr 1
     * @param xr2 the xr 2
     * @return the double
     */
    private static double x2x(double x, Range xr1, Range xr2) {
        return xr1.diff == 0 ? xr2.min + xr2.diff / 2 : xr2.min + (x - xr1.min) / xr1.diff * xr2.diff;
    }

    /**
     * Y 2 y.
     *
     * @param x   the x
     * @param xr1 the xr 1
     * @param xr2 the xr 2
     * @return the double
     */
    // y axis is reverse in Graphics
    private static double y2y(double x, Range xr1, Range xr2) {
        return xr1.diff == 0 ? xr2.min + xr2.diff / 2 : xr2.max - (x - xr1.min) / xr1.diff * xr2.diff;
    }

    /**
     * To int.
     *
     * @param d the d
     * @return the int
     */
    private static int toInt(double d) {
        return (int) Math.round(d);
    }

}

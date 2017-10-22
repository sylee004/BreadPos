package BreadPos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import DB.saleDAO;
import DB.sale;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A simple demonstration application showing how to create a line chart using
 * data from an {@link XYDataset}.
 *
 */
public class GraphGUI extends ApplicationFrame {
	saleDAO sd = new saleDAO();
	private static ChartPanel chartPanel;

	/**
	 * Creates a new demo.
	 *
	 * @param title
	 *            the frame title.
	 */

	public GraphGUI(final String title) {

		super(title);

		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		chartPanel = new ChartPanel(chart);
		chartPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		chartPanel.setBackground(new Color(255, 255, 240));
		chartPanel.setPreferredSize(new java.awt.Dimension(400, 350)); // 표 크기
		setContentPane(chartPanel);
		chartPanel.setLayout(null);
		chartPanel.setToolTipText("아아아아");

	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
	 */
	private XYDataset createDataset() {

		XYSeries series1 = new XYSeries("rye");

		series1.add(1.0, sd.selectOneByName("rye").get(0).getSales());
		series1.add(2.0, sd.selectOneByName("rye").get(1).getSales());
		series1.add(3.0, sd.selectOneByName("rye").get(2).getSales());
		series1.add(4.0, sd.selectOneByName("rye").get(3).getSales());
		series1.add(5.0, sd.selectOneByName("rye").get(4).getSales());
		series1.add(6.0, sd.selectOneByName("rye").get(5).getSales());
		series1.add(7.0, sd.selectOneByName("rye").get(6).getSales());

		XYSeries series2 = new XYSeries("white");
		series2.add(1.0, sd.selectOneByName("white").get(0).getSales());
		series2.add(2.0, sd.selectOneByName("white").get(1).getSales());
		series2.add(3.0, sd.selectOneByName("white").get(2).getSales());
		series2.add(4.0, sd.selectOneByName("white").get(3).getSales());
		series2.add(5.0, sd.selectOneByName("white").get(4).getSales());
		series2.add(6.0, sd.selectOneByName("white").get(5).getSales());
		series2.add(7.0, sd.selectOneByName("white").get(6).getSales());

		XYSeries series3 = new XYSeries("corn");
		series3.add(1.0, sd.selectOneByName("corn").get(0).getSales());
		series3.add(2.0, sd.selectOneByName("corn").get(1).getSales());
		series3.add(3.0, sd.selectOneByName("corn").get(2).getSales());
		series3.add(4.0, sd.selectOneByName("corn").get(3).getSales());
		series3.add(5.0, sd.selectOneByName("corn").get(4).getSales());
		series3.add(6.0, sd.selectOneByName("corn").get(5).getSales());
		series3.add(7.0, sd.selectOneByName("corn").get(6).getSales());

		XYSeries series4 = new XYSeries("bori");
		series4.add(1.0, sd.selectOneByName("bori").get(0).getSales());
		series4.add(2.0, sd.selectOneByName("bori").get(1).getSales());
		series4.add(3.0, sd.selectOneByName("bori").get(2).getSales());
		series4.add(4.0, sd.selectOneByName("bori").get(3).getSales());
		series4.add(5.0, sd.selectOneByName("bori").get(4).getSales());
		series4.add(6.0, sd.selectOneByName("bori").get(5).getSales());
		series4.add(7.0, sd.selectOneByName("bori").get(6).getSales());

		XYSeries series5 = new XYSeries("mix");
		series5.add(1.0, sd.selectOneByName("mix").get(0).getSales());
		series5.add(2.0, sd.selectOneByName("mix").get(1).getSales());
		series5.add(3.0, sd.selectOneByName("mix").get(2).getSales());
		series5.add(4.0, sd.selectOneByName("mix").get(3).getSales());
		series5.add(5.0, sd.selectOneByName("mix").get(4).getSales());
		series5.add(6.0, sd.selectOneByName("mix").get(5).getSales());
		series5.add(7.0, sd.selectOneByName("mix").get(6).getSales());

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		dataset.addSeries(series4);
		dataset.addSeries(series5);

		return dataset;

	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the data for the chart.
	 * 
	 * @return a chart.
	 */
	private JFreeChart createChart(XYDataset dataset) {

		// create the chart...
		JFreeChart chart = ChartFactory.createXYLineChart("This week's sales", // chart title
				"Date", // x axis label
				"Sell", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
		);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		chart.setBackgroundPaint(Color.WHITE); // 창 배경 색

		// final StandardLegend legend = (StandardLegend) chart.getLegend();
		// legend.setDisplaySeriesShapes(true);

		// get a reference to the plot for further customisation...
		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.WHITE); // 그래프 배경 색
		// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
		plot.setDomainGridlinePaint(Color.BLACK); // 세로 선
		plot.setRangeGridlinePaint(Color.BLACK); // 가로선

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(0, false);
		renderer.setSeriesShapesVisible(1, false);
		plot.setRenderer(renderer);

		// change the auto tick unit selection to integer units only...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;

	}

	// ****************************************************************************
	// * JFREECHART DEVELOPER GUIDE *
	// * The JFreeChart Developer Guide, written by David Gilbert, is available *
	// * to purchase from Object Refinery Limited: *
	// * *
	// * http://www.object-refinery.com/jfreechart/guide.html *
	// * *
	// * Sales are used to provide funding for the JFreeChart project - please *
	// * support us so that we can continue developing free software. *
	// ****************************************************************************

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args
	 *            ignored.
	 */
	public static void main(String[] args) {

		GraphGUI demo = new GraphGUI("이번 주 판매량");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		salesGUI salesGUI = new salesGUI();

	}

}
package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import com.placeholder.PlaceHolder;

import arbol.Nodo;
import controlador.Controlador;
import negocio.TComprobacion;
import negocio.TDatos;

/**
 * @author Guillermo Delgado Yepes
 */
public class GUIArbol  extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel arbolPanel;
	private static GUIArbol instance;
	private mxGraph graph;
	private Nodo arbol;
	private TDatos tDatos;
	
	public static GUIArbol getInstance(){
		if(instance==null)
			instance= new GUIArbol();
		return instance;
	}
	
	public GUIArbol(){
		super("Algoritmo ID3 - Guillermo Delgado Yepes");
		graph= new mxGraph();
	}	
	
	public void initView() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//PREPARA EL GRAFICO PARA ACTUALIZAR
		graph.getModel().beginUpdate();
		graph.setCellStyle("fillColor = green");
		//Estilo flechas
		Map<String, Object> edge = new HashMap<String, Object>();
	    edge.put(mxConstants.STYLE_ROUNDED, true);
	    edge.put(mxConstants.STYLE_ORTHOGONAL, false);
	    edge.put(mxConstants.STYLE_EDGE, "elbowEdgeStyle");
	    edge.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
	    edge.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
	    edge.put(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
	    edge.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
	    edge.put(mxConstants.STYLE_STROKECOLOR, "#000000");
	    edge.put(mxConstants.STYLE_FONTCOLOR, "#572364");
	    edge.put(mxConstants.STYLE_FONTSIZE, "14");
	    edge.put(mxConstants.STYLE_FONTFAMILY, "Copperplate Gothic Bold");
	    mxStylesheet edgeStyle = new mxStylesheet();
	    edgeStyle.setDefaultEdgeStyle(edge);
	    graph.setStylesheet(edgeStyle);
	    //Fin estilo flechas
		try{
			pintarArbol(arbol, graph, null);		
		}finally{
		   graph.getModel().endUpdate();
		}
		graph.setCellsMovable(false);
		graph.setCellsEditable(false);
		graph.setCellsBendable(false);
		graph.setCellsLocked(true);
		graph.setCellsSelectable(false);
		graph.setCellsResizable(true);
		mxIGraphLayout layout = new mxHierarchicalLayout(graph);
	    layout.execute(graph.getDefaultParent());
	    final mxGraphComponent graphComponent = new mxGraphComponent(graph);
      	arbolPanel = new JPanel();
		arbolPanel.add(graphComponent);
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JButton cargar = new JButton("Cargar archivos");
		cargar.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		cargar.setForeground(Color.WHITE);
		cargar.setBackground(new java.awt.Color(56, 2, 56));
		cargar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(new Contexto(Events.GUI_MAIN, null));
			}
		});
		JTextField tex = new JTextField();
		PlaceHolder placeholder = new PlaceHolder(tex, "Introduce atributos separados por comas");
		tex.setHorizontalAlignment(SwingConstants.CENTER);
		JButton comprobar = new JButton("Comprobar");
		comprobar.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		comprobar.setForeground(Color.WHITE);
		comprobar.setBackground(new java.awt.Color(56, 2, 56));
		comprobar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cadena = tex.getText();
				cadena.trim();
				String aux[] = cadena.split(",");
				if(aux.length == arbol.getAtributos().size()) {
					ArrayList<String> ejemplos = new ArrayList<>();
					for(String a : aux) {
						ejemplos.add(a);
					}
					TComprobacion tComprobacion = new TComprobacion(tDatos.getPositivo(), tDatos.getNegativo(), arbol, arbol.getAtributos(), ejemplos);
					Controlador.getInstance().accion(new Contexto(Events.COMPROBAR, tComprobacion));
				}
				else {
					JLabel label = new JLabel("Faltan atributos. Tienen que ser " + arbol.getAtributos().size());
					label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
					JOptionPane.showMessageDialog(null, label, "¡Error!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		salir.setForeground(Color.WHITE);
		salir.setBackground(new java.awt.Color(56, 2, 56));
		salir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("<html><body>Vuelve pronto<center>😄</center></body></html>");
				label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, label, "¡Hasta pronto!", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		JPanel p1 = new JPanel(new GridLayout(1, 2));
		p1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE));
		p1.add(comprobar);
		p1.add(tex);
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		p2.add(cargar);
		p2.add(salir);
		p2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE));
		cargar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE));
		salir.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE));
		panel.add(p1);
		panel.add(p2);
		panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE));
		this.add(graphComponent,BorderLayout.CENTER);
		this.add(panel,  BorderLayout.SOUTH);
		this.setSize(graphComponent.getSize());
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	private void pintarArbol(Nodo padre, mxGraph graph, Object verticePadre){		
		Object v1;		
		if(verticePadre!=null){
			v1 = verticePadre;
		}else {
			v1 = graph.insertVertex(graph.getDefaultParent(), null, padre.getNombre(),0, 0, 150,50,  padre.getNombre(), false);
		}
		graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "#572364", new Object[]{v1});
		graph.setCellStyles(mxConstants.STYLE_FONTCOLOR, "#FFFFFF", new Object[]{v1});
		graph.setCellStyles(mxConstants.STYLE_FONTFAMILY, "Copperplate Gothic Bold", new Object[]{v1});
		graph.setCellStyles(mxConstants.STYLE_FONTSIZE, "14", new Object[]{v1});
		for(Nodo edge: padre.getHijos()){
			for(Nodo vertices: edge.getHijos()) {
			   Object v2 = graph.insertVertex(graph.getDefaultParent(), null, vertices.getNombre(),0,0,150,50);
			   graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "#572364", new Object[]{v2});
			   graph.setCellStyles(mxConstants.STYLE_FONTCOLOR, "#FFFFFF", new Object[]{v2});
			   graph.setCellStyles(mxConstants.STYLE_FONTFAMILY, "Copperplate Gothic Bold", new Object[]{v2});
			   graph.setCellStyles(mxConstants.STYLE_FONTSIZE, "14", new Object[]{v2});
			   graph.insertEdge(graph.getDefaultParent(), null, edge.getNombre(), v1, v2);
			   if(vertices.getHijos().size()>0)
			   		pintarArbol(vertices, graph, v2);   	
			}
		}	
	}

	public void setArbol(Nodo arbol) {
		this.arbol = arbol;
	}

	public TDatos getTDatos() {
		return tDatos;
	}

	public void setTDatos(TDatos tDatos) {
		this.tDatos = tDatos;
	}
	
	
}

package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import arbol.Nodo;

/**
 * @author Guillermo Delgado Yepes
 */
public class GUIArbol  extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel arbolPanel;
	private static GUIArbol instance;
	private mxGraph graph;
	private Nodo arbol;
	
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
			recursivoPinta(arbol, graph, null);		
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
      	arbolPanel.setLayout(new GridLayout(1, 1));
		arbolPanel.add(graphComponent);
		this.add(graphComponent,BorderLayout.NORTH);
		this.setSize(graphComponent.getSize());
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 1));
	}

	private void recursivoPinta(Nodo padre, mxGraph graph, Object verticePadre){		
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
			   		recursivoPinta(vertices, graph, v2);   	
			}
		}	
	}

	public void setArbol(Nodo arbol) {
		this.arbol = arbol;
	}
	
}

package presentacion;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import arbol.Nodo;
import controlador.Controlador;
import negocio.TDatos;

/**
 * @author Guillermo Delgado Yepes
 */
public class GUIMainImp extends GUIMain {
	
	private TDatos tDatos;

    public GUIMainImp() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldArchivoAtributos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldArchivoEjemplos = new javax.swing.JTextField();
        jTextFieldValorPositivo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldValorNegativo = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(56, 2, 56));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 48));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Algoritmo ID3");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Guillermo Delgado Yepes");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del archivo de Atributos:");

        jTextFieldArchivoAtributos.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jTextFieldArchivoAtributos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre del archivo de Ejemplos:");

        jTextFieldArchivoEjemplos.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jTextFieldArchivoEjemplos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldValorPositivo.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jTextFieldValorPositivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valor positivo:");

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("valor negativo");

        jTextFieldValorNegativo.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jTextFieldValorNegativo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonEnviar.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12));
        jButtonEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEnviar.setText("Enviar Datos");
        jButtonEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonEnviar.setContentAreaFilled(false);
        jButtonEnviar.setName("");
        jButtonEnviar.setOpaque(false);
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14));
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setOpaque(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldArchivoEjemplos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldValorPositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(jTextFieldArchivoAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldValorNegativo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldArchivoAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldArchivoEjemplos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorPositivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValorNegativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {
    	JLabel label = new JLabel("<html><body>Vuelve pronto<center>😄</center></body></html>");
		label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		JOptionPane.showMessageDialog(null, label, "¡Hasta pronto!", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
    }

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {
    	String archivoAtributo = "", archivoEjemplo = "", positivo ="", negativo ="";
    	int nErrores = 0;
    	if(!this.jTextFieldArchivoAtributos.getText().matches("^(?!\\s*$).+")){
    		nErrores++;
    	}
    	else {
    		archivoAtributo = this.jTextFieldArchivoAtributos.getText();;
    	}
    	if(!this.jTextFieldArchivoEjemplos.getText().matches("^(?!\\s*$).+")){
    		nErrores++;
    	}
    	else {
    		archivoEjemplo = this.jTextFieldArchivoEjemplos.getText();;
    	}
    	if(!this.jTextFieldValorPositivo.getText().matches("^(?!\\s*$).+")){
    		nErrores++;
    	}
    	else {
    		positivo = this.jTextFieldValorPositivo.getText();;
    	}
    	if(!this.jTextFieldValorNegativo.getText().matches("^(?!\\s*$).+")){
    		nErrores++;
    	}
    	else {
    		negativo = this.jTextFieldValorNegativo.getText();
    	}
    	if(nErrores == 0) {
    		this.tDatos = new TDatos(archivoAtributo, archivoEjemplo, positivo, negativo);
    		Controlador.getInstance().accion(new Contexto(Events.BUSCAR_ID3, tDatos));
    	}
    	else {
    		JLabel label = new JLabel("<html><body>Todos los campos son obligatorios</body></html>");
			label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
			JOptionPane.showMessageDialog(null, label, "¡Aviso!", JOptionPane.INFORMATION_MESSAGE);
    	}
    }

    private void clearData() {
		this.jTextFieldArchivoAtributos.setText("");
		this.jTextFieldArchivoEjemplos.setText("");
		this.jTextFieldValorNegativo.setText("");
		this.jTextFieldValorPositivo.setText("");
		this.setVisible(false);
	}

	// Variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldArchivoAtributos;
    private javax.swing.JTextField jTextFieldArchivoEjemplos;
    private javax.swing.JTextField jTextFieldValorNegativo;
    private javax.swing.JTextField jTextFieldValorPositivo;
    
	@Override
	public void actualizar(Contexto contexto) {
		int evento = contexto.getEvento();
		switch(evento) {
		case(Events.GUI_MAIN):
			this.setVisible(true);
		break;
		case(Events.BUSCAR_OK):
			this.clearData();
			Nodo nodo = (Nodo) contexto.getDato();
			GUIArbol vista = new GUIArbol();
			vista.setTDatos(tDatos);
			vista.setArbol(nodo);
			vista.initView();
		break;
		case(Events.BUSCAR_KO):
			this.setVisible(true);
			int res = (int) contexto.getDato();
			switch(res){
			case(-1):
				JLabel label1 = new JLabel("<html><body>Fallo en la lectura del archivo de ejemplos</body></html>");
				label1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
				JOptionPane.showMessageDialog(null, label1, "¡Aviso!", JOptionPane.INFORMATION_MESSAGE);
			break;
			case(-2):
				JLabel label2 = new JLabel("<html><body>No coincide el valor del positivo y/o negativo</body></html>");
				label2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
				JOptionPane.showMessageDialog(null, label2,"¡Aviso!", JOptionPane.INFORMATION_MESSAGE);
			break;
			case(-3):
				JLabel label3 = new JLabel("<html><body>El numero de ejemplos de la linea no coincide con el numero de atributos</body></html>");
				label3.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
				JOptionPane.showMessageDialog(null, label3, "¡Aviso!", JOptionPane.INFORMATION_MESSAGE);
			break;
			case(-4):
				JLabel label4 = new JLabel("<html><body>Fallo en la lectura del archivo de atributos</body></html>");
				label4.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
				JOptionPane.showMessageDialog(null, label4, "¡Aviso!", JOptionPane.INFORMATION_MESSAGE);
			break;
			}
		break;
		case(Events.COMPROBAR_OK):
			JLabel label = new JLabel("El resultado es: " + (String) contexto.getDato());
			label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
			JOptionPane.showMessageDialog(null, label, "¡Aviso!", JOptionPane.INFORMATION_MESSAGE);
		break;
		case(Events.COMPROBAR_KO):
			JLabel label5 = new JLabel("Uno de los elementos no se puede evaluar");
			label5.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
			JOptionPane.showMessageDialog(null, label5, "¡Aviso!", JOptionPane.INFORMATION_MESSAGE);
		break;
		}
	}
}

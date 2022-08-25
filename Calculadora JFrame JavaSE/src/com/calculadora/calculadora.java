package com.calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculadora extends JFrame implements ActionListener{
	
	private JButton btnsum,btnres,btnmulti,btndiv,btnlimpiar,btnraiz,btnsalir,btnpot;
	private JTextField valor1,valor2,resultado;
	JLabel label1,label2;
	
	public void controles() {
		Container contenedor =  getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		JFrame frame = new JFrame("gridlayud");
		JPanel first = new JPanel(new GridLayout());
		JPanel p1 = new JPanel(new GridLayout(3,4));
		JPanel p2 = new JPanel(new GridLayout());
		JPanel p3 = new JPanel(new GridLayout());
		
		
		label1 = new JLabel("Numero 1");
		valor1 = new JTextField(10);
		first.add(valor1);
		
		label2 = new JLabel("Numero 1");
		valor2 = new JTextField(10);
		first.add(valor2);
		
		btnsum = new JButton("+");
		p1.add(btnsum);
		btnsum.addActionListener(this);
		
		btnres = new JButton("-");
		p1.add(btnres);
		btnres.addActionListener(this);
		
		btndiv = new JButton("/");
		p1.add(btndiv);
		btndiv.addActionListener(this);
		
		btnmulti = new JButton("X");
		p1.add(btnmulti);
		btnmulti.addActionListener(this);
		
		btnraiz = new JButton("Ra");
		p1.add(btnraiz);
		btnraiz.addActionListener(this);
		
		btnpot = new JButton("Pot");
		p1.add(btnpot);
		btnpot.addActionListener(this);
		
		btnlimpiar = new JButton("CE");
		p1.add(btnlimpiar);
		btnlimpiar.addActionListener(this);
		
		btnsalir = new JButton("Close");
		p3.add(btnsalir);
		btnsalir.setBackground(Color.red);
		btnsalir.addActionListener(this);
		
		resultado = new JTextField(10);
		p3.add(resultado);
		
		
		frame.add(first, BorderLayout.NORTH);
		frame.add(p1, BorderLayout.CENTER);
		frame.add(p3,  BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(300,200);
	}
	
	public calculadora () {
		super();
		
		//carga de controles
		controles();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double num1,num2,resu;
		String resultadocompa;
		//Suma
		if(e.getSource()==btnsum) {
			if(valor1.getText().equals("") || valor2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "el campo esta vacio",
						"ERROR",JOptionPane.WARNING_MESSAGE);
			}else {
				num1=Double.parseDouble(valor1.getText());
				num2=Double.parseDouble(valor2.getText());
				resu=num1+num2;
				resultadocompa = String.valueOf(resu);
				resultado.setText(resultadocompa);
			}
		}
		//resta
		if(e.getSource()==btnres) {
			if(valor1.getText().equals("") || valor2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "el campo esta vacio",
						"ERROR",JOptionPane.WARNING_MESSAGE);
			}else {
				num1=Double.parseDouble(valor1.getText());
				num2=Double.parseDouble(valor2.getText());
				resu=num1-num2;
				resultadocompa = String.valueOf(resu);
				resultado.setText(resultadocompa);
			}
		}
		//multiplicacion
		if(e.getSource()==btnmulti) {
			if(valor1.getText().equals("") || valor2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "el campo esta vacio",
						"ERROR",JOptionPane.WARNING_MESSAGE);
			}else {
				num1=Double.parseDouble(valor1.getText());
				num2=Double.parseDouble(valor2.getText());
				resu=num1*num2;
				resultadocompa = String.valueOf(resu);
				resultado.setText(resultadocompa);
			}
		}
		//division
		if(e.getSource()==btndiv) {
			if(valor1.getText().equals("") || valor2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "el campo esta vacio",
						"ERROR",JOptionPane.WARNING_MESSAGE);
			}else {
				num1=Double.parseDouble(valor1.getText());
				num2=Double.parseDouble(valor2.getText());
				resu=num1/num2;
				resultadocompa = String.valueOf(resu);
				resultado.setText(resultadocompa);
			}
		}
		//potenciacion
		if(e.getSource()==btnpot) {
			if(valor1.getText().equals("") || valor2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "el campo esta vacio",
						"ERROR",JOptionPane.WARNING_MESSAGE);
			}else {
				num1=Double.parseDouble(valor1.getText());
				num2=Double.parseDouble(valor2.getText());
				resu=Math.pow(num1, num2);
				resultadocompa = String.valueOf(resu);
				resultado.setText(resultadocompa);
			}
		}
		//raiz cuadrada
		if(e.getSource()==btnraiz) {
			if(valor1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "el campo esta vacio",
						"ERROR",JOptionPane.WARNING_MESSAGE);
			}else {
				num1=Double.parseDouble(valor1.getText());
				if(num1>= 0) {
					resu=Math.sqrt(num1);
					resultadocompa = String.valueOf(resu);
					resultado.setText(resultadocompa);
				}else {
					JOptionPane.showMessageDialog(null, "Raiz negativa",
							"ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
		}
		//limpiar
		if(e.getSource()==btnlimpiar) {
			valor1.setText("");
			valor2.setText("");
			resultado.setText("");
		}
		//salir
		if(e.getSource()==btnsalir) {
			System.exit(0);
		}
	}
	
	public static void main(String[] arg) {
		
		calculadora calc = new calculadora();
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}

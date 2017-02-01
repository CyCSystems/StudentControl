/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class Imagen extends javax.swing.JPanel {
 
    private Image Img;
    public Imagen(String ruta) {
        if (ruta != null) {
            Img = new ImageIcon(getClass().getResource(ruta)).getImage();
        }
    }
    
    public Imagen(Image imagenInicial) {
        if (imagenInicial != null) {
            Img = imagenInicial;
        }
    }

    public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
            Img = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        } else {
            Img = null;
        }
        repaint();
    }
    
    public void setImagen(Image nuevaImagen) {
        Img = nuevaImagen;
        repaint();
    }
 
    //Se crea un método cuyo parámetro debe ser un objeto Graphics
 
    @Override
    public void paint(Graphics g) {
        try{
            if (Img != null) {
                g.drawImage(Img, 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
            } else {
                setOpaque(true);
            }
            super.paint(g);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Student Control", JOptionPane.ERROR);
        }
    }
}
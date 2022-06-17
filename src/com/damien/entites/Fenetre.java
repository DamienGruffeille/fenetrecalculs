package com.damien.entites;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Fenetre.
 */
public class Fenetre extends JFrame implements ActionListener {
    // Définition des variables

    private static final String[] CHOIX = {"Somme n entiers",
                    "Carré",
                    "Factorielle"};
    // Définition des widgets
    private static JTextField txt1 = new JTextField();
    private static JButton bok = new JButton("Calculer");
    private static JLabel res = new JLabel();
    // Définition de la ComboBox
    private static JComboBox<String> cboChoix = new JComboBox<>(CHOIX);

    /**
     * Instantiates a new Fenetre.
     *
     * @throws HeadlessException the headless exception
     */
    public Fenetre() throws HeadlessException {

        super("Calculs");

        // Définition des panel
        JPanel panneauNord = new JPanel(new GridLayout(1, 1));
        JPanel panneau = new JPanel(new GridLayout(3, 2,5,5));
        //JPanel panneau1 = new JPanel(new GridLayout(3, 1, 100, 50));
        JPanel panneauBouton = new JPanel();

        // Ajout des widjets aux panels
        //panneauNord.add(new Box());
        panneau.setBorder(new EmptyBorder(20,20,20,20));
        panneau.add(new JLabel("Chiffre : ", SwingConstants.RIGHT));
        panneau.add(txt1);

        panneau.add(new JLabel("Calcul à effectuer : ", SwingConstants.RIGHT));
        cboChoix.addActionListener(this);
        panneau.add(cboChoix);

        panneau.add(new JLabel("Résultat : ", SwingConstants.RIGHT));
        panneau.add(res);


        // désactivation du bouton tant que txt1 est vide
        txt1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(final DocumentEvent e) {
                checkBtn();
            }

            @Override
            public void removeUpdate(final DocumentEvent e) {
                checkBtn();
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {
                checkBtn();
            }
        });
        bok.setEnabled(false);
        bok.setPreferredSize(new Dimension(100, 25));
        bok.addActionListener(this);
        panneauBouton.add(bok);

        // Ajout des panel au frame
        this.setLayout(new BorderLayout());
        this.add(panneauNord, BorderLayout.NORTH);
        this.add(panneau, BorderLayout.CENTER);
        //this.add(panneau1, BorderLayout.CENTER);
        this.add(panneauBouton, BorderLayout.SOUTH);

        // Définition des caractéristiques de fenetre
        this.pack();
        this.setSize(400, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    // Définition de l'état du bouton en fonction du remplissage de txt1
    private void checkBtn() {
        boolean value = !txt1.getText().trim().isEmpty();
        bok.setEnabled(value);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        String ope;
        int chiffre;

        if (e.getSource() == bok) {
            chiffre = Integer.parseInt(txt1.getText());
            ope = cboChoix.getSelectedItem().toString();

            switch (ope) {
                case "Somme n entiers" :
                    NNombre.calculer(chiffre);
                    res.setText(String.valueOf(NNombre.getRes()));
                    break;

                case "Carré" :
                    Carre.calculer(chiffre);
                    res.setText(String.valueOf(Carre.getRes()));
                    break;

                case "Factorielle" :
                    Factorielle.calculer(chiffre);
                    res.setText(String.valueOf(Factorielle.getRes()));
                    break;

                default:
            }
        }
    }
}

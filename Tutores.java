package tutores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Tutores extends JFrame {
    private JPanel tutores;
    private JButton REVISARDOCUMENTACIONButton;
    private JTable estudiantes;
    private JPanel documentacion;

    public Tutores() {
        // Crear el modelo de tabla con las columnas ID, APELLIDOS y NOMBRES
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("APELLIDOS");
        model.addColumn("NOMBRES");

        // Agregar los datos a la tabla
        String[] datos = {
                "201010022", "ACOSTA ALLAN", "ROGER GUILLERMO",
                "1708501992", "AGUILAR SOLORZANO", "DORIE DEL CARMEN",
                "1712763356", "ANATOA CARDENAS", "VERONICA ALEXANDRA",
                "1713412086", "AUCAPIÑA CHILLOGALLI", "JEANNET MARGARITA",
                "1705243168", "BALDEON HARTWIG", "JAIME FERNANDO",
                "1705321485", "BAQUERO BAQUERO", "CESAR AUGUSTO",
                "1708631013", "BELTRAN BUCHELI", "SAMARKANDA DEL ROSARIO",
                "1711178754", "BENALCAZAR MAYORGA", "JENNY VIOLETA",
                "1715318315", "BOLAÑOS PASPUEL", "MANUEL ESTEBAN",
                "1710095264", "CAMPAÑA ESPIN", "MONICA CECILIA",
                "1709567430", "CARPIO MARIA", "DOLORES",
                "1715336606", "CARRERA LAICA", "PATRICIA SOLEDAD",
                "1707566913", "CAZAR VALENCIA", "MARIA DEL CARMEN",
                "201578036", "CHACAN ESCOBAR", "VERONICA KARINA",
                "1102110648", "CHALAN PALADINEZ", "EDITT DEL CISNE",
                "1713543898", "CHANATASIG BIRACUCHA", "MAX HERNAN",
                "1716209794", "CHANCUSIG GUAYTA", "NELLY SOLEDAD",
                "1713267225", "CHILUISA CHILUISA", "VILMER IVAN",
                "801943861", "COELLO CAICEDO", "ANGELA IRENE",
                "1710987635", "ESPIN RUIZ", "GISSELA DEL PILAR",
                "1705923603", "FLORES", "LUIS ERNESTO",
                "1706869490", "FLORES MENDEZ", "JAIME EDISON",
                "1711966877", "FLORES ORELLANA", "CARLOS MANUEL",
                "1709300030", "GALARRAGA PARRA", "EDWIN GEOVANNI",
                "1708938384", "GARZON", "GIOCONDA ELIZABETH",
                "1720237336", "GOMEZ CABEZAS", "GABRIELA CRISTINA",
                "1707255525", "GOMEZ GOYES", "MARCO VINICIO",
                "1204129918", "GONZALEZ ALVARADO", "CARMEN LETICIA",
                "601546575", "GUADALUPE ARIAS", "KLEVER RODRIGO",
                "1709337719", "GUERRA RODRIGUEZ", "BORIS RAMON",
                "1707722698", "GUEVARA GODOY", "CESAR FERNANDO",
                "1717639890", "GUEVARA HIDALGO", "MARIA GABRIELA",
                "1710981513", "HARO RAMOS", "FERNANDA ISABEL",
                "1102362637", "HERRERA GARCES", "SEGUNDO ADALBERTO",
                "1002910741", "HERRERA NAVAS", "OMAR DIEGO",
                "602062135", "LEMA CARRASCO", "MANUEL FERNANDO",
                "1715581631", "LOPEZ ABRIL", "NORBERTO ADRIAN",
                "1716995616", "LOPEZ BONILLA", "CHRISTIAN ALCIDES",
                "1310193808", "LOPEZ PLUA", "MARIELA ALEXANDRA"
        };

        // Agregar los datos a la tabla
        for (int i = 0; i < datos.length; i += 3) {
            model.addRow(new String[]{datos[i], datos[i+1], datos[i+2]});
        }

        // Establecer el modelo en la tabla
        estudiantes.setModel(model);

        // Agregar ActionListener al botón REVISARDOCUMENTACIONButton
        REVISARDOCUMENTACIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada en la tabla
                int selectedRow = estudiantes.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener el ID de la fila seleccionada
                    String id = (String) estudiantes.getValueAt(selectedRow, 0);

                    // Construir la ruta del archivo PDF
                    String rutaPDF = "C:\\Users\\" + id + ".pdf";

                    // Abrir el archivo PDF en el visor predeterminado del sistema operativo
                    try {
                        File file = new File(rutaPDF);
                        if (file.exists()) {
                            Desktop.getDesktop().open(file);
                        } else {
                            JOptionPane.showMessageDialog(null, "El archivo no existe");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione una fila de la tabla");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tutores");
        frame.setContentPane(new Tutores().tutores);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}

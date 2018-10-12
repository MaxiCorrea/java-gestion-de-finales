package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.WHITE;
import static javax.swing.BorderFactory.createTitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Note;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.controller.FinalDialogController;
import ar.com.unpaz.gestionfinales.presentation.model.NoteCombo;
import ar.com.unpaz.gestionfinales.presentation.view.AddFinalDialog;

public class AddFinalDialogSwing implements AddFinalDialog {

  private JDialog dialog;
  private JButton selectSubjectButton;
  private JTextField selectedSubjectField;
  private JButton selectStudentButton;
  private JTextField selectedStudentField;
  private JComboBox<NoteCombo> comboNote;
  private JButton acceptButton;
  private JButton cancelButton;

  private Subject selectedSubject;
  private Student selectedStudent;

  public AddFinalDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(300, 280);
    dialog.setResizable(false);
    dialog.setTitle("Nuevo Final");
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    comboNote = new JComboBox<>(NoteCombo.values());
    comboNote.setBackground(WHITE);
    pane.add(comboNote);
    pane.add(createSubPanelSubject());
    pane.add(createSubPanelStudent());
    return pane;
  }

  private JPanel createSubPanelSubject() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    pane.setBorder(createTitledBorder("Materia"));
    selectSubjectButton = createButton("Seleccionar");
    selectedSubjectField = new JTextField(12);
    pane.add(selectSubjectButton);
    pane.add(selectedSubjectField);
    return pane;
  }

  private JPanel createSubPanelStudent() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    pane.setBorder(createTitledBorder("Alumno"));
    selectStudentButton = createButton("Seleccionar");
    selectedStudentField = new JTextField(12);
    pane.add(selectStudentButton);
    pane.add(selectedStudentField);
    return pane;
  }


  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    acceptButton = createButton("Guardar");
    pane.add(acceptButton);
    cancelButton = createButton("Cancelar");
    pane.add(cancelButton);
    return pane;
  }

  private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setBackground(BUTTON_BACKGROUND_COLOR);
    button.setForeground(BUTTON_FOREGROUND_COLOR);
    button.setPreferredSize(new Dimension(105, 25));
    button.setFocusPainted(false);
    return button;
  }

  @Override
  public void setFinal(Final finalObj) {
    comboNote.setSelectedIndex(finalObj.getNote().number);
    selectedStudentField.setText(finalObj.getStudent().getName());
    selectedSubjectField.setText(finalObj.getSubject().getDescription());
    comboNote.setSelectedIndex(finalObj.getNote().number);
  }

  @Override
  public Final getFinal() {
    return new Final(0, selectedSubject, selectedStudent, LocalDate.now(),
        Note.of(comboNote.getSelectedIndex()));
  }

  @Override
  public void setController(FinalDialogController controller) {
    selectStudentButton.addActionListener((ActionEvent e) -> {
      controller.selectStudent();
    });
    selectSubjectButton.addActionListener((ActionEvent e) -> {
      controller.selectSubject();
    });
    acceptButton.addActionListener((ActionEvent e) -> {
      controller.accept();
    });
    cancelButton.addActionListener((ActionEvent e) -> {
      controller.cancel();
    });
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

  @Override
  public void close() {
    dialog.dispose();
  }

  @Override
  public void setSubject(Subject subject) {
    selectedSubject = subject;
    selectedSubjectField.setText(subject.getDescription());
  }

  @Override
  public void setStudent(Student student) {
    selectedStudent = student;
    selectedStudentField.setText(student.getFullName());
  }

}

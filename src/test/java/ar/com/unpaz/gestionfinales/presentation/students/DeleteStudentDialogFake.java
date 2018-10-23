package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DeleteStudentDialogFake implements DeleteStudentDialog {

  private Student student;
  private boolean closed;
  
  @Override
  public void setController(DialogController controller) {}

  @Override
  public void setStudent(Student selected) {
    this.student = selected;
  }

  @Override
  public void show() {
    
  }

  @Override
  public void close() {
    closed = true;
  }

  public boolean isClosed() {
    return closed;
  }
  
  @Override
  public Student getStudent() {
    return student;
  }

}

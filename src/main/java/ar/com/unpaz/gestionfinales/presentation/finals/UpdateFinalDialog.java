package ar.com.unpaz.gestionfinales.presentation.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.Dialog;

public interface UpdateFinalDialog extends Dialog<Final>{

  void setStudent(Student student);

  void setSubject(Subject subject);

}
